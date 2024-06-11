package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.NatureAvoir;
import bnac.bnac_emetteur.Repositories.NatureAvoirRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NatureAvoirService {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(NatureAvoirService.class);


    @Autowired
    private NatureAvoirRepository natureAvoirRepository;

    public NatureAvoir saveNatureAvoir(NatureAvoir natureAvoir) {
        return natureAvoirRepository.save(natureAvoir);
    }

    public Optional<NatureAvoir> getNatureAvoirById(int id) {
        return natureAvoirRepository.findById(id);
    }

    public List<NatureAvoir> getAllNatureAvoirs() {
        return natureAvoirRepository.findAll();
    }

    public void deleteNatureAvoirById(int id) {
        natureAvoirRepository.deleteById(id);
    }

    public void deleteAllNatureAvoirs() {
        natureAvoirRepository.deleteAll();
    }


    public NatureAvoir updateNatureAvoir(int id, NatureAvoir natureAvoir) {
        logger.info("Updating NatureAvoir with id: {}", id);

        Optional<NatureAvoir> existingNatureAvoir = natureAvoirRepository.findById(id);
        if (existingNatureAvoir.isPresent()) {
            NatureAvoir updatedNatureAvoir = existingNatureAvoir.get();
            updatedNatureAvoir.setLibelle(natureAvoir.getLibelle());
            updatedNatureAvoir.setCodeCategorieAvoir(natureAvoir.getCodeCategorieAvoir());
            logger.info("Updated NatureAvoir: {}", updatedNatureAvoir);
            return natureAvoirRepository.save(updatedNatureAvoir);
        } else {
            logger.error("NatureAvoir not found with id: {}", id);
            throw new EntityNotFoundException("NatureAvoir not found with id " + id);
        }
    }
}

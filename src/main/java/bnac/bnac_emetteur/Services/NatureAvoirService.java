package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.NatureAvoir;
import bnac.bnac_emetteur.Repositories.NatureAvoirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NatureAvoirService {

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

    public NatureAvoir updateNatureAvoir(int id, NatureAvoir updatedNatureAvoir) {
        Optional<NatureAvoir> existingNatureAvoirOptional = natureAvoirRepository.findById(id);
        if (existingNatureAvoirOptional.isPresent()) {
            NatureAvoir existingNatureAvoir = existingNatureAvoirOptional.get();
            existingNatureAvoir.setLibelle(updatedNatureAvoir.getLibelle());
            existingNatureAvoir.setCodeCategorieAvoir(updatedNatureAvoir.getCodeCategorieAvoir());
            // You can add more fields if needed

            return natureAvoirRepository.save(existingNatureAvoir);
        } else {
            return null;
        }
    }
}

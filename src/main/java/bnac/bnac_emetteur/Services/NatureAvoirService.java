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
}

package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.NatureCompteTitre;
import bnac.bnac_emetteur.Repositories.NatureCompteTitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NatureCompteTitreService {

    @Autowired
    private NatureCompteTitreRepository natureCompteTitreRepository;

    public NatureCompteTitre saveNatureCompteTitre(NatureCompteTitre natureCompteTitre) {
        return natureCompteTitreRepository.save(natureCompteTitre);
    }

    public Optional<NatureCompteTitre> getNatureCompteTitreById(int id) {
        return natureCompteTitreRepository.findById(id);
    }

    public List<NatureCompteTitre> getAllNatureCompteTitres() {
        return natureCompteTitreRepository.findAll();
    }

    public void deleteNatureCompteTitreById(int id) {
        natureCompteTitreRepository.deleteById(id);
    }

    public void deleteAllNatureCompteTitres() {
        natureCompteTitreRepository.deleteAll();
    }
}

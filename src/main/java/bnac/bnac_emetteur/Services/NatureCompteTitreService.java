package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.NatureCompteTitre;
import bnac.bnac_emetteur.Repositories.NatureCompteTitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NatureCompteTitreService {

    @Autowired
    private NatureCompteTitreRepository natureCompteTitreRepository;


    public NatureCompteTitre saveNatureCompteTitre(NatureCompteTitre natureCompteTitre) {
        return natureCompteTitreRepository.save(natureCompteTitre);
    }


    public NatureCompteTitre getNatureCompteTitreById(int id) {
        return natureCompteTitreRepository.findById(id).orElse(null);
    }


    public List<NatureCompteTitre> getAllNatureCompteTitres() {
        return natureCompteTitreRepository.findAll();
    }


    public void deleteNatureCompteTitre(int id) {
        natureCompteTitreRepository.deleteById(id);
    }


    public NatureCompteTitre updateNatureCompteTitre(int id, NatureCompteTitre updatedNatureCompteTitre) {
        NatureCompteTitre existingNatureCompteTitre = natureCompteTitreRepository.findById(id).orElse(null);
        if (existingNatureCompteTitre != null) {
            existingNatureCompteTitre.setLibelle(updatedNatureCompteTitre.getLibelle());
            existingNatureCompteTitre.setCodeNatureCompteTitre(updatedNatureCompteTitre.getCodeNatureCompteTitre());
            return natureCompteTitreRepository.save(existingNatureCompteTitre);
        }
        return null;
    }
}

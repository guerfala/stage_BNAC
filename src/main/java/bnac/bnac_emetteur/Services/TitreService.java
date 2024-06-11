package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.NatureCompteTitre;
import bnac.bnac_emetteur.Entities.Titre;
import bnac.bnac_emetteur.Repositories.TitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitreService {

    @Autowired
    private TitreRepository titreRepository;

   /* public Titre saveTitre(Titre titre) {
        return titreRepository.save(titre);
    }*/

    public Optional<NatureCompteTitre> getTitreById(String id) {
        return titreRepository.findById(Integer.valueOf(id));
    }

    public List<NatureCompteTitre> getAllTitres() {
        return titreRepository.findAll();
    }

    public void deleteTitreById(String id) {
        titreRepository.deleteById(Integer.valueOf(id));
    }

    public void deleteAllTitres() {
        titreRepository.deleteAll();
    }
}

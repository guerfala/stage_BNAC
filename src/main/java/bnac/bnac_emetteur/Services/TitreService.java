package bnac.bnac_emetteur.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bnac.bnac_emetteur.Entities.Titre;
import bnac.bnac_emetteur.Repositories.TitreRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TitreService {

    @Autowired
    private TitreRepository titreRepository;

    public Titre saveTitre(Titre titre) {
        return titreRepository.save(titre);
    }

    public Optional<Titre> getTitreById(String id) {
        return titreRepository.findById(id);
    }

    public List<Titre> getAllTitres() {
        return titreRepository.findAll();
    }

    public void deleteTitreById(String id) {
        titreRepository.deleteById(id);
    }

    public void deleteAllTitres() {
        titreRepository.deleteAll();
    }

    public Titre updateTitre(String id, Titre updatedTitre) {
        Optional<Titre> existingTitreOptional = titreRepository.findById(id);
        if (existingTitreOptional.isPresent()) {
            Titre existingTitre = existingTitreOptional.get();
            existingTitre.setLibelleCourt(updatedTitre.getLibelleCourt());
            existingTitre.setLibelleLong(updatedTitre.getLibelleLong());
            existingTitre.setIdCategorieTitre(updatedTitre.getIdCategorieTitre());
            existingTitre.setNominal(updatedTitre.getNominal());
            existingTitre.setNombre(updatedTitre.getNombre());
            existingTitre.setPourcentage(updatedTitre.getPourcentage());
            existingTitre.setCodeStico(updatedTitre.getCodeStico());
            existingTitre.setCodeSISIN(updatedTitre.getCodeSISIN());
            existingTitre.setMatriculeDroitNonConverti(updatedTitre.getMatriculeDroitNonConverti());
            existingTitre.setMatriculeDroitConverti(updatedTitre.getMatriculeDroitConverti());
            existingTitre.setEmetteur(updatedTitre.getEmetteur());
            return titreRepository.save(existingTitre);
        } else {
            throw new IllegalArgumentException("Titre with id " + id + " not found");
        }
    }
    public List<String> getAllTitreLibelleCourt() {
        return titreRepository.findAll().stream()
                .map(Titre::getLibelleCourt)
                .collect(Collectors.toList());
    }

    public List<String> getTitresByEmetteurId(String emetteurId) {
        return titreRepository.findLibelleCourtByEmetteurId(emetteurId);
    }
    public String getIsin(String id){
        Titre titre = titreRepository.findById(id).get();
        return titre.getCodeSISIN();
    }

}

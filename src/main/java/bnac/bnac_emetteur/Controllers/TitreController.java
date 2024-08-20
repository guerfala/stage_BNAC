package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Repositories.TitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bnac.bnac_emetteur.Entities.Titre;
import bnac.bnac_emetteur.Services.TitreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bnac")
@CrossOrigin("http://localhost:4200")
public class TitreController {

  @Autowired
  private TitreService titreService;
    @Autowired

    private TitreRepository titreRepository;
    @GetMapping("/getAllTitres")
    public List<Titre> getAllTitres() {
        return titreService.getAllTitres();
    }

    @PostMapping("/createTitre")
    public ResponseEntity<Titre> createTitre(@RequestBody Titre titre) {
        Titre createdTitre = titreService.saveTitre(titre);
        return new ResponseEntity<>(createdTitre, HttpStatus.CREATED);
    }

    @GetMapping("/getTitreById/{id}")
    public ResponseEntity<Titre> getTitreById(@PathVariable String id) {
        Optional<Titre> titreOptional = titreService.getTitreById(id);
        return titreOptional.map(titre -> new ResponseEntity<>(titre, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PutMapping("/updateTitre/{id}")
    public ResponseEntity<Titre> updateTitre(@PathVariable String id, @RequestBody Titre updatedTitre) {
        Titre titre = titreService.updateTitre(id, updatedTitre);
        return new ResponseEntity<>(titre, HttpStatus.OK);
    }

    @DeleteMapping("/deleteTitreById/{id}")
    public ResponseEntity<Void> deleteTitreById(@PathVariable String id) {
        titreService.deleteTitreById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteAllTitres")
    public ResponseEntity<Void> deleteAllTitres() {
        titreService.deleteAllTitres();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/titres/{emetteurId}")
    public ResponseEntity<List<String>> getTitresByEmetteurId(@PathVariable String emetteurId) {
        List<String> titres = titreService.getTitresByEmetteurId(emetteurId);
        return ResponseEntity.ok(titres);
    }

        @GetMapping("/libelleCourtTitre")
    public ResponseEntity<List<String>> getAllTitreLibelleCourt() {
        List<String> libelleCourts = titreService.getAllTitreLibelleCourt();
        return ResponseEntity.ok(libelleCourts);
    }

    @GetMapping("/{idEmetteur}/titres")
    public List<Titre> getTitresByEmetteur(@PathVariable String idEmetteur) {
        return titreRepository.findByEmetteur_IdEmetteur(idEmetteur);
    }

    @GetMapping("/getIsinByIdTitre/{id}")
    public String getIsinByIdTitre(@PathVariable String id) {
        return titreService.getIsin(id);
    }

}

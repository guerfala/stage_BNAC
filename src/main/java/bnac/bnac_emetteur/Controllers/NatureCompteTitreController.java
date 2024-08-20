package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.NatureCompteTitre;
import bnac.bnac_emetteur.Services.NatureCompteTitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bnac")
@CrossOrigin("http://localhost:4200")
public class NatureCompteTitreController {

    @Autowired
    private NatureCompteTitreService natureCompteTitreService;
    @GetMapping("/getAllNatureCompteTitres")
    public ResponseEntity<List<NatureCompteTitre>> getAllNatureCompteTitres() {
        List<NatureCompteTitre> natureCompteTitres = natureCompteTitreService.getAllNatureCompteTitres();
        return new ResponseEntity<>(natureCompteTitres, HttpStatus.OK);
    }
    @PostMapping("/createNatureCompteTitre")
    public ResponseEntity<NatureCompteTitre> createNatureCompteTitre(@RequestBody NatureCompteTitre natureCompteTitre) {
        NatureCompteTitre savedNatureCompteTitre = natureCompteTitreService.saveNatureCompteTitre(natureCompteTitre);
        return new ResponseEntity<>(savedNatureCompteTitre, HttpStatus.CREATED);
    }

    @GetMapping("/getNatureCompteTitreById/{id}")
    public ResponseEntity<NatureCompteTitre> getNatureCompteTitreById(@PathVariable("id") int id) {
        NatureCompteTitre natureCompteTitre = natureCompteTitreService.getNatureCompteTitreById(id);
        if (natureCompteTitre != null) {
            return new ResponseEntity<>(natureCompteTitre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PutMapping("/updateNatureCompteTitre/{id}")
    public ResponseEntity<NatureCompteTitre> updateNatureCompteTitre(@PathVariable("id") int id, @RequestBody NatureCompteTitre updatedNatureCompteTitre) {
        NatureCompteTitre natureCompteTitre = natureCompteTitreService.updateNatureCompteTitre(id, updatedNatureCompteTitre);
        if (natureCompteTitre != null) {
            return new ResponseEntity<>(natureCompteTitre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteNatureCompteTitre/{id}")
    public ResponseEntity<Void> deleteNatureCompteTitre(@PathVariable("id") int id) {
        natureCompteTitreService.deleteNatureCompteTitre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

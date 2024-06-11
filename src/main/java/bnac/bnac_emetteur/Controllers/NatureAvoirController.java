package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.NatureAvoir;
import bnac.bnac_emetteur.Services.NatureAvoirService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bnac")
@AllArgsConstructor
public class NatureAvoirController {

    @Autowired
    private NatureAvoirService natureAvoirService;
    @PostMapping("/addNatureAvoir")
    public ResponseEntity<NatureAvoir> createNature(@RequestBody NatureAvoir natureAvoir) {
        // Log received object
        System.out.println("Received NatureAvoir: " + natureAvoir);

        if (natureAvoir.getCodeCategorieAvoir() == null) {
            System.out.println("CodeCategorieAvoir is null");
        }

        if (natureAvoir.getLibelle() == null) {
            System.out.println("Libelle is null");
        }

        NatureAvoir savedNatureAvoir = natureAvoirService.saveNatureAvoir(natureAvoir);
        return new ResponseEntity<>(savedNatureAvoir, HttpStatus.CREATED);
    }
    @GetMapping("/getNatureAvoirById/{id}")
    public ResponseEntity<NatureAvoir> getNatureAvoirById(@PathVariable("id") int id) {
        Optional<NatureAvoir> natureAvoirOptional = natureAvoirService.getNatureAvoirById(id);
        return natureAvoirOptional.map(natureAvoir -> new ResponseEntity<>(natureAvoir, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAllNatureAvoirs")
    public ResponseEntity<List<NatureAvoir>> getAllNatureAvoirs() {
        List<NatureAvoir> natureAvoirs = natureAvoirService.getAllNatureAvoirs();
        return new ResponseEntity<>(natureAvoirs, HttpStatus.OK);
    }

    @PutMapping("/updateNatureAvoir/{id}")
    public ResponseEntity<NatureAvoir> updateNature(@PathVariable int id, @RequestBody NatureAvoir natureAvoir) {
        NatureAvoir updatedNatureAvoir = natureAvoirService.updateNatureAvoir(id, natureAvoir);
        return new ResponseEntity<>(updatedNatureAvoir, HttpStatus.OK);
    }

    @DeleteMapping("/deleteNatureAvoir/{id}")
    public ResponseEntity<Void> deleteNatureAvoir(@PathVariable("id") int id) {
        natureAvoirService.deleteNatureAvoirById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

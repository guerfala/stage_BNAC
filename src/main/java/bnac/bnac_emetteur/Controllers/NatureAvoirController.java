package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.NatureAvoir;
import bnac.bnac_emetteur.Services.NatureAvoirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bnac")
public class NatureAvoirController {

    @Autowired
    private NatureAvoirService natureAvoirService;

    @PostMapping
    public ResponseEntity<NatureAvoir> createNatureAvoir(@RequestBody NatureAvoir natureAvoir) {
        NatureAvoir savedNatureAvoir = natureAvoirService.saveNatureAvoir(natureAvoir);
        return new ResponseEntity<>(savedNatureAvoir, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NatureAvoir> getNatureAvoirById(@PathVariable("id") int id) {
        Optional<NatureAvoir> natureAvoirOptional = natureAvoirService.getNatureAvoirById(id);
        return natureAvoirOptional.map(natureAvoir -> new ResponseEntity<>(natureAvoir, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<NatureAvoir>> getAllNatureAvoirs() {
        List<NatureAvoir> natureAvoirs = natureAvoirService.getAllNatureAvoirs();
        return new ResponseEntity<>(natureAvoirs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NatureAvoir> updateNatureAvoir(@PathVariable("id") int id, @RequestBody NatureAvoir updatedNatureAvoir) {
        NatureAvoir updatedAvoir = natureAvoirService.updateNatureAvoir(id, updatedNatureAvoir);
        if (updatedAvoir != null) {
            return new ResponseEntity<>(updatedAvoir, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNatureAvoir(@PathVariable("id") int id) {
        natureAvoirService.deleteNatureAvoirById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

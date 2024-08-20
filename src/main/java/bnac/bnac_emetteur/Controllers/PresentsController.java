package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.Presents;
import bnac.bnac_emetteur.Entities.PresentsId;
import bnac.bnac_emetteur.Services.PresentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bnac")
public class PresentsController {

    @Autowired
    private PresentsService presentsService;

    @GetMapping("/ShowAllPresents")
    public List<Presents> getAllPresents() {
        return presentsService.getAllPresents();
    }

    @GetMapping("/{idEmetteur}/{IdTypeAssemblee}/{Matricule}/{IdPresent}")
    public ResponseEntity<Presents> getPresentsById(
            @PathVariable String idEmetteur,
            @PathVariable String IdTypeAssemblee,
            @PathVariable int Matricule,
            @PathVariable int IdPresent) {

        PresentsId id = new PresentsId(idEmetteur, IdTypeAssemblee, Matricule, IdPresent);
        Optional<Presents> presents = presentsService.getPresentsById(id);
        return presents.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/NewPresents")
    public Presents createPresents(@RequestBody Presents presents) {
        return presentsService.createPresents(presents);
    }

    @PutMapping("/{idEmetteur}/{IdTypeAssemblee}/{Matricule}/{IdPresent}")
    public ResponseEntity<Presents> updatePresents(
            @PathVariable String idEmetteur,
            @PathVariable String IdTypeAssemblee,
            @PathVariable int Matricule,
            @PathVariable int IdPresent,
            @RequestBody Presents presents) {

        PresentsId id = new PresentsId(idEmetteur, IdTypeAssemblee, Matricule, IdPresent);
        Presents updatedPresents = presentsService.updatePresents(id, presents);
        return updatedPresents != null ? ResponseEntity.ok(updatedPresents) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idEmetteur}/{IdTypeAssemblee}/{Matricule}/{IdPresent}")
    public ResponseEntity<Void> deletePresents(
            @PathVariable String idEmetteur,
            @PathVariable String IdTypeAssemblee,
            @PathVariable int Matricule,
            @PathVariable int IdPresent) {

        PresentsId id = new PresentsId(idEmetteur, IdTypeAssemblee, Matricule, IdPresent);
        presentsService.deletePresents(id);
        return ResponseEntity.noContent().build();
    }
}

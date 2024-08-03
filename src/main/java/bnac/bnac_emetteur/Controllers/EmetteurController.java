package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.Emetteur;
import bnac.bnac_emetteur.Entities.Titre;
import bnac.bnac_emetteur.Repositories.TitreRepository;
import bnac.bnac_emetteur.Services.EmetteurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bnac")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class EmetteurController {

    @Autowired
    private EmetteurService emetteurService;

    // http://localhost:8081/bnac/ShowAllEmetteur
    @GetMapping("/ShowAllEmetteur")
    public List<Emetteur> ShowAllEmetteur() {
        return emetteurService.ShowAllEmetteur();
    }

    // http://localhost:8081/bnac/AddEmetteur
    @PostMapping("/AddEmetteur")
    public void AddEmetteur(@RequestBody Emetteur emetteur) {
        emetteurService.AddEmetteur(emetteur);
    }

    // http://localhost:8081/bnac/UpdateEmetteur/{emetteurId}
    @PutMapping("/UpdateEmetteur/{emetteurId}")
    public void UpdateEmetteur(@PathVariable String emetteurId, @RequestBody Emetteur emetteur) {
        emetteurService.UpdateEmetteur(emetteurId, emetteur);
    }

    // http://localhost:8081/bnac/DeleteEmetteur/{emetteurId}
    @DeleteMapping("/DeleteEmetteur/{emetteurId}")

    public void DeleteEmetteur(@PathVariable String emetteurId) {
        this.emetteurService.DeleteEmetteur(emetteurId);
    }

    @GetMapping("/libelleCourt")
    public List<String> getAllEmetteurLibelleCourt() {
        return emetteurService.getAllEmetteurLibelleCourt();
    }
}

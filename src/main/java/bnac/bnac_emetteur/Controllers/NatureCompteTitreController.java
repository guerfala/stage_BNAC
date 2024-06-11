package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.NatureCompteTitre;
import bnac.bnac_emetteur.Services.NatureCompteTitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bnac")
public class NatureCompteTitreController {

    @Autowired
    private NatureCompteTitreService natureCompteTitreService;

    @PostMapping
    public NatureCompteTitre createNatureCompteTitre(@RequestBody NatureCompteTitre natureCompteTitre) {
        return natureCompteTitreService.saveNatureCompteTitre(natureCompteTitre);
    }

    @GetMapping
    public List<NatureCompteTitre> getAllNatureCompteTitres() {
        return natureCompteTitreService.getAllNatureCompteTitres();
    }

    @GetMapping("/{id}")
    public Optional<NatureCompteTitre> getNatureCompteTitreById(@PathVariable int id) {
        return natureCompteTitreService.getNatureCompteTitreById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteNatureCompteTitreById(@PathVariable int id) {
        natureCompteTitreService.deleteNatureCompteTitreById(id);
    }

    @DeleteMapping
    public void deleteAllNatureCompteTitres() {
        natureCompteTitreService.deleteAllNatureCompteTitres();
    }
}

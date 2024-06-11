package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.NatureCompteTitre;
import bnac.bnac_emetteur.Entities.Titre;
import bnac.bnac_emetteur.Services.TitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bnac")
public class TitreController {

    @Autowired
    private TitreService titreService;

    @GetMapping("/{id}")
    public Optional<NatureCompteTitre> getTitreById(@PathVariable String id) {
        return titreService.getTitreById(id);
    }

    @GetMapping
    public List<NatureCompteTitre> getAllTitres() {
        return titreService.getAllTitres();
    }

    @DeleteMapping("/{id}")
    public void deleteTitreById(@PathVariable String id) {
        titreService.deleteTitreById(id);
    }

    @DeleteMapping
    public void deleteAllTitres() {
        titreService.deleteAllTitres();
    }
}

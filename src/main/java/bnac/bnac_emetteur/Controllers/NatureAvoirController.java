package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.NatureAvoir;
import bnac.bnac_emetteur.Services.NatureAvoirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bnac")
public class NatureAvoirController {

    @Autowired
    private NatureAvoirService natureAvoirService;

    @PostMapping
    public NatureAvoir createNatureAvoir(@RequestBody NatureAvoir natureAvoir) {
        return natureAvoirService.saveNatureAvoir(natureAvoir);
    }

    @GetMapping
    public List<NatureAvoir> getAllNatureAvoirs() {
        return natureAvoirService.getAllNatureAvoirs();
    }

    @GetMapping("/{id}")
    public Optional<NatureAvoir> getNatureAvoirById(@PathVariable int id) {
        return natureAvoirService.getNatureAvoirById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteNatureAvoirById(@PathVariable int id) {
        natureAvoirService.deleteNatureAvoirById(id);
    }

    @DeleteMapping
    public void deleteAllNatureAvoirs() {
        natureAvoirService.deleteAllNatureAvoirs();
    }
}

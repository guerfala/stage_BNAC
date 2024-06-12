package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.DTO.ActionnaireDTO;
import bnac.bnac_emetteur.Entities.Actionnaire;
import bnac.bnac_emetteur.Repositories.ActionnaireRepository;
import bnac.bnac_emetteur.Services.ActionnaireService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bnac")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ActionnaireController {
    @Autowired
    private ActionnaireService actionnaireService;

    @Autowired
    private ActionnaireRepository actionnaireRepository;

    @GetMapping("/getAllActionnaires")
    public List<Actionnaire> getAllActionnaires() {
        return actionnaireService.getAllActionnaires();
    }

    /*@GetMapping("/getFiltredActionnaires/{idEmetteur}/{idTitre}")
    public List<Actionnaire> getFiltredActionnaires(@PathVariable String idEmetteur, @PathVariable String idTitre) {
        return actionnaireService.getFiltredActionnaires(idEmetteur, idTitre);
    }*/

    @GetMapping("/filter/{idEmetteur}/{idTitre}")
    public List<ActionnaireDTO> getActionnaires(@PathVariable String idEmetteur, @PathVariable String idTitre) {
        return actionnaireRepository.findActionnaires(idEmetteur, idTitre);
    }
}

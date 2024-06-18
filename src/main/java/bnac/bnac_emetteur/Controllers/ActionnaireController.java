package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.DTO.ActionnaireDTO;
import bnac.bnac_emetteur.Entities.Actionnaire;
import bnac.bnac_emetteur.Repositories.ActionnaireRepository;
import bnac.bnac_emetteur.Services.ActionnaireService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping("/filter/{idEmetteur}/{idTitre}")
    public List<ActionnaireDTO> getActionnaires(@PathVariable String idEmetteur, @PathVariable String idTitre) {
        return actionnaireRepository.findActionnaires(idEmetteur, idTitre);
    }

    @GetMapping("/filterEtat/{idEmetteur}/{idTitre}/{selectedDate}")
    public List<ActionnaireDTO> getEtatActionnairesByEmetteurAndTitre(@PathVariable String idEmetteur, @PathVariable String idTitre, @PathVariable LocalDateTime selectedDate){
        return actionnaireRepository.findEtatActionnairesByEmetteurAndTitre(idEmetteur, idTitre, selectedDate);
    }

    @GetMapping("/filterEtat/{idEmetteur}/{idTitre}/{idTC}/{selectedDate}")
    public List<ActionnaireDTO> getEtatActionnairesByEmetteurAndTitreAndTc(@PathVariable String idEmetteur, @PathVariable String idTitre, @PathVariable String idTC, @PathVariable LocalDateTime selectedDate){
        return actionnaireRepository.findEtatActionnairesByEmetteurAndTitreAndTC(idEmetteur, idTitre, idTC, selectedDate);
    }

    @GetMapping("/filterEtat/{idEmetteur}/{idTitre}/{idTC}/{idNatureCompte}/{selectedDate}")
    public List<ActionnaireDTO> getEtatActionnairesByEmetteurAndTitreAndTcAndNc(@PathVariable String idEmetteur, @PathVariable String idTitre, @PathVariable String idTC, @PathVariable String idNatureCompte, @PathVariable LocalDateTime selectedDate){
        return actionnaireRepository.findEtatActionnairesByEmetteurAndTitreAndTCAndNatureCompte(idEmetteur, idTitre, idTC, idNatureCompte, selectedDate);
    }

    @GetMapping("/filterEtat/{idEmetteur}/{idTitre}/{idTC}/{idNatureCompte}/{idNatureAvoir}/{selectedDate}")
    public List<ActionnaireDTO> getEtatActionnairesByEmetteurAndTitreAndTcAndNcAndNa(@PathVariable String idEmetteur, @PathVariable String idTitre, @PathVariable String idTC, @PathVariable String idNatureCompte, @PathVariable String idNatureAvoir, @PathVariable LocalDateTime selectedDate){
        return actionnaireRepository.findEtatActionnairesByEmetteurAndTitreAndTCAndNatureCompteAndNatureAvoir(idEmetteur, idTitre, idTC, idNatureCompte, idNatureAvoir, selectedDate);
    }
}

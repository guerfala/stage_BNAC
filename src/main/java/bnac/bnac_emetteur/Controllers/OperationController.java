package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.DTO.ActionnaireDTO;
import bnac.bnac_emetteur.DTO.MouvementsDTO;
import bnac.bnac_emetteur.Entities.Operation;
import bnac.bnac_emetteur.Repositories.ActionnaireRepository;
import bnac.bnac_emetteur.Repositories.OperationRepo;
import bnac.bnac_emetteur.Services.OperationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bnac")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @Autowired
    private OperationRepo operationRepo;

    @Autowired
    private ActionnaireRepository actionnaireRepository;

    // http://localhost:8081/bnac/ShowAllMouvements/{idTitre}/{minDate}/{maxDate}
    @GetMapping("/ShowAllMouvements/{idTitre}/{minDate}/{maxDate}")
    public List<MouvementsDTO> ShowAllMouvements(@PathVariable String idTitre, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate){
        return operationRepo.findAllMouvements(idTitre, minDate, maxDate);
    }

    // http://localhost:8081/bnac/ShowAllOperationByTc/{idTitre}/{minDate}/{maxDate}/{idTC}
    @GetMapping("/ShowAllMouvementsByTc/{idTitre}/{minDate}/{maxDate}/{idTC}")
    public List<MouvementsDTO> ShowAllMouvementsByTc(@PathVariable String idTitre, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate, @PathVariable String idTC){
        return operationRepo.findAllMouvementsByTc(idTitre, minDate, maxDate, idTC);
    }

    // http://localhost:8081/bnac/ShowAllOperationByMatricule/{idTitre}/{minDate}/{maxDate}/{idTC}
    @GetMapping("/ShowAllMouvementsByMatricule/{idTitre}/{minDate}/{maxDate}/{matricule}")
    public List<MouvementsDTO> ShowAllMouvementsByMatricule(@PathVariable String idTitre, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate, @PathVariable int matricule){
        ActionnaireDTO actionnaireDTO = actionnaireRepository.findActionnaireMouvement(idTitre, maxDate, matricule);
        List<MouvementsDTO> mouvements = operationRepo.findAllMouvementsByMatricule(idTitre, minDate, maxDate, matricule);
        mouvements.forEach(mouvement -> {
            mouvement.setActionnaire(actionnaireDTO.getRaisonSociale());
            mouvement.setSolde(actionnaireDTO.getSolde());
        });
        return mouvements;
    }

    // http://localhost:8081/bnac/ShowAllOperationByMatricule/{idTitre}/{minDate}/{maxDate}/{idTC}
    @GetMapping("/ShowAllMouvementsByMatriculeAndTc/{idTitre}/{minDate}/{maxDate}/{matricule}/{idTC}")
    public List<MouvementsDTO> ShowAllMouvementsByMatriculeAndTc(@PathVariable String idTitre, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate, @PathVariable int matricule, @PathVariable String idTC){
        ActionnaireDTO actionnaireDTO = actionnaireRepository.findActionnaireMouvement(idTitre, maxDate, matricule);
        List<MouvementsDTO> mouvements = operationRepo.findAllMouvementsByMatriculeAndTc(idTitre, minDate, maxDate, matricule, idTC);
        mouvements.forEach(mouvement -> {
            mouvement.setActionnaire(actionnaireDTO.getRaisonSociale());
            mouvement.setSolde(actionnaireDTO.getSolde());
        });
        return mouvements;
    }
}

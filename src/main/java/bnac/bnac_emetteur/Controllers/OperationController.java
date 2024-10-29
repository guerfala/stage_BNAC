package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.DTO.ActionnaireDTO;
import bnac.bnac_emetteur.DTO.JournalDTO;
import bnac.bnac_emetteur.DTO.MouvementsDTO;
import bnac.bnac_emetteur.DTO.SoldeDTO;
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
        return operationRepo.findAllMouvementsByMatricule(idTitre, minDate, maxDate, matricule);
    }

    // http://localhost:8081/bnac/ShowAllOperationByMatricule/{idTitre}/{minDate}/{maxDate}/{idTC}
    @GetMapping("/ShowAllMouvementsByMatriculeAndTc/{idTitre}/{minDate}/{maxDate}/{matricule}/{idTC}")
    public List<MouvementsDTO> ShowAllMouvementsByMatriculeAndTc(@PathVariable String idTitre, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate, @PathVariable int matricule, @PathVariable String idTC){
        return operationRepo.findAllMouvementsByMatriculeAndTc(idTitre, minDate, maxDate, matricule, idTC);
    }

    // http://localhost:8081/bnac/ShowAllOperationByMatricule/{idTitre}/{minDate}/{maxDate}/{idTC}
    @GetMapping("/GetActionnaireMouvement/{idTitre}/{maxDate}/{matricule}")
    public SoldeDTO GetActionnaireMouvement(@PathVariable String idTitre, @PathVariable LocalDateTime maxDate, @PathVariable int matricule){
        return operationRepo.findActionnaireMouvement(idTitre, maxDate, matricule);
    }

    // http://localhost:8081/bnac/ShowAllMouvements/{idTitre}/{minDate}/{maxDate}
    @GetMapping("/ShowAllJournals/{idTitre}/{minDate}/{maxDate}")
    public List<JournalDTO> ShowAllJournals(@PathVariable String idTitre, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate){
        return operationRepo.findAllJournals(idTitre, minDate, maxDate);
    }

    // http://localhost:8081/bnac/ShowAllJournalsByTc/{idTitre}/{minDate}/{maxDate}
    @GetMapping("/ShowAllJournalsByTc/{idTitre}/{minDate}/{maxDate}/{idTc}")
    public List<JournalDTO> ShowAllJournalsByTc(@PathVariable String idTitre, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate, @PathVariable String idTc){
        return operationRepo.findAllJournalsByTc(idTitre, minDate, maxDate, idTc);
    }

    // http://localhost:8081/bnac/ShowAllJournalsByTypeOperation/{idTitre}/{minDate}/{maxDate}
    @GetMapping("/ShowAllJournalsByTypeOperation/{idTitre}/{minDate}/{maxDate}/{typeOp}")
    public List<JournalDTO> ShowAllJournalsByTypeOperation(@PathVariable String idTitre, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate, @PathVariable String typeOp){
        return operationRepo.findAllJournalsByTypeOperation(idTitre, minDate, maxDate, typeOp);
    }

    // http://localhost:8081/bnac/ShowAllJournalsByTypeOperation/{idTitre}/{minDate}/{maxDate}
    @GetMapping("/ShowAllJournalsByTypeOperationAndTc/{idTitre}/{minDate}/{maxDate}/{typeOp}/{idTc}")
    public List<JournalDTO> ShowAllJournalsByTypeOperationAndTc(@PathVariable String idTitre, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate, @PathVariable String typeOp, @PathVariable String idTc){
        return operationRepo.findAllJournalsByTypeOperationAndTc(idTitre, minDate, maxDate, typeOp, idTc);
    }

    // http://localhost:8081/bnac/ShowAllJournalsByTypeOperation/{idTitre}/{minDate}/{maxDate}
    @GetMapping("/ShowAllJournalsByMatricule/{idTitre}/{minDate}/{maxDate}/{matricule}")
    public List<JournalDTO> ShowAllJournalsByMatricule(@PathVariable String idTitre, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate, @PathVariable int matricule){
        return operationRepo.findAllJournalsByMatricule(idTitre, minDate, maxDate, matricule);
    }

    // http://localhost:8081/bnac/ShowAllJournalsByTypeOperation/{idTitre}/{minDate}/{maxDate}
    @GetMapping("/ShowAllJournalsByMatriculeAndTc/{idTitre}/{minDate}/{maxDate}/{matricule}/{idTc}")
    public List<JournalDTO> ShowAllJournalsByMatriculeAndTc(@PathVariable String idTitre, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate, @PathVariable int matricule, @PathVariable String idTc){
        return operationRepo.findAllJournalsByMatriculeAndTc(idTitre, minDate, maxDate, matricule, idTc);
    }

    // http://localhost:8081/bnac/ShowAllJournalsByTypeOperation/{idTitre}/{minDate}/{maxDate}
    @GetMapping("/ShowAllJournalsByMatriculeAndTypeOp/{idTitre}/{minDate}/{maxDate}/{matricule}/{typeOp}")
    public List<JournalDTO> ShowAllJournalsByMatriculeAndTypeOp(@PathVariable String idTitre, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate, @PathVariable int matricule, @PathVariable String typeOp){
        return operationRepo.findAllJournalsByMatriculeAndTypeOp(idTitre, minDate, maxDate, matricule, typeOp);
    }

    // http://localhost:8081/bnac/ShowAllJournalsByTypeOperation/{idTitre}/{minDate}/{maxDate}
    @GetMapping("/ShowAllJournalsByMatriculeAndByTcAndByTypeOp/{idTitre}/{minDate}/{maxDate}/{matricule}/{idTc}/{typeOp}")
    public List<JournalDTO> ShowAllJournalsByMatriculeAndByTcAndByTypeOp(@PathVariable String idTitre, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate, @PathVariable int matricule, @PathVariable String idTc, @PathVariable String typeOp){
        return operationRepo.findAllJournalsByMatriculeAndTcAndTypeOp(idTitre, minDate, maxDate, matricule, idTc, typeOp);
    }
}

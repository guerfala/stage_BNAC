package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.DTO.MouvementsDTO;
import bnac.bnac_emetteur.Entities.Operation;
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

    // http://localhost:8081/bnac/ShowAllOperation
    @GetMapping("/ShowAllOperation/{idTitre}/{minDate}/{maxDate}")
    public List<MouvementsDTO> ShowAllOperation(@PathVariable String idTitre, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate){
        return operationRepo.findAllOperation(idTitre, minDate, maxDate);
    }
}

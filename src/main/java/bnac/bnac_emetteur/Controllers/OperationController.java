package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.Operation;
import bnac.bnac_emetteur.Services.OperationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bnac")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class OperationController {

    @Autowired
    private OperationService operationService;

    // http://localhost:8081/bnac/ShowAllOperation
    @GetMapping("/ShowAllOperation")
    public List<Operation> ShowAllOperation(){
        return operationService.ShowAllOperation();
    }
}

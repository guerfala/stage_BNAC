package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.TypeOperation;
import bnac.bnac_emetteur.Services.TypeOperationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bnac")
@AllArgsConstructor
public class TypeOperationController {

    @Autowired
    private TypeOperationService typeOperationService;

    // http://localhost:8081/bnac/ShowAllTypeOperation
    @GetMapping("/ShowAllTypeOperation")
    public List<TypeOperation> ShowAllTypeOperation(){
        return typeOperationService.ShowAllTypeOperation();
    }

    // http://localhost:8081/bnac/AddTypeOperation
    @PostMapping("/AddTypeOperation")
    public void AddTypeOperation(@RequestBody TypeOperation typeOperation){
        typeOperationService.AddTypeOperation(typeOperation);
    }

    // http://localhost:8081/bnac/UpdateTypeOperation/{IdTypeOperation}
    @PutMapping("/UpdateTypeOperation/{IdTypeOperation}")
    public void UpdateTypeOperation(@PathVariable String IdTypeOperation, @RequestBody TypeOperation typeOperation){
        typeOperationService.UpdateTypeOperation(IdTypeOperation, typeOperation);
    }

    // http://localhost:8081/bnac/DeleteTypeOperation/{IdTypeOperation}
    @DeleteMapping("/DeleteTypeOperation/{IdTypeOperation}")
    public void DeleteTypeOperation(@PathVariable String IdTypeOperation){
        this.typeOperationService.DeleteTypeOperation(IdTypeOperation);
    }
}

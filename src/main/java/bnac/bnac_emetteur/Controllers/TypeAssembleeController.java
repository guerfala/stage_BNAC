package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.TypeAssemblee;
import bnac.bnac_emetteur.Services.TypeAssembleeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bnac")
public class TypeAssembleeController {

    @Autowired
    private TypeAssembleeService typeAssembleeService;

    @GetMapping("/getAllTypeAssemblees")
    public ResponseEntity<List<TypeAssemblee>> getAllTypeAssemblees() {
        List<TypeAssemblee> typeAssemblees = typeAssembleeService.getAllTypeAssemblees();
        return ResponseEntity.ok(typeAssemblees);
    }
}
package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.Assemblee;
import bnac.bnac_emetteur.Entities.TypeAssemblee;
import bnac.bnac_emetteur.Services.AssembleeService;
import bnac.bnac_emetteur.Services.TypeAssembleeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bnac")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class AssembleeController {

    @Autowired
    private AssembleeService assembleeService;
private TypeAssembleeService typeAssembleeService;
    // Create or Update Assemblee
    @PostMapping("/newAssemblee")
    public ResponseEntity<Assemblee> createAssemblee(@RequestBody Assemblee assemblee) {
        Assemblee createdAssemblee = assembleeService.createAssemblee(assemblee);
        return new ResponseEntity<>(createdAssemblee, HttpStatus.CREATED);
    }

    // Update Assemblee
    @PutMapping("/{id}")
    public ResponseEntity<Assemblee> updateAssemblee(@PathVariable int id, @RequestBody Assemblee assemblee) {
        try {
            Assemblee updatedAssemblee = assembleeService.updateAssemblee(id, assemblee);
            return new ResponseEntity<>(updatedAssemblee, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllAssemblees")
    public ResponseEntity<List<Assemblee>> getAllAssemblees() {
        List<Assemblee> assemblees = assembleeService.getAllAssemblees();
        return new ResponseEntity<>(assemblees, HttpStatus.OK);
    }

    // Get Assemblee by ID
    @GetMapping("/GetById/{id}")
    public ResponseEntity<Assemblee> getAssembleeById(@PathVariable int id) {
        Optional<Assemblee> assemblee = assembleeService.getAssembleeById(id);
        return assemblee.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete Assemblee
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<Void> deleteAssemblee(@PathVariable int id) {
        assembleeService.deleteAssemblee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAllTypeAssemblees")
    public ResponseEntity<List<TypeAssemblee>> getAllTypeAssemblees() {
        List<TypeAssemblee> typeAssemblees = typeAssembleeService.getAllTypeAssemblees();
        return new ResponseEntity<>(typeAssemblees, HttpStatus.OK);
    }
}

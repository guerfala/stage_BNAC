package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.Assemblee;
import bnac.bnac_emetteur.Entities.Emetteur;
import bnac.bnac_emetteur.Entities.TypeAssemblee;
import bnac.bnac_emetteur.Repositories.AssembleeRepository;
import bnac.bnac_emetteur.Repositories.EmetteurRepo;
import bnac.bnac_emetteur.Repositories.TypeAssembleeRepository;
import bnac.bnac_emetteur.Services.AssembleeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bnac")
@CrossOrigin("http://localhost:4200")
public class AssembleeController {

    private final AssembleeService assembleeService;
private AssembleeRepository assembleeRepository;
private EmetteurRepo emetteurRepo;
private TypeAssembleeRepository typeAssembleeRepository;

    @Autowired
    public AssembleeController(AssembleeService assembleeService, EmetteurRepo emetteurRepo,TypeAssembleeRepository typeAssembleeRepository) {
        this.assembleeService = assembleeService;
        this.emetteurRepo = emetteurRepo;
        this.typeAssembleeRepository=typeAssembleeRepository;
    }
    @GetMapping("/assemblees")
    public List<Assemblee> getAllAssemblees() {
        return assembleeService.getAllAssemblees();
    }

    @GetMapping("/assemblees/{id}")
    public Optional<Assemblee> getAssembleeById(@PathVariable int id) {
        return assembleeService.getAssembleeById(id);
    }

    @PostMapping("/newAssemblee")
    public ResponseEntity<Assemblee> createAssemblee(@RequestBody Assemblee request) {
        // Convert request to Assemblee entity
        Assemblee assemblee = new Assemblee();
        assemblee.setLibelle(request.getLibelle());
        assemblee.setDateTenue(request.getDateTenue());
        assemblee.setLieu(request.getLieu());

        // Set TypeAssemblee
        if (request.getTypeAssemblee().getIdTypeAssemblee()!= null) {
            TypeAssemblee typeAssemblee = typeAssembleeRepository.findById(request.getTypeAssemblee().getIdTypeAssemblee())
                    .orElseThrow(() -> new RuntimeException("TypeAssemblee not found"));
            assemblee.setTypeAssemblee(typeAssemblee);
        }

        // Set Emetteur
        if (request.getIdEmetteur() != null) {
            Emetteur emetteur = emetteurRepo.findById(request.getIdEmetteur())
                    .orElseThrow(() -> new RuntimeException("Emetteur not found"));
            assemblee.setEmetteur(emetteur);
        }

        // Save the Assemblee entity
        Assemblee savedAssemblee = assembleeService.saveAssemblee(assemblee);
        return new ResponseEntity<>(savedAssemblee, HttpStatus.CREATED);
    }    @PutMapping("/assemblees/{id}")
    public Assemblee updateAssemblee(@PathVariable int id, @RequestBody Assemblee assembleeDetails) {
        return assembleeService.updateAssemblee(id, assembleeDetails);
    }

    @DeleteMapping("/assemblees/{id}")
    public void deleteAssemblee(@PathVariable int id) {
        assembleeService.deleteAssemblee(id);
    }
    public void saveAssemblee(Assemblee assemblee) {
        if (assemblee.getEmetteur() == null) {
            throw new IllegalArgumentException("Emetteur cannot be null");
        }
        assembleeRepository.save(assemblee);
    }

}

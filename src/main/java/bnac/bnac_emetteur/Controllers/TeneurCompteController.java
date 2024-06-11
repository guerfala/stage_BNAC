package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.TeneurCompte;
import bnac.bnac_emetteur.Services.TeneurCompteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bnac")
@AllArgsConstructor
public class TeneurCompteController {

    @Autowired
    private TeneurCompteService teneurCompteService;

    // http://localhost:8081/bnac/ShowAllTeneurCompte
    @GetMapping("/ShowAllRooms")
    public List<TeneurCompte> ShowAllTeneurCompte(){
        return teneurCompteService.ShowAllTeneurCompte();
    }

    // http://localhost:8081/bnac/AddTeneurCompte
    @PostMapping("/AddTeneurCompte")
    public void AddTeneurCompte(@RequestBody TeneurCompte teneurCompte){
        teneurCompteService.AddTeneurCompte(teneurCompte);
    }

    // http://localhost:8081/bnac/UpdateTeneurCompte/{IdTC}
    @PutMapping("/UpdateTeneurCompte/{IdTC}")
    public void UpdateTeneurCompte(@PathVariable String IdTC, @RequestBody TeneurCompte teneurCompte){
        teneurCompteService.UpdateTeneurCompte(IdTC, teneurCompte);
    }

    // http://localhost:8081/bnac/DeleteTeneurCompte/{IdTC}
    @DeleteMapping("/DeleteTeneurCompte/{IdTC}")
    public void DeleteTeneurCompte(@PathVariable String IdTC){
        this.teneurCompteService.DeleteTeneurCompte(IdTC);
    }
}

package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.Solde;
import bnac.bnac_emetteur.Entities.SoldePk;
import bnac.bnac_emetteur.Services.SoldeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bnac")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class SoldeController {

    @Autowired
    private SoldeService soldeService;

    // http://localhost:8081/bnac/ShowAllSolde
    @GetMapping("/ShowAllSolde")
    public List<Solde> ShowAllSolde(){
        return soldeService.ShowAllSolde();
    }

    // http://localhost:8081/bnac/AddSolde
    @PostMapping("/AddSolde")
    public void AddSolde(@RequestBody Solde solde){
        soldeService.AddSolde(solde);
    }

    // http://localhost:8081/bnac/UpdateSolde/{matricule}/{idTitre}/{idTC}/{idNatureCompteTitre}/{idNatureAvoirs}
    @PutMapping("/UpdateSolde/{matricule}/{idTitre}/{idTC}/{idNatureCompteTitre}/{idNatureAvoirs}")
    public void UpdateSolde(@PathVariable int matricule, @PathVariable String idTitre, @PathVariable String idTC, @PathVariable int idNatureCompteTitre, @PathVariable int idNatureAvoirs, @RequestBody Solde solde){
        SoldePk soldePk = new SoldePk(matricule, idTitre, idTC, idNatureCompteTitre, idNatureAvoirs);
        soldeService.UpdateSolde(soldePk, solde);
    }

    // http://localhost:8081/bnac/DeleteSolde/{matricule}/{idTitre}/{idTC}/{idNatureCompteTitre}/{idNatureAvoirs}
    @DeleteMapping("/DeleteSolde/{matricule}/{idTitre}/{idTC}/{idNatureCompteTitre}/{idNatureAvoirs}")
    public void DeleteSolde(@PathVariable int matricule, @PathVariable String idTitre, @PathVariable String idTC, @PathVariable int idNatureCompteTitre, @PathVariable int idNatureAvoirs){
        SoldePk soldePk = new SoldePk(matricule, idTitre, idTC, idNatureCompteTitre, idNatureAvoirs);
        this.soldeService.DeleteSolde(soldePk);
    }
}

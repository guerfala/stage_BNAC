package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.Solde;
import bnac.bnac_emetteur.Entities.SoldePk;
import bnac.bnac_emetteur.Repositories.SoldeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldeService {

    @Autowired
    private SoldeRepo soldeRepo;

    public List<Solde> ShowAllSolde()
    {
        List<Solde> soldes = this.soldeRepo.findAll();
        return soldes;
    }

    public void AddSolde(Solde solde)
    {
        this.soldeRepo.save(solde);
    }

    public void DeleteSolde(SoldePk soldeId)
    {
        Solde solde = this.soldeRepo.findById(soldeId).get();
        this.soldeRepo.delete(solde);
    }

    public void UpdateSolde(SoldePk soldeId, Solde solde)
    {
        Solde s = this.soldeRepo.findById(soldeId).get();

        s.setSolde(solde.getSolde());
        s.setSoldeNantissement(solde.getSoldeNantissement());
        s.setDateMaj(solde.getDateMaj());
        s.setSoldeOpposition(solde.getSoldeOpposition());
        s.setCodeBO(solde.getCodeBO());

        this.soldeRepo.save(s);
    }
}

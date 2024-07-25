package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.DTO.SoldeDTO;
import bnac.bnac_emetteur.Entities.Solde;
import bnac.bnac_emetteur.Entities.SoldePk;
import bnac.bnac_emetteur.Repositories.SoldeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public List<SoldeDTO> getCapitale(String idTitre, LocalDateTime selectedDate, int pourcentage) {
        List<Object[]> results = soldeRepo.findCapitaleNative(idTitre, selectedDate);
        List<SoldeDTO> soldeDTOs = new ArrayList<>();

        for (Object[] result : results) {
            if ((double) result[2] >= pourcentage)
            {
                SoldeDTO dto = new SoldeDTO();
                dto.setMatricule((Integer) result[0]);
                dto.setRaisonSociale((String) result[1]);
                dto.setPrtage((double) result[2]);
                dto.setSolde((long) result[3]);
                soldeDTOs.add(dto);
            }

        }

        return soldeDTOs;
    }
}

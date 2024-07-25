package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.TeneurCompte;
import bnac.bnac_emetteur.Repositories.TeneurCompteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeneurCompteService {

    @Autowired
    private TeneurCompteRepo teneurCompteRepo;

    public List<TeneurCompte> ShowAllTeneurCompte()
    {
        List<TeneurCompte> teneurComptes = this.teneurCompteRepo.findAll();
        return teneurComptes;
    }

    public void AddTeneurCompte(TeneurCompte teneurCompte)
    {
        this.teneurCompteRepo.save(teneurCompte);
    }

    public void DeleteTeneurCompte(String teneurCompteId)
    {
        TeneurCompte teneurCompte = this.teneurCompteRepo.findById(teneurCompteId).get();
        this.teneurCompteRepo.delete(teneurCompte);
    }

    public void UpdateTeneurCompte(String IdTC, TeneurCompte teneurCompte)
    {
        TeneurCompte tc = this.teneurCompteRepo.findById(IdTC).get();

        tc.setLibelleCourt(teneurCompte.getLibelleCourt());
        tc.setLibelleLong(teneurCompte.getLibelleLong());
        tc.setTel(teneurCompte.getTel());
        tc.setFax(teneurCompte.getFax());
        tc.setAdresse(teneurCompte.getAdresse());
        tc.setCodePostal(teneurCompte.getCodePostal());
        tc.setVille(teneurCompte.getVille());
        tc.setEmail(teneurCompte.getEmail());
        tc.setContact(teneurCompte.getContact());
        tc.setFonctionContact(teneurCompte.getFonctionContact());
        tc.setPremierResponsable(teneurCompte.getPremierResponsable());
        tc.setFonctionPremierResponsable(teneurCompte.getFonctionPremierResponsable());
        tc.setCivilitePremierResponsable(teneurCompte.getCivilitePremierResponsable());
        tc.setId_Emetteur(teneurCompte.getId_Emetteur());
        tc.setCodeIAA(teneurCompte.getCodeIAA());

        this.teneurCompteRepo.save(tc);
    }
}

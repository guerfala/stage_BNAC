package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.Emetteur;
import bnac.bnac_emetteur.Repositories.EmetteurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmetteurService {

    @Autowired
    private EmetteurRepo emetteurRepo;

    public List<Emetteur> ShowAllEmetteur()
    {
        List<Emetteur> emetteurs = this.emetteurRepo.findAll();
        return emetteurs;
    }

    public void AddEmetteur(Emetteur emetteur)
    {
        this.emetteurRepo.save(emetteur);
    }

    public void DeleteEmetteur(String emetteurId)
    {
        Emetteur emetteur = this.emetteurRepo.findById(emetteurId).get();
        this.emetteurRepo.delete(emetteur);
    }

    public void UpdateEmetteur(String emetteurId, Emetteur emetteur)
    {
        Emetteur emetteur1 = this.emetteurRepo.findById(emetteurId).get();

        emetteur1.setDerMatricule(emetteur.getDerMatricule());
        emetteur1.setLibelleCourt(emetteur.getLibelleCourt());
        emetteur1.setLibelleLong(emetteur.getLibelleLong());
        emetteur1.setCodeStico(emetteur.getCodeStico());
        emetteur1.setTel(emetteur.getTel());
        emetteur1.setFax(emetteur.getFax());
        emetteur1.setAdresse(emetteur.getAdresse());
        emetteur1.setVille(emetteur.getVille());
        emetteur1.setCodePostal(emetteur.getCodePostal());
        emetteur1.setPremierResponsable(emetteur.getPremierResponsable());
        emetteur1.setContact(emetteur.getContact());
        emetteur1.setEmail(emetteur.getEmail());
        emetteur1.setDateMaj(emetteur.getDateMaj());
        emetteur1.setDateConvention(emetteur.getDateConvention());
        emetteur1.setPourcentage(emetteur.getPourcentage());

        this.emetteurRepo.save(emetteur1);
    }
    public List<String> getAllEmetteurLibelleCourt() {
        return emetteurRepo.findAllEmetteurLibelleCourt();
    }
}

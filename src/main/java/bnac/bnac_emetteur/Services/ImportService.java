package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.DTO.ImportDTO;
import bnac.bnac_emetteur.Entities.*;
import bnac.bnac_emetteur.Repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class ImportService {

    private static final Logger logger = LoggerFactory.getLogger(ImportService.class);

    @Autowired
    private ImportRepository importRepository;

    @Autowired
    private EmetteurRepo emetteurRepo;

    @Autowired
    private TitreRepository titreRepository;

    @Autowired
    private ActionnaireNRepo actionnaireNRepo;

    @Autowired
    private NatureAvoirRepository natureAvoirRepository;

    @Autowired
    private StatusRepo statusRepo;

    @Autowired
    private TeneurCompteRepo teneurCompteRepo;

    @Autowired
    private NatureCompteTitreRepository natureCompteTitreRepository;

    @Autowired
    private Solde_NRepo soldeNRepo;

    public void saveImportFCRA(ImportDTO importDto, String idEmetteur) {
        Emetteur emetteur = emetteurRepo.findById(idEmetteur).get();
        // Map ImportDto to Import entity and save to repository
        Import importEntity = mapToEntityFCRA(importDto, emetteur);
        importRepository.save(importEntity);
    }

    private Import mapToEntityFCRA(ImportDTO importDto, Emetteur emetteur) {
        Import importEntity = new Import();

        // Map fields from importDto to importEntity
        importEntity.setAdresse(importDto.getAdresse());
        importEntity.setCAVE(importDto.getCave());
        importEntity.setCAVR(importDto.getCavr());
        importEntity.setClient(importDto.getClient());
        importEntity.setCodeOperation(importDto.getCode_operation());
        importEntity.setCodeSISIN(importDto.getCodesisin());
        importEntity.setDateBourse(importDto.getDate_bourse());
        importEntity.setDateDeNaissance(importDto.getDate_de_naissance());
        importEntity.setDateImport(importDto.getDate_import());
        importEntity.setDateOperation(null);
        importEntity.setIdentifiant(importDto.getIdentifiant());
        importEntity.setLibelle(importDto.getLibelle());
        importEntity.setNationalite(importDto.getNationalite());
        importEntity.setNatureClient(importDto.getNature_client());
        importEntity.setNatureCompte(importDto.getNature_compte());
        importEntity.setNature_CompteE(importDto.getNature_comptee());
        importEntity.setNature_CompteR(importDto.getNature_compter());
        importEntity.setNature_id(importDto.getNature_id());
        importEntity.setNumContrat(importDto.getNum_contrat());
        importEntity.setQuantite(importDto.getQuantite());
        importEntity.setSensComptable(importDto.getSens_comptable());
        importEntity.setSolde(importDto.getSolde());
        importEntity.setStatut(importDto.getStatut());
        importEntity.setTC(importDto.getTc());
        importEntity.setTCE(importDto.getTce());
        importEntity.setTCR(importDto.getTcr());
        importEntity.setTreated(false);
        importEntity.setTypeClient(importDto.getType_client());
        importEntity.setTypeDeResidence(importDto.getType_de_residence());
        importEntity.setType_import("FCRA");
        importEntity.setCav(importDto.getCav());
        importEntity.setEmetteur(emetteur);

        Titre titre = titreRepository.findById(importDto.getTitre()).get();
        importEntity.setTitre(titre);

        return importEntity;
    }

    public void saveImportFGO(ImportDTO importDto, String idEmetteur) {
        Emetteur emetteur = emetteurRepo.findById(idEmetteur).get();
        // Map ImportDto to Import entity and save to repository
        Import importEntity = mapToEntityFGO(importDto, emetteur);
        importRepository.save(importEntity);
    }

    private Import mapToEntityFGO(ImportDTO importDto, Emetteur emetteur) {
        Import importEntity = new Import();

        // Map fields from importDto to importEntity
        importEntity.setAdresse(importDto.getAdresse());
        importEntity.setCAVE(importDto.getCave());
        importEntity.setCAVR(importDto.getCavr());
        importEntity.setClient(importDto.getClient());
        importEntity.setCodeOperation(importDto.getCode_operation());
        importEntity.setCodeSISIN(importDto.getCodesisin());
        importEntity.setDateBourse(importDto.getDate_bourse());
        importEntity.setDateDeNaissance(null);
        importEntity.setDateImport(importDto.getDate_import());
        importEntity.setDateOperation(importDto.getDate_operation());
        importEntity.setIdentifiant(importDto.getIdentifiant());
        importEntity.setLibelle(importDto.getLibelle());
        importEntity.setNationalite(importDto.getNationalite());
        importEntity.setNatureClient(importDto.getNature_client());
        importEntity.setNatureCompte(importDto.getNature_compte());
        importEntity.setNature_CompteE(importDto.getNature_comptee());
        importEntity.setNature_CompteR(importDto.getNature_compter());
        importEntity.setNature_id(importDto.getNature_id());
        importEntity.setNumContrat(importDto.getNum_contrat());
        importEntity.setQuantite(importDto.getQuantite());
        importEntity.setSensComptable(importDto.getSens_comptable());
        importEntity.setSolde(importDto.getSolde());
        importEntity.setStatut(importDto.getStatut());
        importEntity.setTC(importDto.getTc());
        importEntity.setTCE(importDto.getTce());
        importEntity.setTCR(importDto.getTcr());
        importEntity.setTreated(false);
        importEntity.setTypeClient(importDto.getType_client());
        importEntity.setTypeDeResidence(importDto.getType_de_residence());
        importEntity.setType_import("FGO");
        importEntity.setCav(importDto.getCav());
        importEntity.setEmetteur(emetteur);

        Titre titre = titreRepository.findById(importDto.getTitre()).get();
        importEntity.setTitre(titre);

        return importEntity;
    }

    public List<Import> getAllFCRA(String idEmetteur, String idTitre){
        return importRepository.findAllFCRA(idEmetteur, idTitre);
    }

    public List<Import> getAllFGO(String idEmetteur, String idTitre){
        return importRepository.findAllFGO(idEmetteur, idTitre);
    }

    public void traiterFCRA(String idEmetteur, String idTitre)
    {
        List<Import> imports = importRepository.findAllFCRA(idEmetteur, idTitre);

        int verif = 0;
        verif = actionnaireNRepo.VerifActionnaire(idEmetteur);

        Emetteur emetteur = emetteurRepo.findById(idEmetteur).get();

        if(verif != 0)
        {
            soldeNRepo.deleteAllByTitre(idTitre);
            actionnaireNRepo.deleteAllByemetteur(emetteur);
        }

        int matricule = 1;

        for (Import imp : imports)
        {
            NatureAvoir natureAvoir = natureAvoirRepository.findByCodeCategorieAvoir(imp.getCav());
            saveNewActionnaire(imp, emetteur, matricule, natureAvoir);
            NatureCompteTitre natureCompteTitre = natureCompteTitreRepository.findNatureCompteTitreByLibelleNT(imp.getNatureCompte());
            saveSolde(imp, emetteur, matricule, natureAvoir, natureCompteTitre);
            matricule++;
        }
    }

    public void saveNewActionnaire(Import imp, Emetteur emetteur, int matricule, NatureAvoir natureAvoir)
    {
        Actionnaire_N actionnaire = new Actionnaire_N(matricule, emetteur, imp.getClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getAdresse(), statusRepo.findBycodeTunCl(imp.getNatureClient()), false, imp.getNationalite(), natureAvoir, LocalDate.now());
        if (imp.getTypeDeResidence().equals("Resident"))
            actionnaire.setResident(true);

        actionnaireNRepo.save(actionnaire);
    }

    public void saveSolde(Import imp, Emetteur emetteur, int matricule, NatureAvoir natureAvoir, NatureCompteTitre natureCompteTitre)
    {
        Actionnaire_N actionnaireN = actionnaireNRepo.findActionnaire_NByMatriculeAndEmetteur(matricule, emetteur);
        TeneurCompte teneurCompte = teneurCompteRepo.findTeneurCompteByLibelleCourt(imp.getTC());
        System.out.println(teneurCompte);

        Solde_N soldeN = new Solde_N(actionnaireN.getMatricule(), imp.getTitre().getIdTitre(), teneurCompte.getIdTC(), natureCompteTitre.getIdNatureCompteTitre(), natureAvoir.getIdNatureAvoirs(), actionnaireN, imp.getTitre(),
                teneurCompte, natureCompteTitre, natureAvoir, (int) imp.getSolde().doubleValue(), LocalDateTime.now());

        soldeNRepo.save(soldeN);

        imp.setTreated(true);
    }
}

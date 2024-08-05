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

    @Autowired
    private TypeOperationNRepo typeOperationNRepo;

    @Autowired
    private OperationNRepo operationNRepo;

    @Autowired
    private ImportAnomalieRepo importAnomalieRepo;

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
            NatureCompteTitre natureCompteTitre = natureCompteTitreRepository.findNatureCompteTitreByLibelleNT(imp.getNatureCompte());

            if (natureAvoir != null)
            {
                if (natureCompteTitre != null)
                {
                    Actionnaire_N actionnaireN = actionnaireNRepo.GetActionnaireByIdentifiantAndNom(idEmetteur, imp.getIdentifiant(), imp.getClient());
                    if (actionnaireN == null)
                    {
                        actionnaireN = saveNewActionnaire(imp, emetteur, matricule, natureAvoir);
                        saveSolde(imp, emetteur, actionnaireN.getMatricule(), natureAvoir, natureCompteTitre);
                        matricule++;
                        imp.setTreated(true);
                        importRepository.save(imp);
                    }else
                    {
                        saveSolde(imp, emetteur, actionnaireN.getMatricule(), natureAvoir, natureCompteTitre);
                        imp.setTreated(true);
                        importRepository.save(imp);
                    }
                }else
                {
                    ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                            imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                            imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                            imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "nature compte titre null");

                    importAnomalieRepo.save(importAnomalie);
                }
            }else
            {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "nature avoir null");

                importAnomalieRepo.save(importAnomalie);
            }
        }
    }

    public Actionnaire_N saveNewActionnaire(Import imp, Emetteur emetteur, int matricule, NatureAvoir natureAvoir)
    {
        Actionnaire_N actionnaire = new Actionnaire_N(matricule, emetteur, imp.getClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getAdresse(), statusRepo.findBycodeTunCl(imp.getNatureClient()), false, imp.getNationalite(), natureAvoir, LocalDate.now());
        if (imp.getTypeDeResidence().equals("Resident"))
            actionnaire.setResident(true);

        actionnaireNRepo.save(actionnaire);
        return actionnaire;
    }

    public void saveSolde(Import imp, Emetteur emetteur, int matricule, NatureAvoir natureAvoir, NatureCompteTitre natureCompteTitre)
    {
        Actionnaire_N actionnaireN = actionnaireNRepo.findActionnaire_NByMatriculeAndEmetteur(matricule, emetteur);
        TeneurCompte teneurCompte = teneurCompteRepo.findTeneurCompteByLibelleCsd(imp.getTC());

        if (teneurCompte != null)
        {
            Solde_N soldeN = new Solde_N(actionnaireN.getMatricule(), imp.getTitre().getIdTitre(), teneurCompte.getIdTC(), natureCompteTitre.getIdNatureCompteTitre(), natureAvoir.getIdNatureAvoirs(), actionnaireN, imp.getTitre(),
                    teneurCompte, natureCompteTitre, natureAvoir, (int) imp.getSolde().doubleValue(), LocalDateTime.now());

            soldeNRepo.save(soldeN);
            imp.setTreated(true);
            importRepository.save(imp);
        }else
        {
            ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                    imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                    imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                    imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "tenneur compte null");

            importAnomalieRepo.save(importAnomalie);
        }


    }

    public void traiterFGO(String idEmetteur, String idTitre)
    {
        List<Import> imports = importRepository.findAllFGO(idEmetteur, idTitre);

        Emetteur emetteur = emetteurRepo.findById(idEmetteur).get();
        Titre titre = titreRepository.findById(idTitre).get();

        Operation_N lastOperation = operationNRepo.GetLastOperation(idEmetteur);
        int idOperation;
        int matricule;
        if (lastOperation != null)
            idOperation = lastOperation.getIdOperation() + 1;
        else
            idOperation = 0;

        for (Import imp : imports)
        {
            NatureAvoir natureAvoir = natureAvoirRepository.findByCodeCategorieAvoir(imp.getCAVE());
            NatureCompteTitre natureCompteTitre = natureCompteTitreRepository.findNatureCompteTitreByLibelleNT(imp.getNature_CompteE());

            if (natureAvoir != null)
            {
                if (natureCompteTitre != null)
                {
                    Actionnaire_N actionnaireN = actionnaireNRepo.GetActionnaireByIdentifiantAndNom(idEmetteur, imp.getIdentifiant(), imp.getClient());
                    if (actionnaireN == null)
                    {
                        if (actionnaireNRepo.GetLastMatricule(idEmetteur) == null)
                        {
                            matricule = 1;
                        }else
                        {
                            matricule = actionnaireNRepo.GetLastMatricule(idEmetteur).getMatricule() + 1;
                        }

                        actionnaireN = saveNewActionnaire(imp, emetteur, matricule, natureAvoir);
                        Operation_N operation = saveNewOperation(idOperation, imp, emetteur, actionnaireN, titre, natureCompteTitre, natureAvoir);
                        idOperation++;
                        if (operation != null)
                            updateSolde(imp, operation);
                    }else
                    {
                        Operation_N operation = saveNewOperation(idOperation, imp, emetteur, actionnaireN, titre, natureCompteTitre, natureAvoir);
                        idOperation++;
                        if (operation != null)
                            updateSolde(imp, operation);
                    }
                }else
                {
                    ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                            imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                            imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                            imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "nature compte titre null");

                    importAnomalieRepo.save(importAnomalie);
                }
            }else
            {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "nature avoir null");

                importAnomalieRepo.save(importAnomalie);
            }
        }
    }

    public Operation_N saveNewOperation(int idOperation, Import imp, Emetteur emetteur, Actionnaire_N actionnaireN, Titre titre, NatureCompteTitre natureCompteTitre, NatureAvoir natureAvoir)
    {
        TypeOperation_N typeOperationN = typeOperationNRepo.GetTypeOperation(imp.getCodeOperation(), imp.getSensComptable(), imp.getNature_CompteE());
        TeneurCompte teneurCompte = teneurCompteRepo.findTeneurCompteByLibelleCsd(imp.getTCR());

        if (teneurCompte != null)
        {
            if (typeOperationN != null)
            {
                Operation_N operationN = new Operation_N(idOperation, actionnaireN, emetteur, teneurCompte, natureCompteTitre, natureAvoir, titre, typeOperationN,
                        imp.getQuantite(), 0, imp.getDateOperation(), imp.getDateBourse(), imp.getNumContrat());

                operationNRepo.save(operationN);
                return operationN;
            }else
            {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "type operation null");

                importAnomalieRepo.save(importAnomalie);
                return null;
            }
        }else
        {
            ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                    imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                    imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                    imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "tenneur compte null");

            importAnomalieRepo.save(importAnomalie);
            return null;
        }
    }

    public void updateSolde(Import imp, Operation_N operationN)
    {
        if (operationN.getTypeOperation().getIdTypeOperation().equals("AC")) {
            Solde_N soldeN = soldeNRepo.VerifSoldeExist(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureCompteTitre().getIdNatureCompteTitre(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN != null) {
                soldeN.setSolde(soldeN.getSolde() + imp.getQuantite());
                soldeNRepo.save(soldeN);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                Solde_N soldeN1 = new Solde_N(operationN.getActionnaire().getMatricule(), operationN.getTitre().getIdTitre(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureCompteTitre().getIdNatureCompteTitre(), operationN.getNatureAvoir().getIdNatureAvoirs(),
                        operationN.getActionnaire(), operationN.getTitre(), operationN.getTeneurCompte(), operationN.getNatureCompteTitre(), operationN.getNatureAvoir(), imp.getQuantite(), LocalDateTime.now());
                soldeNRepo.save(soldeN1);
                imp.setTreated(true);
                importRepository.save(imp);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("VC")) {
            Solde_N soldeN = soldeNRepo.VerifSoldeExist(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureCompteTitre().getIdNatureCompteTitre(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN != null) {
                soldeN.setSolde(soldeN.getSolde() - imp.getQuantite());
                soldeNRepo.save(soldeN);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                Solde_N soldeN1 = new Solde_N(operationN.getActionnaire().getMatricule(), operationN.getTitre().getIdTitre(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureCompteTitre().getIdNatureCompteTitre(), operationN.getNatureAvoir().getIdNatureAvoirs(),
                        operationN.getActionnaire(), operationN.getTitre(), operationN.getTeneurCompte(), operationN.getNatureCompteTitre(), operationN.getNatureAvoir(), imp.getQuantite() * -1, LocalDateTime.now());
                soldeNRepo.save(soldeN1);
                imp.setTreated(true);
                importRepository.save(imp);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("GTE")) {
            Solde_N soldeN = soldeNRepo.GetSoldeMain(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN != null) {
                Solde_N soldeFrozen = soldeNRepo.GetSoldeFrozen(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
                if (soldeFrozen != null) {
                    soldeFrozen.setSolde(soldeFrozen.getSolde() + imp.getQuantite());
                    soldeNRepo.save(soldeFrozen);
                    imp.setTreated(true);
                    importRepository.save(imp);
                } else {
                    NatureCompteTitre natureCompteTitre = natureCompteTitreRepository.findById(7).get();
                    Solde_N soldeN1 = new Solde_N(soldeN.getActionnaire().getMatricule(), soldeN.getTitre().getIdTitre(), soldeN.getTeneurCompte().getIdTC(), natureCompteTitre.getIdNatureCompteTitre(), soldeN.getNatureAvoir().getIdNatureAvoirs(),
                            soldeN.getActionnaire(), soldeN.getTitre(), soldeN.getTeneurCompte(), natureCompteTitre, soldeN.getNatureAvoir(), imp.getQuantite(), LocalDateTime.now());
                    soldeNRepo.save(soldeN1);
                    imp.setTreated(true);
                    importRepository.save(imp);
                }
            } else {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "solde null GTE");

                importAnomalieRepo.save(importAnomalie);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("GTS")) {
            Solde_N soldeN = soldeNRepo.GetSoldeMain(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN != null) {
                soldeN.setSolde(soldeN.getSolde() - imp.getQuantite());
                soldeNRepo.save(soldeN);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "solde null GTS");

                importAnomalieRepo.save(importAnomalie);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("LGE")) {
            Solde_N soldeFrozen = soldeNRepo.GetSoldeFrozen(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeFrozen != null) {
                Solde_N soldeN = soldeNRepo.GetSoldeMain(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
                soldeN.setSolde(soldeN.getSolde() + imp.getQuantite());
                soldeNRepo.save(soldeN);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "solde null LGE");

                importAnomalieRepo.save(importAnomalie);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("LGS")) {
            Solde_N soldeN = soldeNRepo.GetSoldeMain(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN != null) {
                Solde_N soldeFrozen = soldeNRepo.GetSoldeFrozen(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
                soldeFrozen.setSolde(soldeFrozen.getSolde() - imp.getQuantite());
                soldeNRepo.save(soldeFrozen);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "solde null LGS");

                importAnomalieRepo.save(importAnomalie);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("NTE")) {
            Solde_N soldeN = soldeNRepo.GetSoldeMain(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN != null) {
                Solde_N soldePledge = soldeNRepo.GetSoldePledge(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
                if (soldePledge != null) {
                    soldePledge.setSolde(soldePledge.getSolde() + imp.getQuantite());
                    soldeNRepo.save(soldePledge);
                    imp.setTreated(true);
                    importRepository.save(imp);
                } else {
                    NatureCompteTitre natureCompteTitre = natureCompteTitreRepository.findById(3).get();
                    Solde_N soldeN1 = new Solde_N(soldeN.getActionnaire().getMatricule(), soldeN.getTitre().getIdTitre(), soldeN.getTeneurCompte().getIdTC(), natureCompteTitre.getIdNatureCompteTitre(), soldeN.getNatureAvoir().getIdNatureAvoirs(),
                            soldeN.getActionnaire(), soldeN.getTitre(), soldeN.getTeneurCompte(), natureCompteTitre, soldeN.getNatureAvoir(), imp.getQuantite(), LocalDateTime.now());
                    soldeNRepo.save(soldeN1);
                    imp.setTreated(true);
                    importRepository.save(imp);
                }
            } else {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "solde null NTE");

                importAnomalieRepo.save(importAnomalie);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("NTS")) {
            Solde_N soldeN = soldeNRepo.GetSoldeMain(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN != null) {
                soldeN.setSolde(soldeN.getSolde() - imp.getQuantite());
                soldeNRepo.save(soldeN);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "solde null NTS");

                importAnomalieRepo.save(importAnomalie);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("LNE")) {
            Solde_N soldePledge = soldeNRepo.GetSoldePledge(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldePledge != null) {
                Solde_N soldeN = soldeNRepo.GetSoldeMain(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
                soldeN.setSolde(soldeN.getSolde() + imp.getQuantite());
                soldeNRepo.save(soldeN);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "solde null LNE");

                importAnomalieRepo.save(importAnomalie);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("LNS")) {
            Solde_N soldeN = soldeNRepo.GetSoldeMain(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN != null) {
                Solde_N soldePledge = soldeNRepo.GetSoldePledge(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
                soldePledge.setSolde(soldePledge.getSolde() - imp.getQuantite());
                soldeNRepo.save(soldePledge);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "solde null LNS");

                importAnomalieRepo.save(importAnomalie);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("OTE")) {
            Solde_N soldeN = soldeNRepo.GetSoldeMain(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN != null) {
                Solde_N soldeOpposition = soldeNRepo.GetSoldeOpposition(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
                if (soldeOpposition != null) {
                    soldeOpposition.setSolde(soldeOpposition.getSolde() + imp.getQuantite());
                    soldeNRepo.save(soldeOpposition);
                    imp.setTreated(true);
                    importRepository.save(imp);
                } else {
                    NatureCompteTitre natureCompteTitre = natureCompteTitreRepository.findById(4).get();
                    Solde_N soldeN1 = new Solde_N(soldeN.getActionnaire().getMatricule(), soldeN.getTitre().getIdTitre(), soldeN.getTeneurCompte().getIdTC(), natureCompteTitre.getIdNatureCompteTitre(), soldeN.getNatureAvoir().getIdNatureAvoirs(),
                            soldeN.getActionnaire(), soldeN.getTitre(), soldeN.getTeneurCompte(), natureCompteTitre, soldeN.getNatureAvoir(), imp.getQuantite(), LocalDateTime.now());
                    soldeNRepo.save(soldeN1);
                    imp.setTreated(true);
                    importRepository.save(imp);
                }
            } else {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "solde null OTE");

                importAnomalieRepo.save(importAnomalie);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("OTS")) {
            Solde_N soldeN = soldeNRepo.GetSoldeMain(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN != null) {
                soldeN.setSolde(soldeN.getSolde() - imp.getQuantite());
                soldeNRepo.save(soldeN);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "solde null OTS");

                importAnomalieRepo.save(importAnomalie);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("LOE")) {
            Solde_N soldeOpposition = soldeNRepo.GetSoldeOpposition(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeOpposition != null) {
                Solde_N soldeN = soldeNRepo.GetSoldeMain(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
                soldeN.setSolde(soldeN.getSolde() + imp.getQuantite());
                soldeNRepo.save(soldeN);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "solde null LOE");

                importAnomalieRepo.save(importAnomalie);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("LOS")) {
            Solde_N soldeN = soldeNRepo.GetSoldeMain(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN != null) {
                Solde_N soldeOpposition = soldeNRepo.GetSoldeOpposition(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureAvoir().getIdNatureAvoirs());
                soldeOpposition.setSolde(soldeOpposition.getSolde() - imp.getQuantite());
                soldeNRepo.save(soldeOpposition);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "solde null LOS");

                importAnomalieRepo.save(importAnomalie);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("SE")) {
            Solde_N soldeN = soldeNRepo.VerifSoldeExist(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureCompteTitre().getIdNatureCompteTitre(), operationN.getNatureAvoir().getIdNatureAvoirs());
            soldeN.setSolde(soldeN.getSolde() + imp.getQuantite());
            soldeNRepo.save(soldeN);
            imp.setTreated(true);
            importRepository.save(imp);

        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("SS")) {
            Solde_N soldeN = soldeNRepo.VerifSoldeExist(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureCompteTitre().getIdNatureCompteTitre(), operationN.getNatureAvoir().getIdNatureAvoirs());
            soldeN.setSolde(soldeN.getSolde() - imp.getQuantite());
            soldeNRepo.save(soldeN);
            imp.setTreated(true);
            importRepository.save(imp);

        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("CHSE")) {
            Solde_N soldeN = soldeNRepo.VerifSoldeExist(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureCompteTitre().getIdNatureCompteTitre(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN == null) {
                Solde_N soldeNew = new Solde_N(operationN.getActionnaire().getMatricule(), operationN.getTitre().getIdTitre(), operationN.getTeneurCompte().getIdTC(),
                        operationN.getNatureCompteTitre().getIdNatureCompteTitre(), operationN.getNatureAvoir().getIdNatureAvoirs(),
                        operationN.getActionnaire(), operationN.getTitre(), operationN.getTeneurCompte(), operationN.getNatureCompteTitre(),
                        operationN.getNatureAvoir(), operationN.getQuantite(), LocalDateTime.now());
                soldeNRepo.save(soldeNew);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                soldeN.setSolde(soldeN.getSolde() + operationN.getQuantite());
                soldeNRepo.save(soldeN);
                imp.setTreated(true);
                importRepository.save(imp);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("CHSS")) {
            Solde_N soldeN = soldeNRepo.VerifSoldeExist(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureCompteTitre().getIdNatureCompteTitre(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN != null) {
                soldeN.setSolde(soldeN.getSolde() - imp.getQuantite());
                soldeNRepo.save(soldeN);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "solde null CHSS");

                importAnomalieRepo.save(importAnomalie);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("TE")) {
            Solde_N soldeN = soldeNRepo.VerifSoldeExist(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureCompteTitre().getIdNatureCompteTitre(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN != null) {
                soldeN.setSolde(soldeN.getSolde() - imp.getQuantite());
                soldeNRepo.save(soldeN);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                ImportAnomalie importAnomalie = new ImportAnomalie(imp.getId_Import(), imp.getLibelle(), imp.getSensComptable(), imp.getCodeOperation(), imp.getCodeSISIN(), imp.getDateOperation(),
                        imp.getDateImport(), imp.getDateBourse(), imp.getDateDeNaissance(), imp.getNumContrat(), imp.getCAVE(), imp.getCAVR(), imp.getNature_CompteE(), imp.getNature_CompteR(),
                        imp.getClient(), imp.getQuantite(), imp.getTypeClient(), imp.getNature_id(), imp.getIdentifiant(), imp.getNationalite(), imp.getAdresse(), imp.getStatut(), imp.getType_import(),
                        imp.isTreated(), imp.getEmetteur(), imp.getTypeDeResidence(), imp.getTC(), imp.getSolde(), imp.getCav(), imp.getNatureCompte(), imp.getTCR(), imp.getTCE(), imp.getNatureClient(), imp.getTitre(), "solde null TE");

                importAnomalieRepo.save(importAnomalie);
            }
        } else if (operationN.getTypeOperation().getIdTypeOperation().equals("TR")) {
            Solde_N soldeN = soldeNRepo.VerifSoldeExist(operationN.getTitre().getIdTitre(), operationN.getActionnaire().getMatricule(), operationN.getTeneurCompte().getIdTC(), operationN.getNatureCompteTitre().getIdNatureCompteTitre(), operationN.getNatureAvoir().getIdNatureAvoirs());
            if (soldeN != null) {
                soldeN.setSolde(soldeN.getSolde() + imp.getQuantite());
                soldeNRepo.save(soldeN);
                imp.setTreated(true);
                importRepository.save(imp);
            } else {
                Solde_N soldeNew = new Solde_N(operationN.getActionnaire().getMatricule(), operationN.getTitre().getIdTitre(), operationN.getTeneurCompte().getIdTC(),
                        operationN.getNatureCompteTitre().getIdNatureCompteTitre(), operationN.getNatureAvoir().getIdNatureAvoirs(),
                        operationN.getActionnaire(), operationN.getTitre(), operationN.getTeneurCompte(), operationN.getNatureCompteTitre(),
                        operationN.getNatureAvoir(), operationN.getQuantite(), LocalDateTime.now());
                soldeNRepo.save(soldeNew);
                imp.setTreated(true);
                importRepository.save(imp);
            }
        }
    }
}

package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.DTO.ImportDTO;
import bnac.bnac_emetteur.Entities.Emetteur;
import bnac.bnac_emetteur.Entities.Import;
import bnac.bnac_emetteur.Entities.Titre;
import bnac.bnac_emetteur.Repositories.EmetteurRepo;
import bnac.bnac_emetteur.Repositories.ImportRepository;
import bnac.bnac_emetteur.Repositories.TitreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
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
        importEntity.setTreated(importDto.getTreated());
        importEntity.setTypeClient(importDto.getType_client());
        importEntity.setTypeDeResidence(importDto.getType_de_residence());
        importEntity.setType_import(importDto.getType_import());
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
        importEntity.setTreated(importDto.getTreated());
        importEntity.setTypeClient(importDto.getType_client());
        importEntity.setTypeDeResidence(importDto.getType_de_residence());
        importEntity.setType_import(importDto.getType_import());
        importEntity.setCav(importDto.getCav());
        importEntity.setEmetteur(emetteur);

        Titre titre = titreRepository.findById(importDto.getTitre()).get();
        importEntity.setTitre(titre);

        return importEntity;
    }
}

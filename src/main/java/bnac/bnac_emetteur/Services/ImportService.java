package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.DTO.ImportDTO;
import bnac.bnac_emetteur.Entities.Emetteur;
import bnac.bnac_emetteur.Entities.Import;
import bnac.bnac_emetteur.Repositories.EmetteurRepo;
import bnac.bnac_emetteur.Repositories.ImportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ImportService {

    private static final Logger logger = LoggerFactory.getLogger(ImportService.class);

    @Autowired
    private ImportRepository importRepository;

    @Autowired
    private EmetteurRepo emetteurRepo;

    public void saveAll(Import[] importData, String idEmetteur) {
        try {
            Emetteur emetteur = emetteurRepo.findById(idEmetteur)
                    .orElseThrow(() -> new RuntimeException("Emetteur not found"));
            for (Import imp : importData) {
                imp.setEmetteur(emetteur);
                importRepository.save(imp);
            }
        } catch (Exception e) {
            logger.error("Error saving import data", e);
            throw e; // Rethrow to ensure the controller can return a 500 response
        }
    }

    public void saveImport(ImportDTO importDto, String idEmetteur) {
        Emetteur emetteur = emetteurRepo.findById(idEmetteur).get();
        // Map ImportDto to Import entity and save to repository
        Import importEntity = mapToEntity(importDto, emetteur);
        importRepository.save(importEntity);
    }

    private Import mapToEntity(ImportDTO importDto, Emetteur emetteur) {
        Import importEntity = new Import();

        // Map fields from importDto to importEntity
        importEntity.setAdresse(importDto.getAdresse());
        importEntity.setCAVE(importDto.getCave());
        importEntity.setCAVR(importDto.getCavr());
        importEntity.setClient(importDto.getClient());
        importEntity.setCodeOperation(importDto.getCodeOperation());
        importEntity.setCodeSISIN(importDto.getCodeSisin());
        importEntity.setDateBourse(importDto.getDateBourse());
        importEntity.setDateDeNaissance(importDto.getDateDeNaissance());
        importEntity.setDateImport(importDto.getDateImport());
        importEntity.setDateOperation(importDto.getDateOperation());
        importEntity.setIdentifiant(importDto.getIdentifiant());
        importEntity.setLibelle(importDto.getLibelle());
        importEntity.setNationalite(importDto.getNationalite());
        importEntity.setNatureClient(importDto.getNatureClient());
        importEntity.setNatureCompte(importDto.getNatureCompte());
        importEntity.setNature_CompteE(importDto.getNatureComptee());
        importEntity.setNature_CompteR(importDto.getNatureCompter());
        importEntity.setNature_id(importDto.getNatureId());
        importEntity.setNumContrat(importDto.getNumContrat());
        importEntity.setQuantite(importDto.getQuantite());
        importEntity.setSensComptable(importDto.getSensComptable());
        importEntity.setSolde(importDto.getSolde());
        importEntity.setStatut(importDto.getStatut());
        importEntity.setTC(importDto.getTc());
        importEntity.setTCE(importDto.getTce());
        importEntity.setTCR(importDto.getTcr());
        importEntity.setTitre(importDto.getTitre());
        importEntity.setTreated(importDto.getTreated());
        importEntity.setTypeClient(importDto.getTypeClient());
        importEntity.setTypeDeResidence(importDto.getTypeDeResidence());
        importEntity.setType_import(importDto.getTypeImport());
        importEntity.setCav(importDto.getCav());
        importEntity.setEmetteur(emetteur);



        return importEntity;
    }
}

package bnac.bnac_emetteur.Controllers;
import bnac.bnac_emetteur.DTO.ImportDTO;
import bnac.bnac_emetteur.Entities.Import;
import bnac.bnac_emetteur.Services.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bnac")
@CrossOrigin("http://localhost:4200")
public class ImportController {

    @Autowired
    private ImportService importService;

    @PostMapping("/importfcra/{idEmetteur}")
    public ResponseEntity<Void> saveImportFCRA(@RequestBody ImportDTO importDto, @PathVariable String idEmetteur) {
        importService.saveImportFCRA(importDto, idEmetteur);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/importfgo/{idEmetteur}")
    public ResponseEntity<Void> saveImportFGO(@RequestBody ImportDTO importDto, @PathVariable String idEmetteur) {
        importService.saveImportFGO(importDto, idEmetteur);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getFCRA/{idEmetteur}/{idTitre}")
    public List<ImportDTO> GetFCRA(@PathVariable String idEmetteur, @PathVariable String idTitre) {
        List<Import> imports = importService.getAllFCRA(idEmetteur, idTitre);
        List<ImportDTO> importDTOS = new ArrayList<>();
        for(Import imp : imports)
        {
            ImportDTO importDTO = new ImportDTO();
            importDTO.setAdresse(imp.getAdresse());
            importDTO.setCave(imp.getCAVE());
            importDTO.setCavr(imp.getCAVR());
            importDTO.setClient(imp.getClient());
            importDTO.setCode_operation(imp.getCodeOperation());
            importDTO.setCodesisin(imp.getCodeSISIN());
            importDTO.setDate_import(imp.getDateImport());
            importDTO.setDate_bourse(imp.getDateBourse());
            importDTO.setDate_de_naissance(imp.getDateDeNaissance());
            importDTO.setDate_operation(imp.getDateOperation());
            importDTO.setIdentifiant(imp.getIdentifiant());
            importDTO.setLibelle(imp.getLibelle());
            importDTO.setNationalite(imp.getNationalite());
            importDTO.setNature_client(imp.getNatureClient());
            importDTO.setNature_compte(imp.getNatureCompte());
            importDTO.setNature_comptee(imp.getNature_CompteE());
            importDTO.setNature_compter(imp.getNature_CompteR());
            importDTO.setNature_id(imp.getNature_id());
            importDTO.setNum_contrat(imp.getNumContrat());
            importDTO.setQuantite(imp.getQuantite());
            importDTO.setSens_comptable(imp.getSensComptable());
            importDTO.setSolde(imp.getSolde());
            importDTO.setStatut(imp.getStatut());
            importDTO.setTc(imp.getTC());
            importDTO.setTce(imp.getTCE());
            importDTO.setTcr(imp.getTCR());
            importDTO.setTitre(imp.getTitre().getLibelleCourt());
            importDTO.setTreated(imp.isTreated());
            importDTO.setType_client(imp.getTypeClient());
            importDTO.setType_de_residence(imp.getTypeDeResidence());
            importDTO.setType_import(imp.getType_import());
            importDTO.setCav(imp.getCav());
            importDTO.setEmetteur(imp.getEmetteur());

            importDTOS.add(importDTO);
        }

        return importDTOS;
    }

    @GetMapping("/getFGO/{idEmetteur}/{idTitre}")
    public List<ImportDTO> GetFGO(@PathVariable String idEmetteur, @PathVariable String idTitre) {
        List<Import> imports = importService.getAllFGO(idEmetteur, idTitre);
        List<ImportDTO> importDTOS = new ArrayList<>();
        for(Import imp : imports)
        {
            ImportDTO importDTO = new ImportDTO();
            importDTO.setAdresse(imp.getAdresse());
            importDTO.setCave(imp.getCAVE());
            importDTO.setCavr(imp.getCAVR());
            importDTO.setClient(imp.getClient());
            importDTO.setCode_operation(imp.getCodeOperation());
            importDTO.setCodesisin(imp.getCodeSISIN());
            importDTO.setDate_import(imp.getDateImport());
            importDTO.setDate_bourse(imp.getDateBourse());
            importDTO.setDate_de_naissance(imp.getDateDeNaissance());
            importDTO.setDate_operation(imp.getDateOperation());
            importDTO.setIdentifiant(imp.getIdentifiant());
            importDTO.setLibelle(imp.getLibelle());
            importDTO.setNationalite(imp.getNationalite());
            importDTO.setNature_client(imp.getNatureClient());
            importDTO.setNature_compte(imp.getNatureCompte());
            importDTO.setNature_comptee(imp.getNature_CompteE());
            importDTO.setNature_compter(imp.getNature_CompteR());
            importDTO.setNature_id(imp.getNature_id());
            importDTO.setNum_contrat(imp.getNumContrat());
            importDTO.setQuantite(imp.getQuantite());
            importDTO.setSens_comptable(imp.getSensComptable());
            importDTO.setSolde(imp.getSolde());
            importDTO.setStatut(imp.getStatut());
            importDTO.setTc(imp.getTC());
            importDTO.setTce(imp.getTCE());
            importDTO.setTcr(imp.getTCR());
            importDTO.setTitre(imp.getTitre().getLibelleCourt());
            importDTO.setTreated(imp.isTreated());
            importDTO.setType_client(imp.getTypeClient());
            importDTO.setType_de_residence(imp.getTypeDeResidence());
            importDTO.setType_import(imp.getType_import());
            importDTO.setCav(imp.getCav());
            importDTO.setEmetteur(imp.getEmetteur());

            importDTOS.add(importDTO);
        }

        return importDTOS;
    }

    @PostMapping("/traiterFCRA/{idEmetteur}/{idTitre}")
    public ResponseEntity<Void> traiterFCRA(@PathVariable String idEmetteur, @PathVariable String idTitre) {
        importService.traiterFCRA(idEmetteur, idTitre);
        return ResponseEntity.ok().build();
    }
}

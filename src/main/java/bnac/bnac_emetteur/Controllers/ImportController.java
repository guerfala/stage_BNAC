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
    public List<Import> GetFCRA(@PathVariable String idEmetteur, @PathVariable String idTitre) {
        return importService.getAllFCRA(idEmetteur, idTitre);
    }

    @GetMapping("/getFGO/{idEmetteur}/{idTitre}")
    public List<Import> GetFGO(@PathVariable String idEmetteur, @PathVariable String idTitre) {
        return importService.getAllFGO(idEmetteur, idTitre);
    }

    @PostMapping("/traiterFCRA/{idEmetteur}/{idTitre}")
    public ResponseEntity<Void> traiterFCRA(@PathVariable String idEmetteur, @PathVariable String idTitre) {
        importService.traiterFCRA(idEmetteur, idTitre);
        return ResponseEntity.ok().build();
    }
}

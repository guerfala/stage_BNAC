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

    /*@PostMapping("/importfcra/{idEmetteur}")
    public void importfcra(@RequestBody Import[] importData, @PathVariable String idEmetteur) {
        importService.saveAll(importData, idEmetteur);
    }*/

    @PostMapping("/importfcra/{idEmetteur}")
    public ResponseEntity<Void> saveImport(@RequestBody ImportDTO importDto, @PathVariable String idEmetteur) {
        importService.saveImport(importDto, idEmetteur);
        return ResponseEntity.ok().build();
    }
}

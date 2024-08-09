package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.DTO.FGO;
import bnac.bnac_emetteur.Services.ExportService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/bnac")
@CrossOrigin("http://localhost:4200")
public class ExportController {

    @Autowired
    private ExportService exportService;

    @GetMapping("/download/{emetteurId}/{titreId}/{minDate}/{maxDate}")
    private ResponseEntity<InputStreamResource> download(@PathVariable String emetteurId, @PathVariable String titreId, @PathVariable LocalDateTime minDate, @PathVariable LocalDateTime maxDate) throws IOException {

        String fileName = "FGO.reg";

        LocalDate min = minDate.toLocalDate();
        LocalDate max = maxDate.toLocalDate();

        ByteArrayInputStream inputStream = exportService.getRegFileData(emetteurId, titreId, min, max);

        InputStreamResource response = new InputStreamResource(inputStream);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(response);
    }
}

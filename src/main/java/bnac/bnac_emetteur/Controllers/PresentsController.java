package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.Presents;
import bnac.bnac_emetteur.Entities.PresentsId;
import bnac.bnac_emetteur.Services.PresentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bnac/presents")
public class PresentsController {

    @Autowired
    private PresentsService presentsService;

    @PostMapping("/add")
    public ResponseEntity<Presents> addPresents(@RequestBody Presents presents) {
        Presents createdPresents = presentsService.addPresents(presents);
        return new ResponseEntity<>(createdPresents, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePresents(@RequestBody PresentsId presentsId) {
        presentsService.deletePresents(presentsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Presents>> getAllPresents() {
        List<Presents> presentsList = presentsService.getAllPresents();
        return new ResponseEntity<>(presentsList, HttpStatus.OK);
    }
}

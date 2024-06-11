package bnac.bnac_emetteur.Controllers;

import bnac.bnac_emetteur.Entities.Actionnaire;
import bnac.bnac_emetteur.Services.ActionnaireService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bnac")
@AllArgsConstructor



public class ActionnaireController {
    @Autowired
    private ActionnaireService actionnaireService;

    @GetMapping("/getAllActionnaires")
    public List<Actionnaire> getAllActionnaires() {
        return actionnaireService.getAllActionnaires();
    }
}

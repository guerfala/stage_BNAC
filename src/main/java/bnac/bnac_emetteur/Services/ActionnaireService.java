package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.Actionnaire;
import bnac.bnac_emetteur.Repositories.ActionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionnaireService {

    @Autowired
    private ActionnaireRepository actionnaireRepository;

    public List<Actionnaire> getAllActionnaires() {
        return actionnaireRepository.findAll();
    }
}

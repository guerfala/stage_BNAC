package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.Presents;
import bnac.bnac_emetteur.Entities.PresentsId;
import bnac.bnac_emetteur.Repositories.PresentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresentsService {

    @Autowired
    private PresentsRepository presentsRepository;

    public List<Presents> getAllPresents() {
        return presentsRepository.findAll();
    }

    public Optional<Presents> getPresentsById(PresentsId id) {
        return presentsRepository.findById(id);
    }

    public Presents createPresents(Presents presents) {
        return presentsRepository.save(presents);
    }

    public Presents updatePresents(PresentsId id, Presents presents) {
        Optional<Presents> existingPresents = presentsRepository.findById(id);
        if (existingPresents.isPresent()) {
            Presents updatedPresents = existingPresents.get();
            // Update the fields of the existingPresents with values from the new presents
            updatedPresents.setDateTenue(presents.getDateTenue());
            updatedPresents.setEmetteur(presents.getEmetteur());
            updatedPresents.setTypeAssemblee(presents.getTypeAssemblee());
            updatedPresents.setActionnaire(presents.getActionnaire());
            return presentsRepository.save(updatedPresents);
        } else {
            return null; // Or handle as you prefer
        }
    }

    public void deletePresents(PresentsId id) {
        presentsRepository.deleteById(id);
    }
}

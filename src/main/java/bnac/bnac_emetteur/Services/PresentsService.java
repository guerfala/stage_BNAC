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

    public Presents addPresents(Presents presents) {
        return presentsRepository.save(presents);
    }

    public void deletePresents(PresentsId presentsId) {
        Optional<Presents> presents = presentsRepository.findById(presentsId);
        if (presents.isPresent()) {
            presentsRepository.delete(presents.get());
        } else {
            throw new RuntimeException("Presents not found");
        }
    }

    public List<Presents> getAllPresents() {
        return presentsRepository.findAll();
    }
}

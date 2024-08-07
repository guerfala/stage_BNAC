package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.Assemblee;
import bnac.bnac_emetteur.Entities.Emetteur;
import bnac.bnac_emetteur.Entities.Titre;
import bnac.bnac_emetteur.Entities.TypeAssemblee;
import bnac.bnac_emetteur.Repositories.AssembleeRepository;
import bnac.bnac_emetteur.Repositories.EmetteurRepo;
import bnac.bnac_emetteur.Repositories.TypeAssembleeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AssembleeService {
    private final EmetteurRepo emetteurRepo;

    private final AssembleeRepository assembleeRepository;


    public List<Assemblee> getAllAssemblees() {
        return assembleeRepository.findAll();
    }

    public Optional<Assemblee> getAssembleeById(int id) {
        return assembleeRepository.findById(id);
    }


    public Assemblee updateAssemblee(int id, Assemblee assembleeDetails) {
        Assemblee assemblee = assembleeRepository.findById(id).orElseThrow();
        assemblee.setTypeAssemblee(assembleeDetails.getTypeAssemblee());
        assemblee.setEmetteur(assembleeDetails.getEmetteur());
        assemblee.setDateTenue(assembleeDetails.getDateTenue());
        assemblee.setLieu(assembleeDetails.getLieu());
        assemblee.setLibelle(assembleeDetails.getLibelle());
        return assembleeRepository.save(assemblee);
    }

    public void deleteAssemblee(int id) {
        assembleeRepository.deleteById(id);
    }
   /* public void savedAssemblee(Assemblee assemblee) {
        if (assemblee.getEmetteur() == null) {
            throw new IllegalArgumentException("Emetteur cannot be null");
        }
        assembleeRepository.save(assemblee);
    }*/

   /* public Assemblee saveAssemblee(Assemblee assemblee) {
        // Ensure IdEmetteur and IdTypeAssemblee are set and convert them to entities
        if (assemblee.getEmetteur() == null && assemblee.getIdEmetteur() != null) {
            Emetteur emetteur;
            emetteur = emetteurRepo.findById(assemblee.getIdEmetteur())
                    .orElseThrow(() -> new RuntimeException("Emetteur not found"));
            assemblee.setEmetteur(emetteur);
        }

        if (assemblee.getTypeAssemblee() == null && assemblee.getIdTypeAseemblee() != null) {
            TypeAssemblee typeAssemblee = typeAssembleeRepository.findById(assemblee.getIdTypeAseemblee())
                    .orElseThrow(() -> new RuntimeException("TypeAssemblee not found"));
            assemblee.setTypeAssemblee(typeAssemblee);
        }

        return assembleeRepository.save(assemblee);
    }*/

   public Assemblee saveAssemblee(Assemblee assemblee) {
        if (assemblee.getEmetteur() == null && assemblee.getIdEmetteur() != null) {
            Emetteur emetteur = emetteurRepo.findById(assemblee.getIdEmetteur())
                    .orElseThrow(() -> new RuntimeException("Emetteur not found"));
            assemblee.setEmetteur(emetteur);
        }
        return assembleeRepository.save(assemblee);
    }
}

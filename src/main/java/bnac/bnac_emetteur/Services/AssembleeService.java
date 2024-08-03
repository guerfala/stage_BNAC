package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.Assemblee;
import bnac.bnac_emetteur.Entities.TypeAssemblee;
import bnac.bnac_emetteur.Repositories.AssembleeRepository;
import bnac.bnac_emetteur.Repositories.TypeAssembleeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssembleeService {

    @Autowired
    private AssembleeRepository assembleeRepository;

    @Autowired
    private TypeAssembleeRepository typeAssembleeRepository;

    // Create or Update Assemblee
    public Assemblee createAssemblee(Assemblee assemblee) {
        return assembleeRepository.save(assemblee);
    }

    // Update Assemblee
    public Assemblee updateAssemblee(int id, Assemblee updatedAssemblee) {
        return assembleeRepository.findById(id)
                .map(existingAssemblee -> {
                    existingAssemblee.setTypeAssemblee(updatedAssemblee.getTypeAssemblee());
                    existingAssemblee.setEmetteur(updatedAssemblee.getEmetteur());
                    existingAssemblee.setDateTenue(updatedAssemblee.getDateTenue());
                    existingAssemblee.setLieu(updatedAssemblee.getLieu());
                    existingAssemblee.setLibelle(updatedAssemblee.getLibelle());
                    // Set other fields if needed
                    return assembleeRepository.save(existingAssemblee);
                })
                .orElseThrow(() -> new RuntimeException("Assemblee not found with id " + id));
    }

    // Read (get all)
    public List<Assemblee> getAllAssemblees() {
        return assembleeRepository.findAll();
    }

    public Optional<Assemblee> getAssembleeById(int id) {
        return assembleeRepository.findById(id);
    }

    // Delete
    public void deleteAssemblee(int id) {
        assembleeRepository.deleteById(id);
    }

        public List<TypeAssemblee> getAllTypeAssemblees() {
            return typeAssembleeRepository.findAll();
        }
    }

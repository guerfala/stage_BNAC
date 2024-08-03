package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Repositories.TypeAssembleeRepository;
import bnac.bnac_emetteur.Entities.TypeAssemblee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeAssembleeService {

    @Autowired
    private TypeAssembleeRepository typeAssembleeRepository;

    public List<TypeAssemblee> getAllTypeAssemblees() {
        return typeAssembleeRepository.findAll();
    }
}

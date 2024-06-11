package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.Operation;
import bnac.bnac_emetteur.Repositories.OperationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    @Autowired
    private OperationRepo operationRepo;

    public List<Operation> ShowAllOperation()
    {
        List<Operation> operations = this.operationRepo.findAll();
        return operations;
    }
}

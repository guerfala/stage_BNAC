package bnac.bnac_emetteur.Services;

import bnac.bnac_emetteur.Entities.TypeOperation;
import bnac.bnac_emetteur.Repositories.TypeOperationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOperationService {

    @Autowired
    private TypeOperationRepo typeOperationRepo;

    public List<TypeOperation> ShowAllTypeOperation()
    {
        List<TypeOperation> typeOperations = this.typeOperationRepo.findAll();
        return typeOperations;
    }

    public void AddTypeOperation(TypeOperation typeOperation)
    {
        this.typeOperationRepo.save(typeOperation);
    }

    public void DeleteTypeOperation(String typeOperationId)
    {
        TypeOperation typeOperation = this.typeOperationRepo.findById(typeOperationId).get();
        this.typeOperationRepo.delete(typeOperation);
    }

    public void UpdateTypeOperation(String typeOperationId, TypeOperation typeOperation)
    {
        TypeOperation to = this.typeOperationRepo.findById(typeOperationId).get();

        to.setLibelle(typeOperation.getLibelle());
        to.setSens(typeOperation.getSens());
        to.setIdTypeAnnulation(typeOperation.getIdTypeAnnulation());
        to.setAcomptabiliser(typeOperation.isAcomptabiliser());
        to.setOperationOST(typeOperation.isOperationOST());
        to.setIdOrigineOperation(typeOperation.getIdOrigineOperation());
        to.setSensN(typeOperation.getSensN());
        to.setSensO(typeOperation.getSensO());
        to.setOperationDivers(typeOperation.isOperationDivers());
        to.setCodeOperation(typeOperation.getCodeOperation());

        this.typeOperationRepo.save(to);
    }
}

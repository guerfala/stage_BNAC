package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.TypeOperation_N;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TypeOperationNRepo extends JpaRepository<TypeOperation_N, String> {

    @Query("select typeOp from TypeOperation_N typeOp where typeOp.CodeOperationCsd = :code and typeOp.Sens_Comptable = :sens and typeOp.LibelleCsd = :libelle ")
    public TypeOperation_N GetTypeOperation(@Param("code") String code, @Param("sens") String sens, @Param("libelle") String libelle);
}

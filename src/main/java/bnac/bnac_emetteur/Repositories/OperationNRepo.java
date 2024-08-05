package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Operation_N;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationNRepo extends JpaRepository<Operation_N, Integer> {
    @Query("select o from Operation_N o where o.emetteur.idEmetteur = :idEmetteur order by o.IdOperation desc limit 1")
    public Operation_N GetLastOperation(@Param("idEmetteur") String idEmetteur);
}

package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StatusRepo extends JpaRepository<Status, String> {

    @Query("select s from Status s where s.codeTunCl= :statut ")
    Status findBycodeTunCl(@Param("statut") String statut);
}

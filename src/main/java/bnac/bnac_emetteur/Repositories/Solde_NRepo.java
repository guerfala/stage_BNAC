package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.SoldePk;
import bnac.bnac_emetteur.Entities.Solde_N;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface Solde_NRepo extends JpaRepository<Solde_N, SoldePk> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Solde_N s WHERE s.IdTitre = :titre")
    void deleteAllByTitre(@Param("titre") String titre);
}

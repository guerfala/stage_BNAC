package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Emetteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmetteurRepo extends JpaRepository<Emetteur,String> {
    @Query("SELECT e.libelleCourt FROM Emetteur e")
    List<String> findAllEmetteurLibelleCourt();

    @Query("SELECT e FROM Emetteur e WHERE e.libelleCourt LIKE %:query%")
    List<Emetteur> findByLibelleCourtContaining(@Param("query") String query);
}

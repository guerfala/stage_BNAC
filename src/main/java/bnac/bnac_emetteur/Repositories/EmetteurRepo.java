package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Emetteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmetteurRepo extends JpaRepository<Emetteur,String> {
    @Query("SELECT e.libelleCourt FROM Emetteur e")
    List<String> findAllEmetteurLibelleCourt();
}

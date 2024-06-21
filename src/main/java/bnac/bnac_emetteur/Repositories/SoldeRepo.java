package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.DTO.SoldeDTO;
import bnac.bnac_emetteur.Entities.Solde;
import bnac.bnac_emetteur.Entities.SoldePk;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SoldeRepo extends JpaRepository<Solde, SoldePk> {

    @Query("SELECT a.Matricule, a.RaisonSociale, " +
            "ROUND(CAST(SUM(s.Solde) AS DOUBLE) * 100 / t.Nombre, 3) as prtage, " +
            "SUM(s.Solde) AS solde " +
            "FROM Actionnaire a " +
            "JOIN Solde s ON a.Matricule = s.Matricule " +
            "JOIN Titre t ON t.IdTitre = s.IdTitre AND t.emetteur.idEmetteur = a.emetteur.idEmetteur " +
            "WHERE s.IdTitre = :idTitre " +
            "AND s.dateMaj <= :selectedDate " +
            "GROUP BY a.Matricule, a.RaisonSociale, t.Nombre " +
            "HAVING ROUND(CAST(SUM(s.Solde) AS FLOAT) * 100 / t.Nombre, 3) >= 0 " +
            "ORDER BY prtage DESC")
    List<Object[]> findCapitaleNative(@Param("idTitre") String idTitre, @Param("selectedDate") LocalDateTime selectedDate);

}

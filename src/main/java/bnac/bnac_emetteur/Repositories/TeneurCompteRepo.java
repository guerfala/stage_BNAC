package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.DTO.TeneurCompteDTO;
import bnac.bnac_emetteur.Entities.TeneurCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TeneurCompteRepo extends JpaRepository<TeneurCompte,String> {
    @Query("SELECT new bnac.bnac_emetteur.DTO.TeneurCompteDTO(tc.IdTC, tc.LibelleCourt, nct.CodeNatureCompteTitre, nct.Libelle, nv.CodeCategorieAvoir, nv.Libelle, SUM(s.Solde)) " +
            "FROM Emetteur e, Solde s, TeneurCompte tc, NatureCompteTitre nct, NatureAvoir nv, Titre t " +
            "WHERE t.emetteur.idEmetteur = e.idEmetteur " +
            "AND s.IdTC = tc.IdTC " +
            "AND s.IdNatureCompteTitre = nct.IdNatureCompteTitre " +
            "AND s.IdNatureAvoirs = nv.IdNatureAvoirs " +
            "AND s.IdTitre = :idTitre " +
            "AND s.dateMaj <= :selectedDate " +
            "AND s.Solde > 0 " +
            "GROUP BY tc.IdTC, tc.LibelleCourt, nct.CodeNatureCompteTitre, nct.Libelle, nv.CodeCategorieAvoir, nv.Libelle")
    List<TeneurCompteDTO> findTeneurCompteAndSoldeByEmetteurAndTitre(@Param("idTitre") String idTitre, @Param("selectedDate") LocalDateTime selectedDate);

}

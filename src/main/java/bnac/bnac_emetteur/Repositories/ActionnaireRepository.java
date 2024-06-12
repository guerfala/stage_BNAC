package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.DTO.ActionnaireDTO;
import bnac.bnac_emetteur.Entities.Actionnaire;
import bnac.bnac_emetteur.Entities.Emetteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionnaireRepository extends JpaRepository<Actionnaire, String> {

    /*@Query("SELECT a " +
            "FROM Actionnaire a, Emetteur e, Solde s, TeneurCompte tc, NatureCompteTitre nct, NatureAvoir nv, Titre t " +
            "WHERE a.Matricule = s.Matricule " +
            "AND t.emetteur.idEmetteur = e.idEmetteur " +
            "AND s.IdNatureCompteTitre = nct.IdNatureCompteTitre " +
            "AND s.IdNatureAvoirs = nv.IdNatureAvoirs " +
            "AND a.emetteur.idEmetteur = :idEmetteur " +
            "AND s.IdTitre = :idTitre " +
            "GROUP BY a.Matricule, a.RaisonSociale, a.Identifiant, tc.LibelleCourt, s.Solde, nct.CodeNatureCompteTitre, nv.CodeCategorieAvoir, a.Adresse")
    List<Actionnaire> findActionnaires(@Param("idEmetteur") String idEmetteur,
                                       @Param("idTitre") String idTitre);*/

    @Query("SELECT new bnac.bnac_emetteur.DTO.ActionnaireDTO(a.Matricule, a.RaisonSociale, a.Identifiant, tc.LibelleCourt, s.Solde, nct.CodeNatureCompteTitre, nv.CodeCategorieAvoir, a.Adresse) " +
            "FROM Actionnaire a, Emetteur e, Solde s, TeneurCompte tc, NatureCompteTitre nct, NatureAvoir nv, Titre t " +
            "WHERE a.Matricule = s.Matricule " +
            "AND t.emetteur.idEmetteur = e.idEmetteur " +
            "AND s.IdNatureCompteTitre = nct.IdNatureCompteTitre " +
            "AND s.IdNatureAvoirs = nv.IdNatureAvoirs " +
            "AND a.emetteur.idEmetteur = :idEmetteur " +
            "AND s.IdTitre = :idTitre " +
            "GROUP BY a.Matricule, a.RaisonSociale, a.Identifiant, tc.LibelleCourt, s.Solde, nct.CodeNatureCompteTitre, nv.CodeCategorieAvoir, a.Adresse")
    List<ActionnaireDTO> findActionnaires(@Param("idEmetteur") String idEmetteur,
                                          @Param("idTitre") String idTitre);

}

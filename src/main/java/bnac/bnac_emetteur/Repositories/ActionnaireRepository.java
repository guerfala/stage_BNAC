package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.DTO.ActionnaireDTO;
import bnac.bnac_emetteur.DTO.SoldeDTO;
import bnac.bnac_emetteur.Entities.Actionnaire;
import bnac.bnac_emetteur.Entities.Emetteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ActionnaireRepository extends JpaRepository<Actionnaire, String> {

    @Query("Select new bnac.bnac_emetteur.DTO.ActionnaireDTO(a.Matricule, a.RaisonSociale,a.IdPays, a.Identifiant,a.NaturePiece,tc.LibelleCourt,nct.CodeNatureCompteTitre, nv.CodeCategorieAvoir, s.Solde) " +
            "from Actionnaire a, Emetteur e,Solde s,TeneurCompte tc, NatureCompteTitre nct, NatureAvoir nv, Titre t " +
            "Where  a.Matricule=s.Matricule and t.emetteur.idEmetteur=e.idEmetteur and s.IdTC=tc.IdTC and s.IdNatureCompteTitre=nct.IdNatureCompteTitre and s.IdNatureAvoirs=nv.IdNatureAvoirs and s.teneurCompte.IdTC=tc.IdTC and s.IdNatureCompteTitre=nct.IdNatureCompteTitre and s.IdNatureAvoirs=nv.IdNatureAvoirs and a.emetteur.idEmetteur= :idEmetteur and s.IdTitre= :idTitre " +
            "group by a.Matricule, a.RaisonSociale, a.Identifiant,tc.LibelleCourt,s.Solde,nct.CodeNatureCompteTitre, nv.CodeCategorieAvoir,a.NaturePiece, a.IdPays")
    List<ActionnaireDTO> findActionnaires(@Param("idEmetteur") String idEmetteur, @Param("idTitre") String idTitre);

    @Query("Select new bnac.bnac_emetteur.DTO.ActionnaireDTO(a.Matricule, a.RaisonSociale,a.IdPays, a.Identifiant,a.NaturePiece,tc.LibelleCourt,nct.CodeNatureCompteTitre, nv.CodeCategorieAvoir, s.Solde, a.Adresse) " +
            "from Actionnaire a, Emetteur e,Solde s,TeneurCompte tc, NatureCompteTitre nct, NatureAvoir nv, Titre t " +
            "Where  a.Matricule=s.Matricule and t.emetteur.idEmetteur=e.idEmetteur and s.IdTC=tc.IdTC and s.IdNatureCompteTitre=nct.IdNatureCompteTitre and s.IdNatureAvoirs=nv.IdNatureAvoirs and s.teneurCompte.IdTC=tc.IdTC and s.IdNatureCompteTitre=nct.IdNatureCompteTitre and s.IdNatureAvoirs=nv.IdNatureAvoirs and a.emetteur.idEmetteur= :idEmetteur and s.IdTitre= :idTitre and s.Solde > 0 " +
            "AND s.dateMaj <= :selectedDate " +
            "group by a.Matricule, a.RaisonSociale, a.Identifiant,tc.LibelleCourt,s.Solde,nct.CodeNatureCompteTitre, nv.CodeCategorieAvoir,a.NaturePiece, a.IdPays")
    List<ActionnaireDTO> findEtatActionnairesByEmetteurAndTitre(@Param("idEmetteur") String idEmetteur, @Param("idTitre") String idTitre, @Param("selectedDate") LocalDateTime selectedDate);

    @Query("Select new bnac.bnac_emetteur.DTO.ActionnaireDTO(a.Matricule, a.RaisonSociale,a.IdPays, a.Identifiant,a.NaturePiece,tc.LibelleCourt,nct.CodeNatureCompteTitre, nv.CodeCategorieAvoir, s.Solde, a.Adresse) " +
            "from Actionnaire a, Emetteur e,Solde s,TeneurCompte tc, NatureCompteTitre nct, NatureAvoir nv, Titre t " +
            "Where  a.Matricule=s.Matricule and t.emetteur.idEmetteur=e.idEmetteur and s.IdTC=tc.IdTC and s.IdNatureCompteTitre=nct.IdNatureCompteTitre and s.IdNatureAvoirs=nv.IdNatureAvoirs and s.teneurCompte.IdTC= :idTC and s.IdNatureCompteTitre=nct.IdNatureCompteTitre and s.IdNatureAvoirs=nv.IdNatureAvoirs and a.emetteur.idEmetteur= :idEmetteur and s.IdTitre= :idTitre and s.Solde > 0 " +
            "AND s.dateMaj <= :selectedDate " +
            "group by a.Matricule, a.RaisonSociale, a.Identifiant,tc.LibelleCourt,s.Solde,nct.CodeNatureCompteTitre, nv.CodeCategorieAvoir,a.NaturePiece, a.IdPays")
    List<ActionnaireDTO> findEtatActionnairesByEmetteurAndTitreAndTC(@Param("idEmetteur") String idEmetteur, @Param("idTitre") String idTitre, @Param("idTC") String idTC, @Param("selectedDate") LocalDateTime selectedDate);

    @Query("Select new bnac.bnac_emetteur.DTO.ActionnaireDTO(a.Matricule, a.RaisonSociale,a.IdPays, a.Identifiant,a.NaturePiece,tc.LibelleCourt,nct.CodeNatureCompteTitre, nv.CodeCategorieAvoir, s.Solde, a.Adresse) " +
            "from Actionnaire a, Emetteur e,Solde s,TeneurCompte tc, NatureCompteTitre nct, NatureAvoir nv, Titre t " +
            "Where  a.Matricule=s.Matricule and t.emetteur.idEmetteur=e.idEmetteur and s.IdTC=tc.IdTC and s.IdNatureCompteTitre=nct.IdNatureCompteTitre and s.IdNatureAvoirs=nv.IdNatureAvoirs and s.teneurCompte.IdTC= :idTC and s.IdNatureCompteTitre= :idNatureCompte and s.IdNatureAvoirs=nv.IdNatureAvoirs and a.emetteur.idEmetteur= :idEmetteur and s.IdTitre= :idTitre and s.Solde > 0 " +
            "AND s.dateMaj <= :selectedDate " +
            "group by a.Matricule, a.RaisonSociale, a.Identifiant,tc.LibelleCourt,s.Solde,nct.CodeNatureCompteTitre, nv.CodeCategorieAvoir,a.NaturePiece, a.IdPays")
    List<ActionnaireDTO> findEtatActionnairesByEmetteurAndTitreAndTCAndNatureCompte(@Param("idEmetteur") String idEmetteur, @Param("idTitre") String idTitre, @Param("idTC") String idTC, @Param("idNatureCompte") String idNatureCompte, @Param("selectedDate") LocalDateTime selectedDate);

    @Query("Select new bnac.bnac_emetteur.DTO.ActionnaireDTO(a.Matricule, a.RaisonSociale,a.IdPays, a.Identifiant,a.NaturePiece,tc.LibelleCourt,nct.CodeNatureCompteTitre, nv.CodeCategorieAvoir, s.Solde, a.Adresse) " +
            "from Actionnaire a, Emetteur e,Solde s,TeneurCompte tc, NatureCompteTitre nct, NatureAvoir nv, Titre t " +
            "Where  a.Matricule=s.Matricule and t.emetteur.idEmetteur=e.idEmetteur and s.IdTC=tc.IdTC and s.IdNatureCompteTitre=nct.IdNatureCompteTitre and s.IdNatureAvoirs=nv.IdNatureAvoirs and s.teneurCompte.IdTC= :idTC and s.IdNatureCompteTitre= :idNatureCompte and s.IdNatureAvoirs= :idNatureAvoir and a.emetteur.idEmetteur= :idEmetteur and s.IdTitre= :idTitre and s.Solde > 0 " +
            "AND s.dateMaj <= :selectedDate " +
            "group by a.Matricule, a.RaisonSociale, a.Identifiant,tc.LibelleCourt,s.Solde,nct.CodeNatureCompteTitre, nv.CodeCategorieAvoir,a.NaturePiece, a.IdPays")
    List<ActionnaireDTO> findEtatActionnairesByEmetteurAndTitreAndTCAndNatureCompteAndNatureAvoir(@Param("idEmetteur") String idEmetteur, @Param("idTitre") String idTitre, @Param("idTC") String idTC, @Param("idNatureCompte") String idNatureCompte, @Param("idNatureAvoir") String idNatureAvoir, @Param("selectedDate") LocalDateTime selectedDate);

}

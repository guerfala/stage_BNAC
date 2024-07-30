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

    @Query("select s from Solde_N s where s.IdTitre = :idTitre and s.Matricule = :matricule and s.IdTC = :idTC and s.IdNatureCompteTitre = :idNCT and s.IdNatureAvoirs = :idNA")
    Solde_N VerifSoldeExist(@Param("idTitre") String idTitre, @Param("matricule") int matricule, @Param("idTC") String idTC, @Param("idNCT") int idNCT, @Param("idNA") int idNA);

    @Query("select s from Solde_N s where s.IdTitre = :idTitre and s.Matricule = :matricule and s.IdTC = :idTC and s.IdNatureCompteTitre = 1 and s.IdNatureAvoirs = :idNA")
    Solde_N GetSoldeMain(@Param("idTitre") String idTitre, @Param("matricule") int matricule, @Param("idTC") String idTC, @Param("idNA") int idNA);

    @Query("select s from Solde_N s where s.IdTitre = :idTitre and s.Matricule = :matricule and s.IdTC = :idTC and s.IdNatureCompteTitre = 7 and s.IdNatureAvoirs = :idNA")
    Solde_N GetSoldeFrozen(@Param("idTitre") String idTitre, @Param("matricule") int matricule, @Param("idTC") String idTC, @Param("idNA") int idNA);

    @Query("select s from Solde_N s where s.IdTitre = :idTitre and s.Matricule = :matricule and s.IdTC = :idTC and s.IdNatureCompteTitre = 3 and s.IdNatureAvoirs = :idNA")
    Solde_N GetSoldePledge(@Param("idTitre") String idTitre, @Param("matricule") int matricule, @Param("idTC") String idTC, @Param("idNA") int idNA);

    @Query("select s from Solde_N s where s.IdTitre = :idTitre and s.Matricule = :matricule and s.IdTC = :idTC and s.IdNatureCompteTitre = 4 and s.IdNatureAvoirs = :idNA")
    Solde_N GetSoldeOpposition(@Param("idTitre") String idTitre, @Param("matricule") int matricule, @Param("idTC") String idTC, @Param("idNA") int idNA);

}
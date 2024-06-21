package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.DTO.MouvementsDTO;
import bnac.bnac_emetteur.Entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OperationRepo extends JpaRepository<Operation,Integer> {

    @Query("Select new bnac.bnac_emetteur.DTO.MouvementsDTO(tc.LibelleCourt, cast(o.DateBourse as date), a.RaisonSociale, o.NumContrat, Cast((CASE WHEN o.typeOperation.IdTypeOperation='VC'THEN o.Quantite ELSE '0' END) AS integer)," +
            "cast((CASE WHEN o.typeOperation.IdTypeOperation='AC'THEN o.Quantite ELSE '0' END) AS integer ), round(o.Cours,3)) " +
            "from Actionnaire a, Titre t, Operation o, TeneurCompte tc " +
            "Where a.Matricule=o.actionnaire.Matricule " +
            "and t.IdTitre=o.titre.IdTitre " +
            "and t.emetteur.idEmetteur=a.emetteur.idEmetteur  " +
            "and o.teneurCompte.IdTC=tc.IdTC " +
            "and o.actionnaire.Matricule=a.Matricule " +
            "and o.typeOperation.IdTypeOperation in ('AC','VC') " +
            "and o.titre.IdTitre= :idTitre  " +
            "and o.DateBourse between :minDate and :maxDate")
    List<MouvementsDTO> findAllOperation(@Param("idTitre") String idTitre, @Param("minDate") LocalDateTime minDate, @Param("maxDate") LocalDateTime maxDate);

    @Query("Select new bnac.bnac_emetteur.DTO.MouvementsDTO(tc.LibelleCourt, cast(o.DateBourse as date), a.RaisonSociale, o.NumContrat, Cast((CASE WHEN o.typeOperation.IdTypeOperation='VC'THEN o.Quantite ELSE '0' END) AS integer)," +
            "cast((CASE WHEN o.typeOperation.IdTypeOperation='AC'THEN o.Quantite ELSE '0' END) AS integer ), round(o.Cours,3)) " +
            "from Actionnaire a, Titre t, Operation o, TeneurCompte tc " +
            "Where a.Matricule=o.actionnaire.Matricule " +
            "and t.IdTitre=o.titre.IdTitre " +
            "and t.emetteur.idEmetteur=a.emetteur.idEmetteur  " +
            "and o.teneurCompte.IdTC=tc.IdTC " +
            "and o.actionnaire.Matricule=a.Matricule " +
            "and o.typeOperation.IdTypeOperation in ('AC','VC') " +
            "and o.titre.IdTitre= :idTitre  " +
            "and o.teneurCompte.IdTC= :idTC  " +
            "and o.DateBourse between :minDate and :maxDate")
    List<MouvementsDTO> findAllOperationByTc(@Param("idTitre") String idTitre, @Param("minDate") LocalDateTime minDate, @Param("maxDate") LocalDateTime maxDate, @Param("idTC") String idTC);
}

package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.DTO.FCRA;
import bnac.bnac_emetteur.DTO.FGO;
import bnac.bnac_emetteur.Entities.Operation_N;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface OperationNRepo extends JpaRepository<Operation_N, Integer> {
    @Query("select o from Operation_N o where o.emetteur.idEmetteur = :idEmetteur order by o.IdOperation desc limit 1")
    public Operation_N GetLastOperation(@Param("idEmetteur") String idEmetteur);

    @Query("select new bnac.bnac_emetteur.DTO.FGO('', tc.CodeSwift, tc.CodeIAA, s.CodeNatureActionnaire, a.Libelle_Client, '', " +
            "'', a.NaturePiece, a.Identifiant, a.Date_Naissance, a.status.idStatus, " +
            "'99', a.IdPays, case when CAST(a.Resident as string) = 'true' then 'RD' else 'NR' end, a.Adresse, '', '', '', '', " +
            "'', '', CAST(o.IdOperation AS string), o.DateOperation, o.DateBourse, to.CodeOperationCsd, " +
            "to.Sens_Comptable, o.NumContrat, t.CodeSISIN, '', '', '', " +
            "case when na.CodeCategorieAvoir = '001' then '0' else '1' end, nc.codeNT, na.CodeCategorieAvoir, " +
            "CAST(o.Quantite AS string), 'BICREPLACER', '', a.IdPays) " +
            "from TeneurCompte tc, Status s, Actionnaire_N a, Operation_N o, TypeOperation_N to, Titre t, NatureAvoir na, NatureCompteTitre nc " +
            "where a.Matricule = o.actionnaire.Matricule " +
            "and a.emetteur.idEmetteur = o.emetteur.idEmetteur " +
            "and o.titre.IdTitre = t.IdTitre " +
            "and o.teneurCompte.IdTC = tc.IdTC " +
            "and o.natureAvoir.IdNatureAvoirs = na.IdNatureAvoirs " +
            "and a.status.idStatus = s.idStatus " +
            "and o.typeOperation.IdTypeOperation = to.IdTypeOperation " +
            "and o.natureCompteTitre.IdNatureCompteTitre = nc.IdNatureCompteTitre " +
            "and o.emetteur.idEmetteur = :idEmetteur " +
            "and o.titre.IdTitre = :idTitre " +
            "and o.DateBourse between :minDate and :maxDate")
    List<FGO> getFGO(@Param("idEmetteur") String idEmetteur, @Param("idTitre") String idTitre, @Param("minDate") LocalDate minDate, @Param("maxDate") LocalDate maxDate);

    @Query("select new bnac.bnac_emetteur.DTO.FCRA('', tc.CodeSwift, tc.CodeIAA, s.CodeNatureActionnaire, a.Libelle_Client, a.Libelle_Client, " +
            "'', a.NaturePiece, CAST(a.Identifiant AS string), a.Date_Naissance, a.status.idStatus, " +
            "'99', a.IdPays, case when a.Resident = true then 'RD' else 'NR' end, a.Adresse, '', '', '', '', " +
            "'', a.IdPays, '', t.CodeSISIN, '', '', '', case when na.CodeCategorieAvoir = '001' then '0' else '1' end, " +
            "nc.codeNT, na.CodeCategorieAvoir, CAST(so.Solde AS string), local_date ) " +
            "from TeneurCompte tc, Status s, Actionnaire_N a, Solde_N so, Titre t, NatureAvoir na, NatureCompteTitre nc " +
            "where a.Matricule = so.actionnaire.Matricule " +
            "and so.titre.IdTitre = t.IdTitre " +
            "and t.emetteur.idEmetteur = a.emetteur.idEmetteur " +
            "and so.teneurCompte.IdTC = tc.IdTC " +
            "and so.natureAvoir.IdNatureAvoirs = na.IdNatureAvoirs " +
            "and a.status.idStatus = s.idStatus " +
            "and so.natureCompteTitre.IdNatureCompteTitre = nc.IdNatureCompteTitre " +
            "and a.emetteur.idEmetteur = :idEmetteur " +
            "and so.titre.IdTitre = :idTitre " +
            "and so.dateMaj between :minDate and :maxDate")
    List<FCRA> getFCRA(@Param("idEmetteur") String idEmetteur, @Param("idTitre") String idTitre, @Param("minDate") LocalDateTime minDate, @Param("maxDate") LocalDateTime maxDate);
}

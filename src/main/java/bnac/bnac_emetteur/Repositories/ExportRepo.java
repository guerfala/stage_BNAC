package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.DTO.FGO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExportRepo {

    @Query("select tc.CodeSwift, tc.CodeIAA, s.CodeNatureActionnaire, a.Libelle_Client, a.NaturePiece, a.Identifiant, " +
            "a.status.idStatus, a.IdPays, a.Resident, a.Adresse, o.IdOperation, o.DateOperation, o.DateBourse, to.CodeOperationCsd, " +
            "to.Sens_Comptable, o.NumContrat, t.CodeSISIN, na.CodeCategorieAvoir, nc.codeNT, o.Quantite " +
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
}

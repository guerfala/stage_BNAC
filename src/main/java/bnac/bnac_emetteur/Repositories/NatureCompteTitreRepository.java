package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.NatureAvoir;
import bnac.bnac_emetteur.Entities.NatureCompteTitre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NatureCompteTitreRepository extends JpaRepository<NatureCompteTitre, Integer> {

    @Query("select IdNatureCompteTitre from NatureCompteTitre where LibelleNT= :libellent ")
    int findIdByLibelleNT(@Param("libellent") String libellent);

    @Query("select n from NatureCompteTitre n where n.LibelleNT= :libellent ")
    NatureCompteTitre findNatureCompteTitreByLibelleNT(@Param("libellent") String libellent);
}

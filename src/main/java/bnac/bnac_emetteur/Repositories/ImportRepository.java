package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Import;
import bnac.bnac_emetteur.Entities.Titre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImportRepository extends JpaRepository<Import, Integer> {

    @Query("SELECT i FROM Import i WHERE i.Type_import = 'FGO' AND i.Treated = false AND i.emetteur.idEmetteur = :idEmetteur AND i.Titre.IdTitre = :idTitre")
    List<Import> findAllFGO(@Param("idEmetteur") String idEmetteur, @Param("idTitre") String idTitre);

    @Query("SELECT i FROM Import i WHERE i.Type_import = 'FCRA' AND i.Treated = false AND i.emetteur.idEmetteur = :idEmetteur AND i.Titre.IdTitre = :idTitre")
    List<Import> findAllFCRA(@Param("idEmetteur") String idEmetteur, @Param("idTitre") String idTitre);

}

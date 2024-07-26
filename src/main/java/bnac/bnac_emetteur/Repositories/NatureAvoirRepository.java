package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.NatureAvoir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NatureAvoirRepository extends JpaRepository<NatureAvoir,Integer> {

    @Query("select n from NatureAvoir n where n.CodeCategorieAvoir = :code")
    NatureAvoir findByCodeCategorieAvoir(@Param("code") String code);
}

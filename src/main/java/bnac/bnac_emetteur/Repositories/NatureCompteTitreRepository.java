package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.NatureCompteTitre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NatureCompteTitreRepository extends JpaRepository<NatureCompteTitre, Integer> {
}

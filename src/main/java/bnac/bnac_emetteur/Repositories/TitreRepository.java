package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.NatureCompteTitre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TitreRepository extends JpaRepository<NatureCompteTitre, Integer> {
}

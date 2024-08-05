package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.ImportAnomalie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportAnomalieRepo extends JpaRepository<ImportAnomalie, Integer> {
}

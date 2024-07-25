package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Import;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportRepository extends JpaRepository<Import, Integer> {
}

package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Assemblee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AssembleeRepository extends JpaRepository<Assemblee, Integer> {
}

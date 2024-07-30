package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Operation_N;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationNRepo extends JpaRepository<Operation_N, Integer> {
}

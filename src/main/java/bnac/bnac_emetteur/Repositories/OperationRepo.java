package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepo extends JpaRepository<Operation,Integer> {
}

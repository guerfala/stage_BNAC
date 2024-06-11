package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.TypeOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOperationRepo extends JpaRepository<TypeOperation,String> {
}

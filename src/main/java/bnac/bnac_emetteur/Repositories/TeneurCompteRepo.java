package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.TeneurCompte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeneurCompteRepo extends JpaRepository<TeneurCompte,String> {
}

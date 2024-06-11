package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Solde;
import bnac.bnac_emetteur.Entities.SoldePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldeRepo extends JpaRepository<Solde, SoldePk> {
}

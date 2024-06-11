package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Emetteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmetteurRepository extends JpaRepository<Emetteur, String> {
}

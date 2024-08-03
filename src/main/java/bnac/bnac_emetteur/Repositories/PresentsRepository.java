package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Presents;
import bnac.bnac_emetteur.Entities.PresentsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentsRepository extends JpaRepository<Presents, PresentsId> {
}

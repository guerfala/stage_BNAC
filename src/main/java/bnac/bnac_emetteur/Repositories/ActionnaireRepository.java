package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Actionnaire;
import bnac.bnac_emetteur.Entities.Emetteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionnaireRepository extends JpaRepository<Actionnaire, String> {

}

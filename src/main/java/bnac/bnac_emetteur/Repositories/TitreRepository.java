package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Titre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitreRepository extends JpaRepository<Titre, String> {

    List<Titre> findByEmetteur_IdEmetteur(String idEmetteur);
}

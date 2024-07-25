package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.Titre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitreRepository extends JpaRepository<Titre, String> {
    @Query("SELECT t.LibelleCourt FROM Titre t WHERE t.emetteur.idEmetteur = :emetteurId")
    List<String> findLibelleCourtByEmetteurId(String emetteurId);}

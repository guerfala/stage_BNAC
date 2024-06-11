package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.NatureAvoir;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NatureAvoirRepository extends JpaRepository<NatureAvoir,Integer> {
//    Optional<NatureAvoir> findById(int id);
//
//    List<NatureAvoir> findAll();
//
//    NatureAvoir save(NatureAvoir natureAvoir);
//
//    void deleteById(int id);
//
//    void deleteAll();
}

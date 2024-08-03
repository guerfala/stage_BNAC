package bnac.bnac_emetteur.Repositories;

import bnac.bnac_emetteur.Entities.TypeAssemblee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeAssembleeRepository extends JpaRepository<TypeAssemblee, String> {

}

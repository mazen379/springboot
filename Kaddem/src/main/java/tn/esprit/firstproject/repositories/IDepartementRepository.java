package tn.esprit.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.entities.Departement;

public interface IDepartementRepository extends CrudRepository<Departement,Integer> {
}

package tn.esprit.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstproject.entities.Contrat;

public interface IContratRepository extends CrudRepository<Contrat,Integer> {
}

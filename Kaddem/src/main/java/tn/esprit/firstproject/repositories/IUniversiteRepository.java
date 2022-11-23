package tn.esprit.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstproject.entities.Universite;

public interface IUniversiteRepository extends CrudRepository<Universite,Integer> {
}

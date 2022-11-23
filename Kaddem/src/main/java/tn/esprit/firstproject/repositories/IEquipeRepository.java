package tn.esprit.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstproject.entities.Equipe;

public interface IEquipeRepository extends CrudRepository<Equipe,Integer> {
}

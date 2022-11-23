package tn.esprit.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstproject.entities.Etudiant;

public interface IEtudiantRepository extends CrudRepository<Etudiant,Integer> {
}

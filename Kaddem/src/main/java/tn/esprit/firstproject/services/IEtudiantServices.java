package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Etudiant;

import java.util.List;

public interface IEtudiantServices {

    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant (Etudiant e);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(Integer idEtudiant);

    void removeEtudiant(Integer idEtudiant);

    Etudiant asignDepToEt(Integer idEt, Integer idDep);

    Etudiant assignEtToEq(Integer idEt, Integer idEq);
}

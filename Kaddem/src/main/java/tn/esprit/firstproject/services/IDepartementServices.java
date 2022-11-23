package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Departement;

import java.util.List;

public interface IDepartementServices {

    List<Departement> retrieveAllDepartements();

    Departement addDepartement (Departement d);

    Departement updateDepartement (Departement d);

    Departement retrieveDepartement (Integer idDepart);
}

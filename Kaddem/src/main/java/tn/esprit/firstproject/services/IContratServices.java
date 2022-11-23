package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Contrat;

import java.util.List;

public interface IContratServices {

    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);

    Contrat addContrat (Contrat ce);

    Contrat retrieveContrat (Integer idContrat);

    void removeContrat(Integer idContrat);

    Contrat assignEtu(Integer idContrat,Integer idEtudiant);
}

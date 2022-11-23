package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Equipe;

import java.util.List;

public interface IEquipeServices {

    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail

    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe (Integer idEquipe);
}

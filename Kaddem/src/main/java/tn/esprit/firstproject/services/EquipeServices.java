package tn.esprit.firstproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.repositories.IEquipeRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EquipeServices implements IEquipeServices {

    IEquipeRepository iEquipeRepository;

    @Override
    public List<Equipe> retrieveAllEquipes() {
        List<Equipe> equipeList = new ArrayList<>();
        iEquipeRepository.findAll().forEach(equipeList::add);
        return equipeList;
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return iEquipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return addEquipe(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return iEquipeRepository.findById(idEquipe).orElse(null);
    }
}

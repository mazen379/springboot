package tn.esprit.firstproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.repositories.IDepartementRepository;
import tn.esprit.firstproject.repositories.IUniversiteRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class UniversiteServices implements IUniversiteServices {

    IUniversiteRepository iUniversiteRepository;

    IDepartementRepository iDepartementRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        List<Universite> universiteList = new ArrayList<>();
        iUniversiteRepository.findAll().forEach(universiteList::add);
        return universiteList;
    }

    @Override
    public Universite addUniversite(Universite u) {
        return iUniversiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return iUniversiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return iUniversiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite assignDep(Integer idUniversite, Integer idDepartement) {
        Universite u = iUniversiteRepository.findById(idUniversite).orElse(null);
        Departement d = iDepartementRepository.findById(idDepartement).orElse(null);
        if(u.getDepartements() == null)
        {
            Set<Departement> departements = new HashSet<>();
            departements.add(d);
            u.setDepartements(departements);
        }
        else
            u.getDepartements().add(d);
        return iUniversiteRepository.save(u);
    }
}

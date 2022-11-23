package tn.esprit.firstproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.repositories.IDepartementRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class DepartementServices implements IDepartementServices {

    IDepartementRepository iDepartementRepository;

    @Override
    public List<Departement> retrieveAllDepartements() {
        List<Departement> departementList = new ArrayList<>();
        iDepartementRepository.findAll().forEach(departementList::add);
        return departementList;
    }

    @Override
    public Departement addDepartement(Departement d) {
        return iDepartementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return iDepartementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return iDepartementRepository.findById(idDepart).orElse(null);
    }
}

package tn.esprit.firstproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.repositories.IDepartementRepository;
import tn.esprit.firstproject.repositories.IEquipeRepository;
import tn.esprit.firstproject.repositories.IEtudiantRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class EtudiantServices implements IEtudiantServices {

    IEtudiantRepository iEtudiantRepository;

    IDepartementRepository iDepartementRepository;

    IEquipeRepository iEquipeRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        List<Etudiant> etudiantList = new ArrayList<>();
        iEtudiantRepository.findAll().forEach(etudiantList::add);
        return etudiantList;
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return iEtudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return iEtudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return iEtudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
         iEtudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant asignDepToEt(Integer idEt, Integer idDep)
    {
        Etudiant e = iEtudiantRepository.findById(idEt).orElse(null);
        Departement d = iDepartementRepository.findById(idDep).orElse(null);
        e.setDepartement(d);
        return iEtudiantRepository.save(e);
    }

    @Override
    public Etudiant assignEtToEq(Integer idEt, Integer idEq) {
        Etudiant et = iEtudiantRepository.findById(idEt).orElse(null);
        Equipe eq = iEquipeRepository.findById(idEq).orElse(null);
        if(et.getEquipes() == null)
        {
            Set<Equipe> equipes = new HashSet<>();
            equipes.add(eq);
            et.setEquipes(equipes);
        }
        else
            et.getEquipes().add(eq);
        return iEtudiantRepository.save(et);
    }
}

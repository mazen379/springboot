package tn.esprit.firstproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.repositories.IContratRepository;
import tn.esprit.firstproject.repositories.IEtudiantRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ContratServices implements IContratServices {

    IContratRepository iContratRepository;

    IEtudiantRepository iEtudiantRepository;
    @Override
    public List<Contrat> retrieveAllContrats() {
        List<Contrat> contratList = new ArrayList<>();
        iContratRepository.findAll().forEach(contratList::add);
        return contratList;
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return iContratRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return iContratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return iContratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        iContratRepository.deleteById(idContrat);
    }

    @Override
    public Contrat assignEtu(Integer idContrat, Integer idEtudiant) {
        Contrat c = iContratRepository.findById(idContrat).orElse(null);
        Etudiant e = iEtudiantRepository.findById(idEtudiant).orElse(null);
        c.setEtudiant(e);
        return iContratRepository.save(c);
    }
}

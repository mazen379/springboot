package tn.esprit.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.services.IEtudiantServices;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantRestController {

   IEtudiantServices iEtudiantServices;

   @Autowired
    public EtudiantRestController(IEtudiantServices iEtudiantServices) {
        this.iEtudiantServices = iEtudiantServices;
    }

    @GetMapping("/all")
    public List<Etudiant> getAllEtudiant() {
        return iEtudiantServices.retrieveAllEtudiants();
    }

    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return iEtudiantServices.updateEtudiant(e);
    }

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return iEtudiantServices.addEtudiant(e);
    }

    @GetMapping("get/{id}")
    public Etudiant getEtudiant(@PathVariable("id") Integer idEtudiant)
    {
        return iEtudiantServices.retrieveEtudiant(idEtudiant);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable("id") Integer idContrat)
    {
        iEtudiantServices.removeEtudiant(idContrat);
    }

    @PutMapping("/assign/{idEt}/{idDep}")
    public  Etudiant assignEtudiant(@PathVariable("idEt") Integer idEt, @PathVariable("idDep") Integer idDep)
    { return iEtudiantServices.asignDepToEt(idEt,idDep);}

    @PutMapping("/assignEq/{idEt}/{idEq}")
    public  Etudiant assignEtudToEqu(@PathVariable("idEt") Integer idEt, @PathVariable("idEq") Integer idEq)
    { return iEtudiantServices.assignEtToEq(idEt,idEq);}
}

package tn.esprit.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.services.IContratServices;

import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratRestController {

    IContratServices iContratServices;

    @Autowired
    public ContratRestController(IContratServices iContratServices) {
        this.iContratServices = iContratServices;
    }

    @GetMapping("/all")
    public List<Contrat> getAllContrats() {
        return iContratServices.retrieveAllContrats();
    }

    @PutMapping("/update")
    public Contrat updateContrat(@RequestBody Contrat c) {
        return iContratServices.updateContrat(c);
    }

    @PostMapping("/add")
    public Contrat addContrat(@RequestBody Contrat c) {
        return iContratServices.addContrat(c);
    }

    @GetMapping("get/{id}")
    public Contrat getContrat(@PathVariable("id") Integer idContrat)
    {
        return iContratServices.retrieveContrat(idContrat);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContrat(@PathVariable("id") Integer idContrat)
    {
        iContratServices.removeContrat(idContrat);
    }

    @PutMapping("assignEt/{idContrat}/{idEtudiant}")
    public Contrat assignEtudiant(@PathVariable("idContrat") Integer idContrat, @PathVariable("idEtudiant") Integer idEtudiant)
    {
       return iContratServices.assignEtu(idContrat,idEtudiant);
    }
}
package tn.esprit.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.services.IDepartementServices;

import java.util.List;

@RestController
@RequestMapping("/departement")
public class DepartementRestController {

    IDepartementServices iDepartementServices;

    @Autowired
    public DepartementRestController(IDepartementServices iDepartementServices) {
        this.iDepartementServices = iDepartementServices;
    }

    @GetMapping("/all")
    public List<Departement> getAllDepartement() {
        return iDepartementServices.retrieveAllDepartements();
    }

    @PutMapping("/update")
    public Departement updateDepartement(@RequestBody Departement d) {
        return iDepartementServices.updateDepartement(d);
    }

    @PostMapping("/add")
    public Departement addDepartement(@RequestBody Departement d) {
        return iDepartementServices.addDepartement(d);
    }

    @GetMapping("get/{id}")
    public Departement getDepartement(@PathVariable("id") Integer idDepartement)
    {
        return iDepartementServices.retrieveDepartement(idDepartement);
    }

}

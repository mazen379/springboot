package tn.esprit.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.services.IEquipeServices;

import java.util.List;

@RestController
@RequestMapping("/equipe")

public class EquipeRestController {
     IEquipeServices iEquipeServices;

    @Autowired
    public EquipeRestController(IEquipeServices iEquipeServices) {
        this.iEquipeServices = iEquipeServices;
    }

    @GetMapping("/all")
    public List<Equipe> getAllEquipe() {
        return iEquipeServices.retrieveAllEquipes();
    }

    @PutMapping("/update")
    public Equipe updateEquipe(@RequestBody Equipe e) {
        return iEquipeServices.updateEquipe(e);
    }

    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe e) {
        return iEquipeServices.addEquipe(e);
    }

    @GetMapping("get/{id}")
    public Equipe getEquipe(@PathVariable("id") Integer idEquipe)
    {
        return iEquipeServices.retrieveEquipe(idEquipe);
    }
}

package com.example.demo.controller;



import com.example.demo.model.Matiere;
import com.example.demo.model.User;
import com.example.demo.model.Role;
import com.example.demo.service.MatiereService;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/matieres")
public class MatiereController {

    @Autowired
    private MatiereService matiereService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Matiere> getAllMatieres() {
        return matiereService.getAllMatieres();
    }

    @GetMapping("/{id}")
    public Matiere getMatiereById(@PathVariable Long id) {
        return matiereService.getMatiereById(id);
    }

 
    @PostMapping
    public Matiere saveMatiere(@RequestBody Matiere matiere) {


        
        return matiereService.saveMatiere(matiere);
    }

    @DeleteMapping("/{id}")
    public void deleteMatiere(@PathVariable Long id) {
        matiereService.deleteMatiere(id);
    }
    @PutMapping("/{id}")
    public void updateMatiere(@PathVariable Long id,@RequestBody Matiere matiere) {
        matiereService.updateMatiere(id,matiere);
    }
}

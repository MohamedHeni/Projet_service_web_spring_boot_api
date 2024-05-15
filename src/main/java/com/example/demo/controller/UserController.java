package com.example.demo.controller;



import com.example.demo.model.User;
import com.example.demo.model.Matiere;
import com.example.demo.service.UserService;
import com.example.demo.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MatiereService matiereService;
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
//matieres
@GetMapping("/{id}/matieres")
public List<Matiere> getMatiereForUser(@PathVariable Long id) {
    User user=userService.getUserById(id);
    List<Matiere> matieres = user.getMatieres();
    return matieres ;
}

@PostMapping("/{id}/matieres")
public void saveMatiereForUser(@PathVariable Long id , @RequestBody Matiere matiere ) {
    User user=userService.getUserById(id);
    matiere.setUser(user);
    matiereService.saveMatiere(matiere);
    
}

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id,@RequestBody User user) {
        userService.updateUser(id,user);
    }
}

package com.example.demo.model;
import java.util.HashSet;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList; 
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
@Entity 
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public User(String name, String cin, Role role) {
        this.name = name;
        this.cin = cin;
        this.role = role;
        
    }
    public User() {
    }


    @Column(name="name",nullable=false )
    private String name;
    @Column(name="cin",nullable=false )
    private String cin ;
    @Column(name="role",nullable=false )
    private Role role;
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Matiere> matieres ;
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }
    public List<Matiere> getMatieres() {
        return matieres;
    }

    
    public String getName() {
        return name;
    }
    public String getCin() {
        return cin;
    }
    public Role getRole() {
        return role;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
    public void setRole(Role role) {
        this.role = role;
    }

}

package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity 
@Table(name="matiere")
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public Matiere(String name, String presence, String note1, String note2) {
        
        this.name = name;
        this.presence = presence;
        this.note1 = note1;
        this.note2 = note2;
   
    }
    public Matiere() {
    }


    @Column(name="name",nullable=false )
    private String name;
    @Column(name="presence",nullable=false )
    private String presence;
    @Column(name="note1",nullable=false )
    private String note1;
    @Column(name="note2",nullable=false )
    private String note2;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
    public String getName() {
        return name;
    }
    public String getPresence() {
        return presence;
    }
    public String getNote1() {
        return note1;
    }
    public String getNote2() {
        return note2;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPresence(String presence) {
        this.presence = presence;
    }
    public void setNote1(String note1) {
        this.note1 = note1;
    }
    public void setNote2(String note2) {
        this.note2 = note2;
    }
    public void setUser(User user) {
        this.user = user;
    }

  

}

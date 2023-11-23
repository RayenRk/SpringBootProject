package com.example.springbootproject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "cin")
    private int cin;
    @Column (name = "nom")
    private String nom;
    @Column (name = "prenom")
    private String prenom;
    @Column (name = "adresse")
    private String adresse;

    @JsonIgnore
    @OneToMany (mappedBy = "client")
    private List<Location> location = new ArrayList<Location>();
}

package com.example.springbootproject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Modele {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="libelle")
    private String libelle;

    @Column(name="pays")
    private String pays;

    @OneToMany (mappedBy = "modele")
    private List<Voiture> voiture = new ArrayList<Voiture>();
}

package com.example.springbootproject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Data
@Entity
public class Location {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "date_debut")
    private Date date_debut;
    @Column (name = "date_retour")
    private Date date_retour;
    @Column (name = "prix_jour")
    private int prix_jour;
    @Column (name = "prix")
    private int prix;

    @ManyToOne
    @JoinColumn (name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn (name = "voiture_id")
    private Voiture voiture;
}

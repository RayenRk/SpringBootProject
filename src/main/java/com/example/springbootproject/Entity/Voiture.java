package com.example.springbootproject.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Voiture {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "serie")
    private int serie;
    @Column (name = "date_mise_en_marche")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_mise_en_marche;

    @OneToMany (mappedBy = "voiture")
    private List<Location> location = new ArrayList<Location>();

    @ManyToOne
    @JoinColumn (name = "modele_id")
    private Modele modele;
}

package com.example.springbootproject.Services;

import com.example.springbootproject.Entity.Client;
import com.example.springbootproject.Entity.Voiture;

import java.util.List;

public interface VoitureService {

    Voiture getVoitureByNom(String nom);
    List<Voiture> getAllVoiture();
    Voiture createVoiture(Voiture voiture);
    Voiture getVoitureByID(Long id);
    Voiture updateVoiture(Voiture voiture);
    void  deleteVoiture(Long id);
}

package com.example.springbootproject.Services;

import com.example.springbootproject.Entity.Modele;

import java.util.List;

public interface ModeleService {
    List<Modele> getAllModele();
    Modele createModele(Modele modele);
    Modele getModeleByID(Long id);
    Modele updateModele(Modele modele);
    void  deleteModele(Long id);
}

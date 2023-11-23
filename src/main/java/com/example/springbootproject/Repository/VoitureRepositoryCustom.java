package com.example.springbootproject.Repository;

import com.example.springbootproject.Entity.Voiture;

public interface VoitureRepositoryCustom {

    Voiture listeVoitureByModel(String model);
}

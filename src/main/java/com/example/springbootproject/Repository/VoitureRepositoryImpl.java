package com.example.springbootproject.Repository;

import com.example.springbootproject.Entity.Voiture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

public class VoitureRepositoryImpl implements VoitureRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Voiture listeVoitureByModel (String model) {
        Query query = entityManager.createNamedQuery("SELECT v.* FROM Voiture v"+
                "WHERE v.model LIKE ?", Voiture.class);
        query.setParameter(1,model+"%");
        return (Voiture) query.getSingleResult();
    }
}

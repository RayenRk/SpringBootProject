package com.example.springbootproject.Repository;

import com.example.springbootproject.Entity.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

public class LocationRepositoryImpl implements LocationRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Location listeLocationByClient(String nom){
        Query query = entityManager.createNamedQuery("SELECT l.* FROM Location l"+
                "WHERE l.nom LIKE ?", Location.class);
        query.setParameter(1,nom+"%");
        return (Location) query.getSingleResult();
    }
}

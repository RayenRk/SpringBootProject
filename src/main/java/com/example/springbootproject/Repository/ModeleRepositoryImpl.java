package com.example.springbootproject.Repository;

import com.example.springbootproject.Entity.Modele;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

public class ModeleRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Modele getModeleByNom (String model) {
        Query query = entityManager.createNamedQuery("SELECT m.* FROM Modele m"+
                "WHERE m.model LIKE ?", Modele.class);
        query.setParameter(1,model+"%");
        return (Modele) query.getSingleResult();
    }
}

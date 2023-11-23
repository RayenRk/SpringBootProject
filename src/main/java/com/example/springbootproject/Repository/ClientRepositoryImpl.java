package com.example.springbootproject.Repository;

import com.example.springbootproject.Entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

public class ClientRepositoryImpl implements ClientRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Client getClientByNom (String nom) {
        Query query = entityManager.createNamedQuery("SELECT c.* FROM Client c"+
                "WHERE c.nom LIKE ?", Client.class);
        query.setParameter(1,nom+"%");
        return (Client) query.getSingleResult();
    }
}

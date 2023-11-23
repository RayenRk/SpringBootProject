package com.example.springbootproject.Repository;

import com.example.springbootproject.Entity.Client;

public interface ClientRepositoryCustom {

    Client getClientByNom (String nom);
}

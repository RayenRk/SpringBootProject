package com.example.springbootproject.Services;

import com.example.springbootproject.Entity.Client;

import java.util.List;

public interface ClientService {

    Client getClientByNom(String nom);
    List <Client> getAllClient();
    Client createClient(Client client);
    Client getClientByID(Long id);
    Client updateClient(Client client);
    void  deleteClient(Long id);
}

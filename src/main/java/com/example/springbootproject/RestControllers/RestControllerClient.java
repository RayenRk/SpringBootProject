package com.example.springbootproject.RestControllers;

import com.example.springbootproject.Entity.Client;
import com.example.springbootproject.Services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class RestControllerClient {
    @Autowired
    private ClientServiceImpl clientServiceImp;

    @PostMapping("/save")
    public Client saveClient(@RequestBody Client client) {
        return clientServiceImp.createClient(client);
    }


    @PostMapping("/save2")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        try {
            clientServiceImp.createClient(client);
            return new ResponseEntity<Client>(client, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allClients")
    public List<Client> getAllClients(){
        return clientServiceImp.getAllClient();
    }

    @GetMapping("/allClients2")
    public ResponseEntity<List<Client>> getAllClients2(){
        try {
            List<Client> clients = clientServiceImp.getAllClient();
            if(clients.isEmpty()){
                return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<List<Client>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOneClient/{id}")
    public Client getOneClient(@PathVariable Long id){
        return clientServiceImp.getClientByID(id);
    }

    @PutMapping("/updateClient/{id}")
    public Client updateClient(@PathVariable Long id,@RequestBody Client client){
        Client c1=clientServiceImp.getClientByID(id);
        if(c1!=null){
            client.setId(id);
            return clientServiceImp.updateClient(client);
        }
        else {
            throw new RuntimeException("Failed!");
        }
    }

    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") long id){
        try {
            clientServiceImp.deleteClient(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
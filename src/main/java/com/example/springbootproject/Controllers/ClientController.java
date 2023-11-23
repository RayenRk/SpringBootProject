package com.example.springbootproject.Controllers;

import com.example.springbootproject.Entity.Client;
import com.example.springbootproject.Services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientServiceImpl clientServiceImpl;


    @GetMapping("/all")
    public String listeClients(Model model) {
        List <Client> listClients = clientServiceImpl.getAllClient();
        model.addAttribute("listeClients", listClients);
        return "liste_clients";
    }

    @GetMapping("/addClient")
    public String addClient(Model model) {
        Client client = new Client();
        model.addAttribute("ClientForm", client);
        return "new_client";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("client") Client client) {
        clientServiceImpl.updateClient(client);
        return "redirect:/all";
    }


    @GetMapping("/editClient/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Client client = clientServiceImpl.getClientByID(id);
        model.addAttribute("client", client);
        return "update_client";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable("id") long id,  Client client, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            client.setId(id);
            return "update_client";
        }
        clientServiceImpl.createClient(client);
        return "redirect:/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") long id) {

        clientServiceImpl.deleteClient(id);
        return "redirect:/all";

    }




    //@GetMapping("/getone/{nom}")
    //public Client getoneclient(@PathVariable("nom") String nom) {
    //    return clientServiceImpl.getClientByNom(nom);
    //}

    //@GetMapping("/all")
    //public List<Client> getallclient() {
    //    return clientServiceImpl.getAllClient();
    //}

    /*@PostMapping("/update/{id}")
    public String updateClient(@PathVariable("id") long id, @RequestBody Client client) {
        Client c1 = clientServiceImpl.getClientByID(id);

        if (c1 != null) {
            client.setId(id);
            clientServiceImpl.updateClient(client);
            return "Updated !";
        } else {
            throw new RuntimeException("Update Failed !");
        }
    }*/
}


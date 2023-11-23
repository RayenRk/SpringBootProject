package com.example.springbootproject.Controllers;

import com.example.springbootproject.Entity.Client;
import com.example.springbootproject.Entity.Modele;
import com.example.springbootproject.Entity.Location;
import com.example.springbootproject.Entity.Voiture;
import com.example.springbootproject.Services.ClientServiceImpl;
import com.example.springbootproject.Services.ModeleServiceImpl;
import com.example.springbootproject.Services.LocationServiceImpl;
import com.example.springbootproject.Services.VoitureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocationController {
    @Autowired
    private LocationServiceImpl locationServiceImpl;
    @Autowired
    private ClientServiceImpl client;
    @Autowired
    private VoitureServiceImpl voiture;

    @GetMapping("/allLocations")
    public String listeLocations(Model model) {
        List<Location> listLocations = locationServiceImpl.getAllLocation();
        model.addAttribute("listeLocations", listLocations);
        return "liste_locations";
    }

    @GetMapping("/addLocation")
    public String addLocation(Model model) {
        Location location = new Location();
        List<Client> listeClient= client.getAllClient();
        List<Voiture> listeVoiture= voiture.getAllVoiture();
        model.addAttribute("LocationForm", location);
        model.addAttribute("listClient", listeClient);
        model.addAttribute("listVoiture", listeVoiture);

        return "new_location";
    }

    @RequestMapping(value = "/saveLocation", method = RequestMethod.POST)
    public String saveLocation(@ModelAttribute("location") Location location) {
        locationServiceImpl.updateLocation(location);
        return "redirect:/allLocations";
    }

    @GetMapping("/editLocation/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Location location = locationServiceImpl.getLocationByID(id);
        List<Client> listeClient = client.getAllClient();
        List<Voiture> listeVoiture = voiture.getAllVoiture();

        model.addAttribute("location", location);
        model.addAttribute("listClient", listeClient);
        model.addAttribute("listVoiture", listeVoiture);

        return "update_location";
    }

    @PostMapping("/updateLocation/{id}")
    public String updateLocation(@PathVariable("id") long id, Location location, BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            location.setId(id);
            return "update_location";
        }
        locationServiceImpl.createLocation(location);
        return "redirect:/allLocations";
    }

    @GetMapping("/deleteLocation/{id}")
    public String deleteLocation(@PathVariable("id") long id) {
        locationServiceImpl.deleteLocation(id);
        return "redirect:/allLocations";
    }
}
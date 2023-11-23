package com.example.springbootproject.Controllers;

import com.example.springbootproject.Entity.Location;
import com.example.springbootproject.Services.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocationController {
    @Autowired
    private LocationServiceImpl locationServiceImpl;

    //@GetMapping("/getone/{nom}")
    //public Location getonelocation(@PathVariable("Nom") String nom) {
    //    return locationServiceImpl.getLocationByNom(nom); // Changed "getVoitureByNom" to "getLocationByNom"
    //}

    @GetMapping("/allLocation")
    public List<Location> getalllocation() {
        return locationServiceImpl.getAllLocation();
    }

    @PostMapping("/updatelocation/{id}")
    public String updateLocation(@PathVariable("id") long id, @RequestBody Location location) {
        Location l1 = locationServiceImpl.getLocationByID(id);

        if (l1 != null) {
            location.setId(id);
            locationServiceImpl.updateLocation(location);
            return "Updated !";
        } else {
            throw new RuntimeException("Update Failed !");
        }
    }

    @RequestMapping(value = "/saveLocation", method = RequestMethod.POST)
    public String saveLocation(@ModelAttribute("location") Location location) {
        locationServiceImpl.createLocation(location);
        return "redirect:/";
    }

    @GetMapping("deleteLocation{id}")
    public void deleteLocation(@PathVariable("id") long id) {
        locationServiceImpl.deleteLocation(id);
    }
}


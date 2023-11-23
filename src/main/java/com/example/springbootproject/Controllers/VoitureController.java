package com.example.springbootproject.Controllers;

import com.example.springbootproject.Entity.Modele;
import com.example.springbootproject.Entity.Voiture;
import com.example.springbootproject.Services.ModeleServiceImpl;
import com.example.springbootproject.Services.VoitureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VoitureController {
    @Autowired
    private VoitureServiceImpl voitureServiceImpl;
    @Autowired
    private ModeleServiceImpl modele;

    @GetMapping("/allVoitures")
    public String listeVoitures(Model model) {
        List <Voiture> listVoitures = voitureServiceImpl.getAllVoiture();
        model.addAttribute("listeVoitures", listVoitures);
        return "liste_voitures";
    }

    @GetMapping("/addVoiture")
    public String addVoiture(Model model) {
        Voiture voiture = new Voiture();
        List<Modele> listeModele= modele.getAllModele();
        model.addAttribute("VoitureForm", voiture);
        model.addAttribute("listModele", listeModele);
        return "new_voiture";
    }

    @RequestMapping(value = "/saveVoiture", method = RequestMethod.POST)
    public String saveVoiture(@ModelAttribute("voiture") Voiture voiture) {
        voitureServiceImpl.updateVoiture(voiture);
        return "redirect:/allVoitures";
    }

    @GetMapping("/editVoiture/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Voiture voiture = voitureServiceImpl.getVoitureByID(id);
        List<Modele> listeModele= modele.getAllModele();

        model.addAttribute("listModele", listeModele);
        model.addAttribute("voiture", voiture);
        return "update_voiture";
    }

    @PostMapping("/updateVoiture/{id}")
    public String updateVoiture(@PathVariable("id") long id, Voiture voiture, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            voiture.setId(id);
            return "update_voiture";
        }
        voitureServiceImpl.createVoiture(voiture);
        return "redirect:/allVoitures";
    }

    @GetMapping("/deleteVoiture/{id}")
    public String deleteVoiture(@PathVariable("id") long id) {
        voitureServiceImpl.deleteVoiture(id);
        return "redirect:/allVoitures";
    }
}
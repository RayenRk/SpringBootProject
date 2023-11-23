package com.example.springbootproject.Controllers;

import com.example.springbootproject.Entity.Modele;
import com.example.springbootproject.Services.ModeleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ModeleController {
    @Autowired
    private ModeleServiceImpl modeleServiceImpl;

    @GetMapping("/allModeles")
    public String listeModeles(Model model) {
        List <Modele> listModeles = modeleServiceImpl.getAllModele();
        model.addAttribute("listeModeles", listModeles);
        return "liste_modeles";
    }

    @GetMapping("/addModele")
    public String addModele(Model model) {
        Modele modele = new Modele();
        model.addAttribute("ModeleForm", modele);
        return "new_modele";
    }

    @RequestMapping(value = "/saveModele", method = RequestMethod.POST)
    public String saveModele(@ModelAttribute("modele") Modele modele) {
        modeleServiceImpl.updateModele(modele);
        return "redirect:/allModeles";
    }

    @GetMapping("/editModele/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Modele modele = modeleServiceImpl.getModeleByID(id);
        model.addAttribute("modele", modele);
        return "update_modele";
    }

    @PostMapping("/updateModele/{id}")
    public String updateModele(@PathVariable("id") long id,  Modele modele, BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            modele.setId(id);
            return "update_modele";
        }
        modeleServiceImpl.createModele(modele);
        return "redirect:/allModeles";
    }

    @GetMapping("/deleteModele/{id}")
    public String deleteModele(@PathVariable("id") long id) {
        modeleServiceImpl.deleteModele(id);
        return "redirect:/allModeles";
    }
}
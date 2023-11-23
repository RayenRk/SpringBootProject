package com.example.springbootproject.RestControllers;

import com.example.springbootproject.Entity.Modele;
import com.example.springbootproject.Services.ModeleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modele")
public class RestControllerModele {
    @Autowired
    private ModeleServiceImpl modeleServiceImp;

    @PostMapping("/save")
    public Modele saveModele(@RequestBody Modele modele) {
        return modeleServiceImp.createModele(modele);
    }

    @PostMapping("/save2")
    public ResponseEntity<Modele> createModele(@RequestBody Modele modele) {
        try {
            modeleServiceImp.createModele(modele);
            return new ResponseEntity<>(modele, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allModeles")
    public List<Modele> getAllModeles() {
        return modeleServiceImp.getAllModele();
    }

    @GetMapping("/allModeles2")
    public ResponseEntity<List<Modele>> getAllModeles2() {
        try {
            List<Modele> modeles = modeleServiceImp.getAllModele();
            if (modeles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(modeles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOneModele/{id}")
    public Modele getOneModele(@PathVariable Long id) {
        return modeleServiceImp.getModeleByID(id);
    }

    @PutMapping("/updateModele/{id}")
    public Modele updateModele(@PathVariable Long id, @RequestBody Modele modele) {
        Modele m1 = modeleServiceImp.getModeleByID(id);
        if (m1 != null) {
            modele.setId(id);
            return modeleServiceImp.updateModele(modele);
        } else {
            throw new RuntimeException("Failed!");
        }
    }

    @DeleteMapping("/deleteModele/{id}")
    public ResponseEntity<HttpStatus> deleteModele(@PathVariable("id") long id) {
        try {
            modeleServiceImp.deleteModele(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

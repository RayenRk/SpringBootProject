package com.example.springbootproject.RestControllers;

import com.example.springbootproject.Entity.Voiture;
import com.example.springbootproject.Services.VoitureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voiture")
public class RestControllerVoiture {
    @Autowired
    private VoitureServiceImpl voitureServiceImp;

    @PostMapping("/save")
    public Voiture saveVoiture(@RequestBody Voiture voiture) {
        return voitureServiceImp.createVoiture(voiture);
    }


    @PostMapping("/save2")
    public ResponseEntity<Voiture> createVoiture(@RequestBody Voiture voiture) {
        try {
            voitureServiceImp.createVoiture(voiture);
            return new ResponseEntity<Voiture>(voiture, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Voiture>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allVoitures")
    public List<Voiture> getAllVoitures(){
        return voitureServiceImp.getAllVoiture();
    }

    @GetMapping("/allVoitures2")
    public ResponseEntity<List<Voiture>> getAllVoitures2(){
        try {
            List<Voiture> voitures = voitureServiceImp.getAllVoiture();
            if(voitures.isEmpty()){
                return new ResponseEntity<List<Voiture>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Voiture>>(voitures, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<List<Voiture>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOneVoiture/{id}")
    public Voiture getOneVoiture(@PathVariable Long id){
        return voitureServiceImp.getVoitureByID(id);
    }

    @PutMapping("/updateVoiture/{id}")
    public Voiture updateVoiture(@PathVariable Long id,@RequestBody Voiture voiture){
        Voiture v1=voitureServiceImp.getVoitureByID(id);
        if(v1!=null){
            voiture.setId(id);
            return voitureServiceImp.updateVoiture(voiture);
        }
        else {
            throw new RuntimeException("Failed!");
        }
    }

    @DeleteMapping("/deleteVoiture/{id}")
    public ResponseEntity<HttpStatus> deleteVoiture(@PathVariable("id") long id){
        try {
            voitureServiceImp.deleteVoiture(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

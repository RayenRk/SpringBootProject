package com.example.springbootproject.Services;

import com.example.springbootproject.Entity.Modele;
import com.example.springbootproject.Repository.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ModeleServiceImpl implements ModeleService {

    @Autowired
    private ModeleRepository modeleRepository;

    @Override
    public List<Modele> getAllModele() {
        return modeleRepository.findAll();
    }

    @Override
    public Modele createModele(Modele modele) {
        return modeleRepository.save(modele);
    }

    @Override
    public Modele getModeleByID(Long id) {
        return modeleRepository.findById(id).get();
    }

    @Override
    public Modele updateModele(Modele modele) {
        return modeleRepository.saveAndFlush(modele);
    }

    @Override
    public void deleteModele(Long id) {
        modeleRepository.deleteById(id);
    }
}

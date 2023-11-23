package com.example.springbootproject.Services;

import com.example.springbootproject.Entity.Voiture;
import com.example.springbootproject.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureServiceImpl implements VoitureService{

    @Autowired
    private VoitureRepository voitureRepository;

    @Override
    public Voiture getVoitureByNom(String nom) {
        return voitureRepository.listeVoitureByModel (nom);
    }

    @Override
    public List<Voiture> getAllVoiture() {
        return voitureRepository.findAll();
    }

    @Override
    public Voiture createVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    @Override
    public Voiture getVoitureByID(Long id) {
        return voitureRepository.findById(id).get();
    }

    @Override
    public Voiture updateVoiture(Voiture voiture) {
        return voitureRepository.saveAndFlush(voiture);
    }

    @Override
    public void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
    }
}

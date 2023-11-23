package com.example.springbootproject.Repository;

import com.example.springbootproject.Entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, Long>, VoitureRepositoryCustom {
}

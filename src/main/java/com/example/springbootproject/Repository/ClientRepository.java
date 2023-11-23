package com.example.springbootproject.Repository;

import com.example.springbootproject.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>, ClientRepositoryCustom {

}

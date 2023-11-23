package com.example.springbootproject.Repository;

import com.example.springbootproject.Entity.Location;

public interface LocationRepositoryCustom {

    Location listeLocationByClient (String nom);
}

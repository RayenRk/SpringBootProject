package com.example.springbootproject.Services;

import com.example.springbootproject.Entity.Location;
import java.util.List;

public interface LocationService {
    List<Location> getAllLocation();
    Location createLocation(Location location);
    Location getLocationByID(Long id);
    Location updateLocation(Location location);
    void  deleteLocation(Long id);
}

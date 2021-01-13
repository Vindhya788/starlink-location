package com.satelliteconstellation.location.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.satelliteconstellation.location.entity.Location;
import com.satelliteconstellation.location.repository.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
    LocationRepository LocationRepository;
	
    public void saveLocation(Location Location) {
        LocationRepository.save(Location);
    }
    
    public Iterable<Location> getLocationHistory() {
        return LocationRepository.findAll();
    }
    
    public Optional<Location> getLocation(Long id) {
        return LocationRepository.findById(id);
    }

    public String deleteLocation(Long id) {
        LocationRepository.deleteById(id);
        return "Satellite Location removed !! " + id;
    }
    
    public Location updateLocation(Location location) {
        Location existingLocation = LocationRepository.findById(location.getSatelliteId()).orElse(null);
        existingLocation.setSatelliteLocation(location.getSatelliteLocation());
        existingLocation.setDateInLocation(location.getDateInLocation());
        return LocationRepository.save(existingLocation);

    }

}

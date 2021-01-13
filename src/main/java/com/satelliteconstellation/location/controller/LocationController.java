package com.satelliteconstellation.location.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satelliteconstellation.location.entity.Location;
import com.satelliteconstellation.location.exceptions.InvalidLocationReferenceException;
import com.satelliteconstellation.location.service.LocationService;



@RestController
@RequestMapping("/location")
public class LocationController {
	
	
	
	@Autowired
    LocationService locationService;

    @PostMapping("/create")
    public Long createLocation(@RequestBody Location location) {
    	locationService.saveLocation(location);
        return location.getSatelliteId();
    }

    @GetMapping("/viewAll")
    public Iterable<Location> viewAllLocations() {
        return locationService.getLocationHistory();
    }

    @GetMapping("/view/{id}")
    public Location viewSatelliteById(@PathVariable ("id") Long id) {
        Optional<Location> location = locationService.getLocation(id);
        if(location.isPresent()) {
            return location.get();
        }

        throw new InvalidLocationReferenceException("Invalid Satellite reference provided");
    }

    @PutMapping("/update")
    public Long updateLocation(@RequestBody Location location) {
    	locationService.updateLocation(location);
        return location.getSatelliteId();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLocation(@PathVariable ("id") long id) {
        Optional<Location> location = locationService.getLocation(id);
        if(location.isPresent()) {
            return locationService.deleteLocation(id);
        }

        throw new InvalidLocationReferenceException("Invalid Satellite reference provided");
    }

}

package com.satelliteconstellation.location.entity;

import javax.persistence.Entity;

//import javax.persistence.Entity;
//import javax.persistence.Id;

//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.annotation.Id;
import javax.persistence.Id;
import javax.persistence.Table;
//@Document(collection = "location")

@Entity
@Table(name="location", catalog="location")
public class Location {
	
	@Id
	private long satelliteId;
    private String satelliteLocation;
    private String dateInLocation;
    
    public long getSatelliteId() {
        return satelliteId;
    }
    public void setSatelliteId(long satelliteId) {
        this.satelliteId = satelliteId;
    }
    public String getSatelliteLocation() {
        return satelliteLocation;
    }
    public void setSatelliteLocation(String satelliteLocation) {
        this.satelliteLocation = satelliteLocation;
    }
    public String getDateInLocation() {
        return dateInLocation;
    }
    public void setDateInLocation(String dateInLocation) {
        this.dateInLocation = dateInLocation;
    }
    

}

package com.satelliteconstellation.location.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.satelliteconstellation.location.entity.Location;


@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{

}


package edu.codigocode.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.codigocode.entities.Activity;

public interface ActivityRepository  extends CrudRepository<Activity, Integer> {

}

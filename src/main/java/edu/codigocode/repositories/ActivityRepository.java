package edu.codigocode.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.codigocode.entities.Activity;
import edu.codigocode.entities.Student;

public interface ActivityRepository  extends CrudRepository<Activity, Integer> {

	  List<Activity> findById(int id);

	
}

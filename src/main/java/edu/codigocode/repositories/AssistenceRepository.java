package edu.codigocode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.codigocode.entities.Assistence;

 @Repository
public interface AssistenceRepository extends CrudRepository <Assistence, Integer>{
	

@Query("SELECT i FROM Assistence i WHERE i.alumno.id = :id")
	List<Assistence> getAssistences(int id);
}

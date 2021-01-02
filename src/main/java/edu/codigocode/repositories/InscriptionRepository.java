package edu.codigocode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.codigocode.entities.Inscription;

@Repository
public interface InscriptionRepository extends CrudRepository <Inscription, Integer>{

@Query("SELECT i FROM Inscription i WHERE i.alumno.id = :id")
	List<Inscription> getInscriptions(int id);


}

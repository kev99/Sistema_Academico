package edu.codigocode.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.codigocode.entities.Activity;
import edu.codigocode.entities.Inscription;

@Repository
public interface InscriptionRepository extends CrudRepository <Inscription, Integer>{

@Query("SELECT i FROM Inscription i WHERE i.alumno.id = :id")
	List<Inscription> getInscriptions(int id);


}

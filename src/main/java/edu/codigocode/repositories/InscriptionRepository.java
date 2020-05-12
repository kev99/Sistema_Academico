package edu.codigocode.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.codigocode.entities.Inscription;

public interface InscriptionRepository extends CrudRepository<Inscription, Integer>{

//	List<Inscription> findById_alum(int id);

}

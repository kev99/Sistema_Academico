package edu.codigocode.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.codigocode.entities.User;

@Repository
public interface UsuarioRepository extends CrudRepository<User, Integer> {

	
	
}

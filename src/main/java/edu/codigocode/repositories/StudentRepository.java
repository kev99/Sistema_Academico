package edu.codigocode.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.codigocode.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	  List<Student> findByDni(int dni);

	
}

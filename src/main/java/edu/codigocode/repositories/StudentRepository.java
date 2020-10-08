package edu.codigocode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.codigocode.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	  List<Student> findByDni(int dni);

}

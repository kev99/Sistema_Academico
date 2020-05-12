package edu.codigocode.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import edu.codigocode.entities.Pay;

public interface PayRepository extends CrudRepository<Pay, Integer>{

	List<Pay> findByAlumno_id(int alumno_id);
	// List<Pay> findByFecha_pago(Date fecha_pago);
	


	
}

package edu.codigocode.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.codigocode.entities.Inscription;
import edu.codigocode.entities.Student;
import edu.codigocode.repositories.InscriptionRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class InscriptionController {
	
	
	@Autowired
	private InscriptionRepository insrepository;
	
	@GetMapping("/inscription")
	 public List<Inscription> getAllInscriptions() {
	   System.out.println("Obteniendo incripciones");

	   List<Inscription> inscription = new ArrayList<>();
	   insrepository.findAll().forEach(inscription::add);

	   return inscription;
	 }

	 @PostMapping(value = "/inscription/create")
	 public Inscription postInscription(@RequestBody Inscription inscription) {

		 Inscription _inscription = insrepository.save(new Inscription(inscription.getAlumno(), inscription.getActividad(),inscription.getFecha_ins()));
	   return _inscription;
	 }

	 @DeleteMapping("/inscription/{id}")
	 public ResponseEntity<String> deleteInscription(@PathVariable("id") int id) {
	   System.out.println("Borrando inscripcion con id = " + id + "...");

	   insrepository.deleteById(id);

	   return new ResponseEntity<>("La inscripcion fue eliminada", HttpStatus.OK);
	 }

//	 @GetMapping(value = "inscription/id/{id_alum}")
//	 public List<Inscription> findByDni(@PathVariable int id ) {
//
//	   List<Inscription> inscription = insrepository.findById_alum(id);
//	   return inscription;
//	 } 

}

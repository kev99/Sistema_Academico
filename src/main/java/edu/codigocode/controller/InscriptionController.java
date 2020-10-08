package edu.codigocode.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.codigocode.entities.Inscription;
import edu.codigocode.entities.Student;
import edu.codigocode.repositories.InscriptionRepository;
import edu.codigocode.repositories.StudentRepository;
import edu.codigocode.services.InscriptionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class InscriptionController {
	
	@Autowired
	private InscriptionService insservice;
	
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
	 public ResponseEntity<Inscription> postInscription(@RequestBody Inscription inscription) {

		 
	   return new ResponseEntity<Inscription>(insservice.saveInscription(inscription), HttpStatus.CREATED);
	 }

	 @DeleteMapping("/inscription/{id}")
	 public ResponseEntity<String> deleteInscription(@PathVariable("id") int id) {
	   System.out.println("Borrando inscripcion con id = " + id + "...");

	   insrepository.deleteById(id);

	   return new ResponseEntity<>("La inscripcion fue eliminada", HttpStatus.OK);
	 }

	 @GetMapping(value = "inscription/id/{id}")
	 public List<Inscription> getInscriptions(@PathVariable int id ) {

	   List<Inscription> inscription = insrepository.getInscriptions(id);
	   System.out.println("Inscripcion = " + inscription + "...");

	   return inscription;
	 } 

//
//	 @RequestMapping(value = "inscription/id/{id_alum}")
//	 public List<Inscription> findByDni(@RequestParam(value = "params", required = false)  int id  ) {
//
//   List<Inscription> inscription = insrepository.getInscriptionById_Alum(id);
//   return inscription;
// } 
//	 
}

package edu.codigocode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.codigocode.entities.Assistence;
  
import edu.codigocode.repositories.AssistenceRepository;
import edu.codigocode.services.AssistenceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AssistenceController {

	@Autowired
	private AssistenceRepository asisrepo;
	
	@Autowired
	private AssistenceService asisservice;
	
	@GetMapping("/assistence")
	 public List<Assistence> getAllAssistens() {
	   System.out.println("Obteniendo las asistencias");

	   List<Assistence> assistence = new ArrayList<>();
	   asisrepo.findAll().forEach(assistence::add);

	   return assistence;
	 }
	
	 @PostMapping(value = "/assistence/create")
	 public ResponseEntity<Assistence> postAssistence(@RequestBody Assistence assistence) {
		 System.out.println(assistence);
	   return new ResponseEntity<Assistence>(asisservice.saveAssistence(assistence), HttpStatus.CREATED);
	 }
	
	 
	 @DeleteMapping("/assistence/{id}")
	 public ResponseEntity<String> deleteAssistence(@PathVariable("id") int id) {
	   System.out.println("Borrando asistencia  con id = " + id + "...");
         
	   asisrepo.deleteById(id);

	   return new ResponseEntity<>("La asistencia fue eliminada", HttpStatus.OK);
	 }

	 @GetMapping(value = "assistence/id/{id}")
	 public List<Assistence> getAssistences(@PathVariable int id ) {

	   List<Assistence> assistence = asisrepo.getAssistences(id);
	   System.out.println("Assistences = " + assistence + "...");

	   return assistence;
	 } 
	
}

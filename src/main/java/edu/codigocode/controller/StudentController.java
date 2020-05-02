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

import edu.codigocode.entities.Student;
import edu.codigocode.modelo.Respuesta;
import edu.codigocode.repositories.StudentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	 StudentRepository repository;

	@Autowired
	private	Respuesta<Student> respuesta;
	
	 @GetMapping("/student")
	 public List<Student> getAllCustomers() {
	   System.out.println("Get all student...");

	   List<Student> student = new ArrayList<>();
	   repository.findAll().forEach(student::add);

	   return student;
	 }

	 @PostMapping(value = "/student/create")
	 public Student postCustomer(@RequestBody Student student) {

		 Student _student = repository.save(new Student(student.getNombre(),student.getApellido(), student.getDni() ,student.getFecha_nacimiento()
				 , student.getMail() , student.getObra_social() , student.getCert_medico() , student.getNum_socio()));
	   return _student;
	 }

	 @DeleteMapping("/student/{id}")
	 public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id) {
	   System.out.println("Delete student with ID = " + id + "...");

	   repository.deleteById(id);

	   return new ResponseEntity<>("Student has been deleted!", HttpStatus.OK);
	 }

	 @DeleteMapping("/student/delete")
	 public ResponseEntity<String> deleteAllCustomers() {
	   System.out.println("Delete All customers...");

	   repository.deleteAll();

	   return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
	 }

	 @GetMapping(value = "student/id/{dni}")
	 public List<Student> findByDni(@PathVariable int dni) {

	   List<Student> student = repository.findByDni(dni);
	   return student;
	 }

	 @PutMapping("/student/{id}")
	 public ResponseEntity<Student> updateCustomer(@PathVariable("id") int id, @RequestBody Student student) {
	   System.out.println("Update Student with ID = " + id + "...");

	   Optional<Student> studentData = repository.findById(id);

	   if (studentData.isPresent()) {
		   Student _student = studentData.get();
	     _student.setNombre(student.getNombre());
	     _student.setApellido(student.getApellido());
	     _student.setDni(student.getDni());
	     _student.setFecha_nacimiento(student.getFecha_nacimiento());
	     _student.setMail(student.getMail());
	     _student.setObra_social(student.getObra_social());
	     _student.setCert_medico(student.getCert_medico());
	     _student.setNum_socio(student.getNum_socio());
	     _student.setEstado_cuota(student.isEstado_cuota());
	     return new ResponseEntity<>(repository.save(_student), HttpStatus.OK);
	   } else {
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
}

	 
	 
	

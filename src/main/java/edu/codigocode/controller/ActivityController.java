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

import edu.codigocode.entities.Activity;
import edu.codigocode.entities.Student;
import edu.codigocode.repositories.ActivityRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ActivityController {

	@Autowired
	private ActivityRepository actrepo;
	
	
	 @GetMapping("/activity")
	 public List<Activity> getAllActivities() {
	   System.out.println("Obteniendo las activiaes");

	   List<Activity> activity = new ArrayList<>();
	   actrepo.findAll().forEach(activity::add);

	   return activity;
	 }

	 @PostMapping(value = "/activity/create")
	 public Activity postActivity(@RequestBody Activity activity) {

		 Activity _activity = actrepo.save(new Activity(activity.getNivel(),activity.getCategoria(),activity.getEdad(),activity.getDias_practica(),
				 activity.getValor()));
		 System.out.println(_activity);
	   return _activity;
	 }

	 @DeleteMapping("/activity/{id}")
	 public ResponseEntity<String> deleteActivity(@PathVariable("id") int id) {
	   System.out.println("Eliminando activity con id = " + id + "...");

	   actrepo.deleteById(id);

	   return new ResponseEntity<>("La activity se elimino", HttpStatus.OK);
	 }

	//	 @PutMapping("/activity/{id}")
//	 public ResponseEntity<Activity> updateActivity(@PathVariable("id") int id, @RequestBody Activity activity) {
//	   System.out.println("Update Student with ID = " + id + "...");
//
//	   Optional<Activity> activityData = actrepo.findById(id);
//
//	   if (activityData.isPresent()) {
//		   Student _student = studentData.get();
//	     _student.setNombre(student.getNombre());
//	     _student.setApellido(student.getApellido());
//	     _student.setDni(student.getDni());
//	     _student.setFecha_nacimiento(student.getFecha_nacimiento());
//	     _student.setMail(student.getMail());
//	     _student.setObra_social(student.getObra_social());
//	     _student.setCert_medico(student.getCert_medico());
//	     _student.setNum_socio(student.getNum_socio());
//	     _student.setEstado_cuota(student.isEstado_cuota());
//	     return new ResponseEntity<>(actrepo.save(_student), HttpStatus.OK);
//	   } else {
//	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	   }
	 
}
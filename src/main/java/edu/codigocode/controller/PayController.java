package edu.codigocode.controller;

import java.util.ArrayList;
import java.util.Date;
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

import edu.codigocode.entities.Pay;
import edu.codigocode.entities.Student;
import edu.codigocode.repositories.PayRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PayController {

	@Autowired
	PayRepository payrepository;
	
	 @GetMapping("/pay")
	 public List<Pay> getAllPays() {
	   System.out.println("Obteniendo pagos");

	   List<Pay> pay = new ArrayList<>();
	   payrepository.findAll().forEach(pay::add);

	   return pay;
	 }

	 @PostMapping(value = "/pay/create")
	 public Pay postPay(@RequestBody Pay pay) {

		 Pay _pay = payrepository.save(new Pay(pay.getTotal(), pay.getFecha_pago(),pay.getAlumno(), pay.getActividad()));
	   return _pay;
	 }

	 @DeleteMapping("/pay/{id}")
	 public ResponseEntity<String> deletePay(@PathVariable("id") int id) {
	   System.out.println("Borrando pago con id = " + id + "...");

	   payrepository.deleteById(id);

	   return new ResponseEntity<>("El pago fue eliminado!", HttpStatus.OK);
	 }

	 @DeleteMapping("/pay/delete")
	 public ResponseEntity<String> deleteAllPays() {
	   System.out.println("Eliminando todos los pagos");

	   payrepository.deleteAll();

	   return new ResponseEntity<>("Todos los pagos fueron eliminados", HttpStatus.OK);
	 }

//	 @GetMapping(value = "pay/id/{fecha_pago}")
//	 public List<Pay> findByFecha_pago(@PathVariable Date fecha_pago) {
//
//	   List<Pay> pay = payrepository.findByFecha_pago(fecha_pago);
//	   return pay;
//	 }
	 
	 @GetMapping(value = "pay/id/{alumno_id}")
	 public List<Pay> findByAlumno_id(@PathVariable int alumno_id) {

	   List<Pay> pay = payrepository.findByAlumno_id(alumno_id);
	   return pay;
	 }
	 

	 @PutMapping("/pay/{id}")
	 public ResponseEntity<Pay> updatePay(@PathVariable("id") int id, @RequestBody Pay pay) {
	   System.out.println("Update Pay with ID = " + id + "...");

	   Optional<Pay> payData = payrepository.findById(id);

	   if (payData.isPresent()) {
		   Pay _pay = payData.get();
	     _pay.setTotal(pay.getTotal());
	     _pay.setFecha_pago(pay.getFecha_pago());
	     _pay.setAlumno(pay.getAlumno());
	  
	     return new ResponseEntity<>(payrepository.save(_pay), HttpStatus.OK);
	   } else {
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
}
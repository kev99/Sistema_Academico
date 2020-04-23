package edu.codigocode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	
	@GetMapping(value="/saludar")
	public String saludo() {
		
		return "hola ese es un capo vamos kev";
	}
}

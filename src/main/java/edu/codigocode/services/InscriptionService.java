package edu.codigocode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.codigocode.entities.Inscription;
import edu.codigocode.repositories.InscriptionRepository;

@Service
public class InscriptionService {

	@Autowired
	private InscriptionRepository insrepo ;
	
	
	public Inscription saveInscription (Inscription inscription) {
		
		return insrepo.save(inscription);
	}
	
	
	
}

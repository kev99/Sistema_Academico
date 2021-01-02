package edu.codigocode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.codigocode.entities.Assistence;
import edu.codigocode.repositories.AssistenceRepository;

@Service
public class AssistenceService {
	
	@Autowired
	private AssistenceRepository asisrepo;


	public Assistence saveAssistence (Assistence assistence) {
		
		return asisrepo.save(assistence);
	}
	
	
}

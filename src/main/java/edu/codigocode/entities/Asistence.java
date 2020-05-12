package edu.codigocode.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "asistencia")
public class Asistence {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id_asistencia ;
	
		@Column(name = "fecha_asistencia")
		private Date fecha_asistencia ;
		

		 @ManyToOne(fetch = FetchType.EAGER)
		 @JoinColumn(name = "alumnoid")
	     private Student alumno;
		 
		 @ManyToOne(fetch = FetchType.EAGER)
		 @JoinColumn(name = "actividadid")
	     private Activity actividad;
		
		
		

}

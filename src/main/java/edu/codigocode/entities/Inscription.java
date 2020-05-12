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
@Table(name = "inscripcion")
public class Inscription {

	  
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	  private int id;
	
	   
	  @ManyToOne(fetch = FetchType.EAGER)
		 @JoinColumn(name = "id_alum")
	     private Student alumno;
	  
	  @ManyToOne(fetch = FetchType.EAGER)
		 @JoinColumn(name = "id_act")
	     private Activity actividad;
	  
		@Column(name = "fecha_ins")
		private Date fecha_ins ;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Student getAlumno() {
			return alumno;
		}

		public void setAlumno(Student alumno) {
			this.alumno = alumno;
		}

		public Activity getActividad() {
			return actividad;
		}

		public void setActividad(Activity actividad) {
			this.actividad = actividad;
		}

		public Date getFecha_ins() {
			return fecha_ins;
		}

		public void setFecha_ins(Date fecha_ins) {
			this.fecha_ins = fecha_ins;
		}

		public Inscription(int id, Student alumno, Activity actividad, Date fecha_ins) {
			super();
			this.id = id;
			this.alumno = alumno;
			this.actividad = actividad;
			this.fecha_ins = fecha_ins;
		}

		public Inscription() {
			super();
		}

		public Inscription(Student alumno, Activity actividad) {
			super();
			this.alumno = alumno;
			this.actividad = actividad;
		}

		public Inscription(Student alumno, Activity actividad, Date fecha_ins) {
			super();
			this.alumno = alumno;
			this.actividad = actividad;
			this.fecha_ins = fecha_ins;
		}

		
}

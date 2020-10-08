package edu.codigocode.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "inscripcion")
public class Inscription {

	  
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	
	  
	  @ManyToOne
		 @JoinColumn(name = "id_alum")
	     private Student alumno;
	  
	  
	  @ManyToOne
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
		
		
		

		public Inscription(Student alumno, Date fecha_ins) {
			super();
			this.alumno = alumno;
			this.fecha_ins = fecha_ins;
		}

	

		public Inscription(Activity actividad, Date fecha_ins) {
			super();
			this.actividad = actividad;
			this.fecha_ins = fecha_ins;
		}

		@Override
		public String toString() {
			return "Inscription [id=" + id + ", alumno=" + alumno + ", actividad=" + actividad + ", fecha_ins="
					+ fecha_ins + "]";
		}
		

		
}

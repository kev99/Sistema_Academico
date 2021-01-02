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
public class Assistence {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_asistencia ;
	
		 @ManyToOne
		 @JoinColumn(name = "alumnoid")
	     private Student alumno;
		 
		 @ManyToOne
		 @JoinColumn(name = "actividadid")
	     private Activity actividad;
		
			@Column(name = "fecha_asistencia")
			private Date fecha_asistencia ;

			public int getId_asistencia() {
				return id_asistencia;
			}

			public void setId_asistencia(int id_asistencia) {
				this.id_asistencia = id_asistencia;
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

			public Date getFecha_asistencia() {
				return fecha_asistencia;
			}

			public void setFecha_asistencia(Date fecha_asistencia) {
				this.fecha_asistencia = fecha_asistencia;
			}

			public Assistence(int id_asistencia, Student alumno, Activity actividad, Date fecha_asistencia) {
				super();
				this.id_asistencia = id_asistencia;
				this.alumno = alumno;
				this.actividad = actividad;
				this.fecha_asistencia = fecha_asistencia;
			}

			public Assistence() {
				super();
			}

			public Assistence(Student alumno, Activity actividad, Date fecha_asistencia) {
				super();
				this.alumno = alumno;
				this.actividad = actividad;
				this.fecha_asistencia = fecha_asistencia;
			}

			@Override
			public String toString() {
				return "Assistence [id_asistencia=" + id_asistencia + ", alumno=" + alumno + ", actividad=" + actividad
						+ ", fecha_asistencia=" + fecha_asistencia + "]";
			}
		
}

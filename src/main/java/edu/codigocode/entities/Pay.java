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
@Table(name = "pago")
public class Pay {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id_pago ;

	@Column(name = "total")
	private int total ;
	
	@Column(name = "fecha_pago")
	private Date fecha_pago ;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "alumno_id")
     private Student alumno;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "actividad_id")
     private Activity actividad;

	public int getId_pago() {
		return id_pago;
	}

	public void setId_pago(int id_pago) {
		this.id_pago = id_pago;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Date getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
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

	public Pay(int id_pago, int total, Date fecha_pago, Student alumno, Activity actividad) {
		super();
		this.id_pago = id_pago;
		this.total = total;
		this.fecha_pago = fecha_pago;
		this.alumno = alumno;
		this.actividad = actividad;
	}

	public Pay(int total, Date fecha_pago, Student alumno, Activity actividad) {
		super();
		this.total = total;
		this.fecha_pago = fecha_pago;
		this.alumno = alumno;
		this.actividad = actividad;
	}
	 
	 
	 
	
}

package edu.codigocode.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumno")
public class Student {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	@Column(name = "nombre")
	private String nombre ;
	
	@Column(name = "apellido")
	private String apellido ;
	
	@Column(name = "dni")
	private int dni ;
	
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento ;
	
	@Column(name = "mail")
	private String mail ;
	
	@Column(name = "obra_social")
	private String obra_social ;
	
	@Column(name = "cert_medico")
	private String cert_medico ;
	
	@Column(name = "num_socio")
	private int num_socio ;
	
	@Column(name = "estado_cuota")
	private boolean estado_cuota;
	
	
	
	
	public Student(String nombre, String apellido, int dni, Date fecha_nacimiento, String mail, String obra_social,
			String cert_medico, int num_socio) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fecha_nacimiento = fecha_nacimiento;
		this.mail = mail;
		this.obra_social = obra_social;
		this.cert_medico = cert_medico;
		this.num_socio = num_socio;
	}




	public Student() {
		
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public int getDni() {
		return dni;
	}




	public void setDni(int dni) {
		this.dni = dni;
	}




	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}




	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}




	public String getMail() {
		return mail;
	}




	public void setMail(String mail) {
		this.mail = mail;
	}




	public String getObra_social() {
		return obra_social;
	}




	public void setObra_social(String obra_social) {
		this.obra_social = obra_social;
	}




	public String getCert_medico() {
		return cert_medico;
	}




	public void setCert_medico(String cert_medico) {
		this.cert_medico = cert_medico;
	}




	public int getNum_socio() {
		return num_socio;
	}




	public void setNum_socio(int num_socio) {
		this.num_socio = num_socio;
	}




	public boolean isEstado_cuota() {
		return estado_cuota;
	}




	public void setEstado_cuota(boolean estado_cuota) {
		this.estado_cuota = estado_cuota;
	}


    	
	
}

package edu.codigocode.entities;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "alumno")
public class Student {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id ;
	 
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
	
	@JsonIgnore
	@OneToMany( cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "alumno", fetch = FetchType.LAZY)
	private Set<Inscription> inscriptiones=new HashSet<Inscription>();
		
	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Pay>  pagos;
	

	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Asistence>  asistencias;
	
	 @OneToOne(mappedBy = "alumno")
	  private Adult adulto;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
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



	public Set<Inscription> getInscriptiones() {
		return inscriptiones;
	}



	public void setInscriptiones(Set<Inscription> inscriptiones) {
		this.inscriptiones = inscriptiones;
	}



	public Set<Pay> getPagos() {
		return pagos;
	}



	public void setPagos(Set<Pay> pagos) {
		this.pagos = pagos;
	}



	public Student() {
		super();
	}



	public Student(int id, String nombre, String apellido, int dni, Date fecha_nacimiento, String mail,
			String obra_social, String cert_medico, int num_socio, boolean estado_cuota) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fecha_nacimiento = fecha_nacimiento;
		this.mail = mail;
		this.obra_social = obra_social;
		this.cert_medico = cert_medico;
		this.num_socio = num_socio;
		this.estado_cuota = estado_cuota;
	}


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



	@Override
	public String toString() {
		return "Student [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", mail=" + mail + ", obra_social=" + obra_social
				+ ", cert_medico=" + cert_medico + ", num_socio=" + num_socio + ", estado_cuota=" + estado_cuota + "]";
	}



	public Student(int id) {
		super();
		this.id = id;
	}



	
	}
	
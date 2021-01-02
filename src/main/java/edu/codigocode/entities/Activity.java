package edu.codigocode.entities;

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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "actividad")
public class Activity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id_a;
	
	@Column(name = "nivel")
	private String nivel;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "edad")
	private String edad;
	
	@Column(name = "dias_practica")
	private String dias_practica;
	
	@Column(name = "valor")
	private int valor;
	
	@JsonIgnore
	@OneToMany( cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "actividad", fetch = FetchType.LAZY)
	private Set<Inscription> inscriptiones;
	
	@JsonIgnore
    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Pay>  pagos;

	@JsonIgnore
	 @OneToMany( cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "actividad", fetch = FetchType.LAZY)
	 private Set<Assistence>  asistencias;


	public int getId_a() {
		return id_a;
	}


	public void setId_a(int id_a) {
		this.id_a = id_a;
	}


	public String getNivel() {
		return nivel;
	}


	public void setNivel(String nivel) {
		this.nivel = nivel;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getEdad() {
		return edad;
	}


	public void setEdad(String edad) {
		this.edad = edad;
	}


	public String getDias_practica() {
		return dias_practica;
	}


	public void setDias_practica(String dias_practica) {
		this.dias_practica = dias_practica;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
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


	public Set<Assistence> getAsistencias() {
		return asistencias;
	}


	public void setAsistencias(Set<Assistence> asistencias) {
		this.asistencias = asistencias;
	}


	public Activity(String nivel, String categoria, String edad, String dias_practica, int valor) {
		super();
		this.nivel = nivel;
		this.categoria = categoria;
		this.edad = edad;
		this.dias_practica = dias_practica;
		this.valor = valor;
	}


	public Activity(int id_a, String nivel, String categoria, String edad, String dias_practica, int valor) {
		super();
		this.id_a = id_a;
		this.nivel = nivel;
		this.categoria = categoria;
		this.edad = edad;
		this.dias_practica = dias_practica;
		this.valor = valor;
	}


	public Activity(int id_a) {
		super();
		this.id_a = id_a;
	}


	public Activity() {
		
	}
		

}

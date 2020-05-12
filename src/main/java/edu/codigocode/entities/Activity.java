package edu.codigocode.entities;

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

@Entity
@Table(name = "actividad")
public class Activity {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Inscription> inscriptiones;
	
	 @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		private Set<Pay>  pagos;

	
	 @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 private Set<Asistence>  asistencias;
		

	public Activity(int id_act, String nivel, String categoria, String edad, String dias_practica, int valor) {
		super();
		this.id_a  = id_act;
		this.nivel = nivel;
		this.categoria = categoria;
		this.edad = edad;
		this.dias_practica = dias_practica;
		this.valor = valor;
	}

	public Activity() {
		super();
	}

	

	public int getId_act() {
		return id_a ;
	}

	public void setId_act(int id_act) {
		this.id_a  = id_act;
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

	@Override
	public String toString() {
		return "Actividad [id_act=" + id_a  + ", nivel=" + nivel + ", categoria=" + categoria + ", edad=" + edad
				+ ", dias_practica=" + dias_practica + ", valor=" + valor + "]";
	}
	

	
	
	
}

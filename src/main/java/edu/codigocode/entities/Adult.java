package edu.codigocode.entities;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adulto")
public class Adult {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int id_adulto ;
	 
	@Column(name = "nombre")
	private String nombre ;
	
	@Column(name = "apellido")
	private String apellido ;
	
	@Column(name = "dni")
	private int dni ;
	
	@Column(name = "mail")
	private String mail ;
	
	@Column(name = "telefono")
	private int telefono;
	
	 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinColumn(name = "alumnomenor_id")
	  private Student alumno;

	public int getId_adulto() {
		return id_adulto;
	}

	public void setId_adulto(int id_adulto) {
		this.id_adulto = id_adulto;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Adult(int id_adulto, String nombre, String apellido, int dni, String mail, int telefono) {
		super();
		this.id_adulto = id_adulto;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.telefono = telefono;
	}

	public Adult() {
		super();
	}

	@Override
	public String toString() {
		return "Adulto [id_adulto=" + id_adulto + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", mail=" + mail + ", telefono=" + telefono + "]";
	}

	
	
	
	
}

package edu.codigocode.modelo;

import org.springframework.stereotype.Component;

@Component
public class Respuesta <T> {
	
	private int codigo;
	private String mensaje;
	private T objetoRespuesta;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public T getObjetoRespuesta() {
		return objetoRespuesta;
	}
	public void setObjetoRespuesta(T objetoRespuesta) {
		this.objetoRespuesta = objetoRespuesta;
	}

	
}
 
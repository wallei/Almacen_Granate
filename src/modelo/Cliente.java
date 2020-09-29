package modelo;

import modelo.*;

public class Cliente extends Actor {
	private String apellido;
	private String nombre;
	private long dni;
	private char sexo;

	public Cliente(int id, String apellido, String nombre, long dni, char sexo,Contacto contacto) {
		super(id, contacto);
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
	}





	@Override
	public String toString() {
		return "Cliente [apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + ", sexo=" + sexo + ", id=" + id
				+ ", contacto=" + contacto + "]";
	}





	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

}

package modelo;

import java.time.LocalTime;

public class Turno {
	private int dia;
	private LocalTime hora;
	private boolean ocupado;

	public Turno(int dia, LocalTime hora, boolean ocupado) {
		this.dia = dia;
		this.hora = hora;
		this.ocupado = ocupado;
	}

	@Override
	public String toString() {
		return "Turno [dia=" + dia + ", hora=" + hora + ", ocupado=" + ocupado + "]";
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

}

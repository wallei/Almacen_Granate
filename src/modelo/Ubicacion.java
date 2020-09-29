package modelo;

public class Ubicacion {
	public double latitud;
	public double longitud;

	@Override
	public String toString() {
		return "Ubicacion [latitud=" + latitud + ", longitud=" + longitud + "]";
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public Ubicacion(double latitud, double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}
}

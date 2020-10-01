package modelo;

public class Articulo {

	private int id;
	private String nombre;
	private String codBarras;
	private double precio;

	public Articulo(int id, String nombre, String codBarras, double precio) {

		this.id = id;
		this.nombre = nombre;
		this.codBarras = codBarras;
		this.precio = precio;

	}

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

	public String getCodBarras() {
		return codBarras;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", codBarras=" + codBarras + ", precio=" + precio + " ] ";
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public boolean validarCodBarras(String codBarra) {
        String[] codigoString = codBarra.split("");
        int[] codigoInt = new int[codigoString.length];
        int sumaPares = 0, sumaImpares = 0;

        if (codBarra.length() == 13) {

            for (int i = 0; i < codigoString.length; i++) {

                codigoInt[i] = Integer.parseInt(codigoString[i]);
                if (i % 2 == 0 && i != 12) {
                    sumaPares = sumaPares + codigoInt[i];
                }
                if (i % 2 == 1 && i != 13) {
                    sumaImpares = sumaImpares + codigoInt[i];
                }

            }
            int imparesParesSumados, contador = 0;
            imparesParesSumados = sumaPares + sumaImpares * 3;

            while (imparesParesSumados % 10 != 0) {
                contador++;
                imparesParesSumados++;
            }

            if (contador == codigoInt[12]) {
                this.codBarras = codBarra;
                return true;
            } else {
                System.out.println("Codigo invalido");
                return false;
            }

        } else {
            System.out.println("La longitud del codigo es invalida");
            return false;
        }
    }

}

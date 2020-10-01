package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comercio extends Actor {
	private String nombreComercio;
	private long cuit;
	private double costoFijo;
	private double costoPorKm;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajesDescuentoEfectivo;
	private List<DiaRetiro> lstDiaRetiro;
	private List<Articulo> lstArticulos;
	private List<Carrito> lstCarrito;
	private List<Turno> lstTurnos;

	public Comercio(int id, String nombreComercio, long cuit, double costoFijo, double costoPorKm, int diaDescuento,
			int porcentajeDescuentoDia, int porcentajesDescuentoEfectivo, Contacto contacto) {
		super(id, contacto);
		this.nombreComercio = nombreComercio;
		this.lstDiaRetiro = new ArrayList<DiaRetiro>();
		this.lstArticulos = new ArrayList<Articulo>();
		this.lstCarrito = new ArrayList<Carrito>();
		this.lstTurnos = new ArrayList<Turno>();

	}

	public List<Turno> getLstTurnos() {
		return lstTurnos;
	}

	public void setLstTurnos(List<Turno> lstTurnos) {
		this.lstTurnos = lstTurnos;
	}

	public String getNombreComercio() {
		return nombreComercio;
	}

	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}

	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
	}

	public double getCostoFijo() {
		return costoFijo;
	}

	public void setCostoFijo(double costoFijo) {
		this.costoFijo = costoFijo;
	}

	public double getCostoPorKm() {
		return costoPorKm;
	}

	public void setCostoPorKm(double costoPorKm) {
		this.costoPorKm = costoPorKm;
	}

	public int getDiaDescuento() {
		return diaDescuento;
	}

	public void setDiaDescuento(int diaDescuento) {
		this.diaDescuento = diaDescuento;
	}

	public int getPorcentajeDescuentoDia() {
		return porcentajeDescuentoDia;
	}

	public void setPorcentajeDescuentoDia(int porcentajeDescuentoDia) {
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
	}

	public int getPorcentajesDescuentoEfectivo() {
		return porcentajesDescuentoEfectivo;
	}

	public void setPorcentajesDescuentoEfectivo(int porcentajesDescuentoEfectivo) {
		this.porcentajesDescuentoEfectivo = porcentajesDescuentoEfectivo;
	}

	public List<DiaRetiro> getLstDiaRetiro() {
		return lstDiaRetiro;
	}

	public void setLstDiaRetiro(List<DiaRetiro> lstDiaRetiro) {
		this.lstDiaRetiro = lstDiaRetiro;
	}

	public List<Articulo> getLstArticulos() {
		return lstArticulos;
	}

	public void setLstArticulos(List<Articulo> lstArticulos) {
		this.lstArticulos = lstArticulos;
	}

	public List<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(List<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
	}

	@Override
	public String toString() {
		return "Comercio [nombreComercio=" + nombreComercio + ", cuit=" + cuit + ", costoFijo=" + costoFijo
				+ ", costoPorKm=" + costoPorKm + ", diaDescuento=" + diaDescuento + ", porcentajeDescuentoDia="
				+ porcentajeDescuentoDia + ", porcentajesDescuentoEfectivo=" + porcentajesDescuentoEfectivo
				+ ", lstDiaRetiro=" + lstDiaRetiro + ", lstArticulos=" + lstArticulos + ", lstCarrito=" + lstCarrito
				+ "]";
	}

	/*
	 * PUNTO 6) + agregarDiaRetiro agregarDiaRetiro(int diaSemana, LocalTime
	 * horaDesde, LocalTime horaHasta, int intervalo):boolean
	 */

	public boolean agregarDiaRetiro(int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo) {
		boolean agregarDiaRetiro = false;
		int tamanio = 0;
		int idUltimo = 0;

		tamanio = lstDiaRetiro.size();

		if (tamanio != 0) {

			idUltimo = lstDiaRetiro.get(tamanio - 1).getId();
		}

		DiaRetiro diaDeRetiro = new DiaRetiro(idUltimo + 1, diaSemana, horaDesde, horaHasta, intervalo);

		agregarDiaRetiro = lstDiaRetiro.add(diaDeRetiro);

		return agregarDiaRetiro;
	}

	/*
	 * 4) + traerTurnosOcupados(LocalDate fecha):Turno //retorna una lista de
	 * objetos Turno dados
	 */

	/* 3) + generarTurnosLibres (LocalDate fecha) : Turno */

	public List<Turno> generarTurnosLibres(LocalDate fecha) {
		/*
		 * NO SE GRABA EN NINGUN LADO, ES AL VUELO.
		 */

		List<Turno> lstTurnosLibres = new ArrayList<Turno>(); // genero mi listado de Turnos libres VACIO.

		DiaRetiro diaderetiro= traerDiaDeRetiro(fecha);
	
		
		if (diaderetiro!= null) {
		
			LocalTime horaDesde = diaderetiro.getHoraDesde() ;
			LocalTime horaHasta = diaderetiro.getHoraHasta() ;
			int intervalo = diaderetiro.getIntervalo();
			int cantidadTurnosPorHora = 60/intervalo;
			
			
			while(horaDesde.isBefore(horaHasta)) {
				//System.out.println(horaDesde);
				Turno turno1 = new Turno(fecha.getDayOfMonth(), horaDesde, false);
				
				lstTurnosLibres.add(turno1);
				horaDesde = horaDesde.plusMinutes(intervalo);
			}
			
		}
		return lstTurnosLibres;
	}

	public DiaRetiro traerDiaDeRetiro(LocalDate fecha) {
		int dia = fecha.getDayOfWeek().getValue(); // paso a NUMERO el valor del dia
		int i = 0;
		DiaRetiro diaDeRetiro = null; // declaro la variable diaDeRetiro del tipo DiaRetiro.

		// LOS TRAER siempre tienen WHILE
		while (diaDeRetiro == null && i < lstDiaRetiro.size()) {
			if (dia == lstDiaRetiro.get(i).getDiaSemana()) {
				diaDeRetiro = lstDiaRetiro.get(i); // almacena el diaDeRetiro en la variable (EN ESTE CASO SI, por eso lo guarda )
			}
			i++;
		}

		return diaDeRetiro;

	}


	public boolean agregarArticulo(String nombre, String codBarras, double precio) throws Exception {
		boolean agregarArticulo= false;
		int idUltimo=0;
		
		if (traerArticulo(codBarras)!= null ) {
			throw new Exception ("El ARTICULO ya existe!");
		}else {
			
			if (lstArticulos.size() > 0) {

				idUltimo = lstArticulos.get(lstArticulos.size() - 1).getId(); // obtengo el ID del ultimo item de mi carrito.
			}
			
			Articulo articulo = new Articulo(idUltimo+1,nombre,codBarras, precio);
			agregarArticulo= lstArticulos.add(articulo);
		}
		

		
		return agregarArticulo;
	}
	
	
	public Articulo traerArticulo(String codBarras) {
		Articulo articulo = null; //bandera que dice que esta vacia
		
		int i = 0;
		
		while (articulo== null && i < lstArticulos.size()) { // SI NO ENCUENTRO LA PELICULA | i<catalogo.size PARA NO
															// EXCEDER DEL TAMAÑO.
			if (codBarras.compareTo(lstArticulos.get(i).getCodBarras())== 0) {
				articulo = lstArticulos.get(i);
			}
			i++; // 
		}

		return articulo;
	}
	
	//Carrito carro1 = new Carrito(1, LocalDate.of(2020, 10, 01), LocalTime.of(10, 11), true, 10, cliente1, retirolocal1);
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente, Entrega entrega) {
		boolean agregarCarritoOk = true;
		int i = 0;
		int idUltimo = 0;
		int totalCarritos = 0;

		totalCarritos = lstCarrito.size();

		if (totalCarritos > 0) {
			idUltimo = lstCarrito.get(totalCarritos - 1).getId();
		}

		Carrito carrito1 = new Carrito(idUltimo + 1, fecha, hora, cerrado, descuento,cliente, entrega);
		return lstCarrito.add(carrito1);

	}

	public Carrito traerCarrito(int id) {
		// LA BUSQUEDA LA HAGO POR DNI.
		Carrito carro = null;

		int i = 0;
		while (carro == null && i < lstCarrito.size()) {

			if (id == lstCarrito.get(i).getId()) {
				carro = lstCarrito.get(i);
			}
			i++; // cambio de producto.
		}

		return carro;
	}
	
}

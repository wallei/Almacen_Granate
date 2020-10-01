package modelo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import modelo.*;

public class Carrito {
	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private List<ItemCarrito> lstItemCarrito;
	private Entrega entrega;
	

public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente, Entrega entrega) {
	this.id=id;
	this.fecha=fecha;
	this.hora=hora;
	this.cerrado=cerrado;
	this.descuento=descuento;
	this.cliente=cliente;
	this.lstItemCarrito = new ArrayList<ItemCarrito>();
	this.entrega=entrega;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public LocalDate getFecha() {
	return fecha;
}


public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}


public LocalTime getHora() {
	return hora;
}


public void setHora(LocalTime hora) {
	this.hora = hora;
}


public boolean isCerrado() {
	return cerrado;
}


public void setCerrado(boolean cerrado) {
	this.cerrado = cerrado;
}


public double getDescuento() {
	return descuento;
}


public void setDescuento(double descuento) {
	this.descuento = descuento;
}


public Cliente getCliente() {
	return cliente;
}


public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}


public List<ItemCarrito> getLstItemCarrito() {
	return lstItemCarrito;
}


public void setLstItemCarrito(List<ItemCarrito> lstItemCarrito) {
	this.lstItemCarrito = lstItemCarrito;
}


public Entrega getEntrega() {
	return entrega;
}


public void setEntrega(Entrega entrega) {
	this.entrega = entrega;
}


/* + agregar(Articulo articulo, int cantidad):boolean */


public boolean agregarItem(Articulo articulo, int cantidad) throws Exception {

	boolean agregarItem = false;
	boolean encontrarItem = false;
	int i = 0;
	;

	ItemCarrito itemcarro = traerItem(articulo); // invoco al metodo que cree mas abajo.
	if (itemcarro == null) {

		itemcarro = new ItemCarrito(articulo, cantidad);
		agregarItem = lstItemCarrito.add(itemcarro); // EL ADD SIEMPRE, PERO SIEMPRE ME VA A DEVOLVER UN BOOLEANO.
	} else {
		itemcarro.setCantidad(itemcarro.getCantidad() + cantidad); // getCANTIDAD, para que me devuelva la que TENGO
																	// + LA CANTIDAD NUEVA QUE LE PASO.
		agregarItem = true;
	}

	return agregarItem;
}

public ItemCarrito traerItem(Articulo articulo) {
	ItemCarrito item = null;

	int i = 0;
	while (item == null && i < lstItemCarrito.size()) {

		if (articulo.equals(lstItemCarrito.get(i).getArticulo())) {
			item = lstItemCarrito.get(i);
		}
		i++; // cambio de producto.
	}
	return item;
}


@Override
public String toString() {
	return "Carrito [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", cerrado=" + cerrado + ", descuento="
			+ descuento + ", cliente=" + cliente + ", lstItemCarrito=" + lstItemCarrito + ", entrega=" + entrega + "]";
}

}

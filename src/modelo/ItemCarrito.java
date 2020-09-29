package modelo;

public class ItemCarrito {
	private Articulo articulo;
	private int cantidad;

public ItemCarrito(){
	this.articulo=articulo;
	this.cantidad=cantidad;
}

public Articulo getArticulo() {
	return articulo;
}

public void setArticulo(Articulo articulo) {
	this.articulo = articulo;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

}

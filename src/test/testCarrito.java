package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Carrito;
import modelo.Cliente;
import modelo.Comercio;
import modelo.Contacto;
import modelo.RetiroLocal;
import modelo.Ubicacion;

public class testCarrito {

	public static void main(String[] args) {
		Ubicacion ubicacion1 = new Ubicacion(-34.6317485,-58.4280286);
		Contacto contacto1 = new Contacto("wgazzanego@gmail.com", "1525465448", ubicacion1);
		Cliente cliente1 = new Cliente(1, "Gazzanego","Walter", 328304334l, 'M', contacto1);
		Comercio LoDeWallu = new Comercio(1, "Lo de Wallu", 32830433l, 100.00, 50.00, 2, 10, 20, contacto1);
		
		
		
		RetiroLocal retirolocal1 = new RetiroLocal(1,LocalDate.of(2020, 10, 01),true,LocalTime.of(10, 11));
		System.out.println(retirolocal1);
		
		Carrito carro1 = new Carrito(1, LocalDate.of(2020, 10, 01), LocalTime.of(10, 11), true, 10, cliente1, retirolocal1);
		
		try {
			System.out.println("AGREGAMOS 3 PRODUCTOS:"+ "\n");
			LoDeWallu.agregarArticulo("Lavandina", "111111111111", 50.00);
			LoDeWallu.agregarArticulo("Coca-Cola", "111111111112", 60.00);
			LoDeWallu.agregarArticulo("Oreo galletita", "111111111113", 80.00);
			
			
			System.out.println(LoDeWallu.getLstArticulos());

			System.out.println("Agregamos 1 carrito: ");
			LoDeWallu.agregarCarrito(LocalDate.of(2020, 10, 01), LocalTime.of(10, 11), true, 10, cliente1, retirolocal1);
			
			LoDeWallu.traerCarrito(1).agregarItem(LoDeWallu.traerArticulo("111111111111"),10);
			LoDeWallu.traerCarrito(1).agregarItem(LoDeWallu.traerArticulo("111111111112"),5);
			
			System.out.println("IMPRIMO SOLO LA LISTA: (por que el carrito es una espantosidad enorme)");
			System.out.println(LoDeWallu.traerCarrito(1).getLstItemCarrito());
			
			
			
			
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

	}

}

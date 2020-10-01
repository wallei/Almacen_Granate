package test;
import java.time.LocalDate;

import modelo.*;

public class testArticulos {

	public static void main(String[] args) {

		Ubicacion ubicacion1 = new Ubicacion(-34.6317485,-58.4280286);
		Contacto contacto1 = new Contacto("wgazzanego@gmail.com", "1525465448", ubicacion1);
		Cliente cliente1 = new Cliente(1, "Gazzanego","Walter", 328304334l, 'M', contacto1);
		Comercio LoDeWallu = new Comercio(1, "Lo de Wallu", 32830433l, 100.00, 50.00, 2, 10, 20, contacto1);
		
		 LocalDate date2 = LocalDate.of(2020, 10, 01);

		
		try {
			System.out.println("AGREGAMOS 3 PRODUCTOS:"+ "\n");
			LoDeWallu.agregarArticulo("Lavandina", "111111111111", 50.00);
			LoDeWallu.agregarArticulo("Coca-Cola", "111111111112", 60.00);
			LoDeWallu.agregarArticulo("Oreo galletita", "111111111113", 80.00);
			
			
			System.out.println(LoDeWallu.getLstArticulos());

			
			
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		try {
			System.out.println("\n");
			System.out.println("CARGA PRODUCTO REPETIDA, deberia arroja excepcion: ");
			LoDeWallu.agregarArticulo("Desodorante", "111111111113", 90.00);
			LoDeWallu.agregarArticulo("Desodorante", "111111111113", 90.00);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		}
	}


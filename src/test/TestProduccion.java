package test;
import java.time.LocalDate;
import java.time.LocalTime;

import modelo.*;

public class TestProduccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ubicacion ubicacion1 = new Ubicacion(-34.6317485,-58.4280286);
		Contacto contacto1 = new Contacto("wgazzanego@gmail.com", "1525465448", ubicacion1);
		Cliente cliente1 = new Cliente(1, "Gazzanego","Walter", 328304334l, 'M', contacto1);
		Comercio LoDeWallu = new Comercio(1, "Lo de Wallu", 32830433l, 100.00, 50.00, 2, 10, 20, contacto1);
		
		System.out.println(cliente1);
		
		
		System.out.println(LocalDate.now().getDayOfWeek().getValue());
		
		
		
		//Agregamos el dia de RETIRO: 1
		//System.out.println(LoDeWallu.agregarDiaRetiro(1, LocalTime.now(), LocalTime.now(),20 ));
		
		//Agregamos el dia de RETIRO: 2, de 10 a 12 hs
		LocalTime time = LocalTime.parse("10:00:00"); // .parse lo FORMATEA.
		LocalTime time2 = LocalTime.parse("12:00:00");
		
		System.out.println(LoDeWallu.agregarDiaRetiro(2, time, time2,20 ));		
		System.out.println(LoDeWallu);
		System.out.println("");
		System.out.println("IMPRESION DIAS DE RETIRO List<LstDiaRetiro>: ");
		System.out.println(LoDeWallu.getLstDiaRetiro());
		
		
		System.out.println(" ");
		System.out.println("Dia de RETIRO: " + (LocalDate.now().getDayOfWeek()));
		System.out.println(LoDeWallu.generarTurnosLibres(LocalDate.now()));
		
		
		
		
	}

}

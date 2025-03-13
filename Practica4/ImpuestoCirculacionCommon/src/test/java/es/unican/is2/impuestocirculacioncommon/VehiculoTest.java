package es.unican.is2.impuestocirculacioncommon;


import org.junit.Test;

import static org.junit.Assert.*;

import java.time.LocalDate;

public class VehiculoTest {
	LocalDate now = LocalDate.now();
	Vehiculo t = new Turismo(122, "9939HHY", now.minusYears(3), TipoMotor.DIESEL, 13);
	Vehiculo t2 = new Turismo(122, "9939HHY", now.minusYears(3), TipoMotor.DIESEL, 13);
	Vehiculo t3 = new Turismo(122, "9939HHY", now.minusYears(3), TipoMotor.DIESEL, 13);
	Vehiculo m = new Motocicleta(122, "9939HHY", now.minusYears(3), TipoMotor.DIESEL, 250);
	@Test
	public void testPrecioImpuesto() {
		assertTrue("El precio impuesto del turismo no es correcto", t.precioImpuesto() == 143);
		
		assertTrue("El precio impuesto de la motocicleta no es corecto", m.precioImpuesto() == 15);
	}
}

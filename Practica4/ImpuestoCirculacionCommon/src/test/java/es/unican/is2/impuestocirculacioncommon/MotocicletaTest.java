package es.unican.is2.impuestocirculacioncommon;

import org.junit.Test;




import static org.junit.Assert.*;

import java.time.LocalDate;

public class MotocicletaTest {
	private Vehiculo motocicleta;
	
	@Test
    public void testMotocicletaPotenciaMenor8_AntiguedadMenor25_Convencional() {
        motocicleta = new Motocicleta(1, "1234ABC", LocalDate.now().minusYears(10), TipoMotor.GASOLINA, 124);
        assertTrue(motocicleta.precioImpuesto() == 8);
    }
	
	
}

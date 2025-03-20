package es.unican.is2.impuestocirculacioncommon;


import org.junit.Test;



import static org.junit.Assert.*;

import java.time.LocalDate;

public class TurismoTest {
	
	private Vehiculo turismo;

    @Test
    public void testTurismoPotenciaMenor8_AntiguedadMenor25_Convencional() {
        turismo = new Turismo(1, "1234ABC", LocalDate.now().minusYears(10), TipoMotor.GASOLINA, 7);
        assertTrue(turismo.precioImpuesto() == 25);
    }

    @Test
    public void testTurismoPotenciaEntre8y12_AntiguedadMenor25_Convencional() {
        turismo = new Turismo(2, "5678DEF", LocalDate.now().minusYears(5), TipoMotor.DIESEL, 10);
        assertTrue(turismo.precioImpuesto() == 67);
    }

    @Test
    public void testTurismoPotenciaEntre12y16_AntiguedadMayorIgual25_Convencional() {
        turismo = new Turismo(3, "9101GHI", LocalDate.now().minusYears(25), TipoMotor.GASOLINA, 14);
        assertTrue(turismo.precioImpuesto() == 0);
    }

    @Test
    public void testTurismoPotenciaMayor20_AntiguedadMenor25_Electrico() {
        turismo = new Turismo(4, "1213JKL", LocalDate.now().minusYears(3), TipoMotor.ELECTRICO, 21);
        assertTrue(turismo.precioImpuesto() == 55.75);
    }

    @Test
    public void testTurismoPotencia15_AntiguedadMenor4_Hibrido() {
        turismo = new Turismo(5, "1415MNO", LocalDate.now().minusYears(3), TipoMotor.HIBRIDO, 15);
        assertTrue(turismo.precioImpuesto() == 35.75);
    }

    @Test
    public void testTurismoPotencia15_AntiguedadMayorIgual4_Hibrido() {
        turismo = new Turismo(6, "1617PQR", LocalDate.now().minusYears(5), TipoMotor.HIBRIDO, 15);
        assertTrue(turismo.precioImpuesto() == 143);
    }

    @Test
    public void testTurismoPotencia10_AntiguedadMenor1_Gas() {
        turismo = new Turismo(7, "1819STU", LocalDate.now().minusYears(0), TipoMotor.GAS, 10);
        assertTrue(turismo.precioImpuesto() == 33.5);
    }

    @Test
    public void testTurismoPotencia10_AntiguedadMayorIgual1_Gas() {
        turismo = new Turismo(8, "2021VWX", LocalDate.now().minusYears(1), TipoMotor.GAS, 10);
        assertTrue(turismo.precioImpuesto() == 67);
    }

    @Test
    public void testTurismoPotencia8_Antiguedad10_Convencional() {
        turismo = new Turismo(9, "2223YZA", LocalDate.now().minusYears(10), TipoMotor.GASOLINA, 8);
        assertTrue(turismo.precioImpuesto() == 67);
    }

    @Test
    public void testTurismoPotencia12_Antiguedad10_Convencional() {
        turismo = new Turismo(10, "2425BCD", LocalDate.now().minusYears(10), TipoMotor.DIESEL, 12);
        assertTrue(turismo.precioImpuesto() == 143);
    }

    @Test
    public void testTurismoPotencia16_Antiguedad10_Convencional() {
        turismo = new Turismo(11, "2627EFG", LocalDate.now().minusYears(10), TipoMotor.GASOLINA, 16);
        assertTrue(turismo.precioImpuesto() == 178);
    }
    //Hasta aqui ya cubro todo
    @Test
    public void testTurismoPotencia20_Antiguedad10_Convencional() {
        turismo = new Turismo(12, "2829HIJ", LocalDate.now().minusYears(10), TipoMotor.DIESEL, 20);
        assertTrue(turismo.precioImpuesto() == 223);
    }
    
    //Caja blanca
    @Test
    public void testTurismoHibridoConMenosDe4Años() {
        Turismo turismo = new Turismo(13, "1234ABC", LocalDate.now().minusYears(3), TipoMotor.HIBRIDO, 10);
        assertTrue(turismo.precioImpuesto() == 16.75);
    }

    @Test
    public void testTurismoHibridoCon4AñosExactos() {
        Turismo turismo = new Turismo(14, "5678DEF", LocalDate.now().minusYears(4), TipoMotor.HIBRIDO, 14);
        assertTrue(turismo.precioImpuesto() == 143);
    }

    @Test
    public void testTurismoExencionPorAntiguedad25Años() {
        Turismo turismo = new Turismo(15, "7890GHI", LocalDate.now().minusYears(25), TipoMotor.DIESEL, 22);
        assertTrue(turismo.precioImpuesto() == 0);
    }

    @Test
    public void testTurismoGasConMenosDe1Año() {
        Turismo turismo = new Turismo(16, "1111JKL", LocalDate.now(), TipoMotor.GAS, 22);
        assertTrue(turismo.precioImpuesto() == 111.5);
    }
}

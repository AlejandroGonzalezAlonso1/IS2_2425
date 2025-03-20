package es.unican.is2.impuestocirculacioncommon;

import java.time.LocalDate;

/**
 * Clase que representa un vehiculo de tipo turismo.
 */
public class Turismo extends Vehiculo {

	private double potencia;
	
	public Turismo(long id, String matricula, LocalDate fechaMatriculacion, TipoMotor motor, double potencia) {
		super(id, matricula, fechaMatriculacion, motor);
		this.potencia = potencia;
	}

	/**
	 * Retorna la potencia en caballos fiscales del vehiculo.
	 */
	public double getPotencia() {
		return potencia;
	}

	@Override
	public double precioImpuesto() {
		double tarifaBase;
        if (potencia < 8) {
            tarifaBase = 25;
        } else if (potencia < 12) {
            tarifaBase = 67;
        } else if (potencia < 16) {
            tarifaBase = 143;
        } else if (potencia < 20) {
            tarifaBase = 178;
        } else {
            tarifaBase = 223;
        }
        LocalDate hoy = LocalDate.now();
        int antiguedad = hoy.getYear() - getFechaMatriculacion().getYear();
        if (antiguedad >= 25) {
            return 0;
        }
        if (getMotor() == TipoMotor.ELECTRICO) {
            return tarifaBase * 0.25;
        } 
        if (getMotor() == TipoMotor.HIBRIDO && antiguedad < 4) {
            return tarifaBase * 0.25;
        }     
        if (getMotor() == TipoMotor.GAS && antiguedad < 1) {
            return tarifaBase * 0.5;
        }
        return tarifaBase;
	}

}

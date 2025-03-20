package es.unican.is2.impuestocirculacioncommon;



import java.time.LocalDate;

/**
 * Clase que representa un vehiculo de tipo motocicleta
 */
public class Motocicleta extends Vehiculo {

	private int cilindrada;

	public Motocicleta(long id, String matricula, LocalDate fechaMatriculacion, TipoMotor motor, int cilindrada) {
		super(id, matricula, fechaMatriculacion, motor);
		this.cilindrada = cilindrada;
	}

	/**
	 * Retorna la cilindrada en CC de la motocicleta.
	 */
	public int getCilindrada() {
		return cilindrada;
	}

	@Override
	public double precioImpuesto() {
		double tarifa;
        if (cilindrada <= 125) {
            tarifa = 8;
        } else if (cilindrada <= 250) {
            tarifa = 15;
        } else if (cilindrada <= 500) {
            tarifa = 30;
        } else if (cilindrada <= 1000) {
            tarifa = 60;
        } else {
            tarifa = 120;
        }
        LocalDate hoy = LocalDate.now();
        int antiguedad = hoy.getYear() - getFechaMatriculacion().getYear();
        if (antiguedad >= 25) {
            return 0;
        }
        if (getMotor() == TipoMotor.ELECTRICO) {
            return tarifa * 0.25;
        } 
        if (getMotor() == TipoMotor.HIBRIDO && antiguedad < 4) {
            return tarifa * 0.25;
        }
        if (getMotor() == TipoMotor.GAS && antiguedad < 1) {
            return tarifa * 0.5;
        }
        return tarifa;
	}

}

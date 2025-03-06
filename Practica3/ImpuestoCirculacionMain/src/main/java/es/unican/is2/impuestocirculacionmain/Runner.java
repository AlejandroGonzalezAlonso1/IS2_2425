package es.unican.is2.impuestocirculacionmain;

import es.unican.is2.impuestocirculaciondaoh2.ContribuyentesDAO;
import es.unican.is2.impuestocirculaciondaoh2.VehiculosDAO;
import es.unican.is2.impuestocirculacionbusiness.GestionImpuestoCirculacion;
import es.unican.is2.impuestocirculaciongui.VistaFuncionario;

/**
 * Clase principal que construye la aplicación de tres capas y lanza su ejecución
 */
public class Runner {

	public static void main(String[] args) {
		// Componentes capa DAO
		ContribuyentesDAO contribuyentesDAO = new ContribuyentesDAO();
		VehiculosDAO vehiculosDAO = new VehiculosDAO();
		
		// Componentes capa negocio
		GestionImpuestoCirculacion negocio = new GestionImpuestoCirculacion(contribuyentesDAO, vehiculosDAO);
		
		// Componentes casa presentacion
		VistaFuncionario vista = new VistaFuncionario(negocio);
		
		// Lanza ejecución
		vista.setVisible(true);
	}

}

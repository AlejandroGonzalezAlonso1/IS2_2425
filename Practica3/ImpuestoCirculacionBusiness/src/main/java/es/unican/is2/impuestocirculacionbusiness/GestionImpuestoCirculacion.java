package es.unican.is2.impuestocirculacionbusiness;

import es.unican.is2.impuestocirculacioncommon.*;
import es.unican.is2.impuestocirculaciondaoh2.*;

public class GestionImpuestoCirculacion implements IGestionContribuyentes, IGestionVehiculos, IInfoImpuestoCirculacion {
	private ContribuyentesDAO contribuyentesDAO;
	private VehiculosDAO vehiculosDAO;
	
	public GestionImpuestoCirculacion(ContribuyentesDAO contribuyentesDAO, VehiculosDAO vehiculosDAO) {
		// TODO Auto-generated constructor stub
		this.contribuyentesDAO = contribuyentesDAO;
		this.vehiculosDAO = vehiculosDAO;
	}
	public Vehiculo vehiculo(String matricula) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Contribuyente contribuyente(String dni) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean cambiaTitularVehiculo(String matricula, String dniActual, String dniNuevo)
			throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}
	public Contribuyente altaContribuyente(Contribuyente c) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}

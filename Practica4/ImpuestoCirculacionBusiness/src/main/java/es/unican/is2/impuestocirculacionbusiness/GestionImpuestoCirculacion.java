package es.unican.is2.impuestocirculacionbusiness;

import es.unican.is2.impuestocirculacioncommon.*;
import es.unican.is2.impuestocirculaciondaoh2.*;

public class GestionImpuestoCirculacion implements IGestionContribuyentes, IGestionVehiculos, IInfoImpuestoCirculacion {
	private ContribuyentesDAO contribuyentesDAO;
	private VehiculosDAO vehiculosDAO;
	
	public GestionImpuestoCirculacion(ContribuyentesDAO contribuyentesDAO, VehiculosDAO vehiculosDAO) {
		this.contribuyentesDAO = contribuyentesDAO;
		this.vehiculosDAO = vehiculosDAO;
	}
	public Vehiculo vehiculo(String matricula) throws DataAccessException {
		try {
            return vehiculosDAO.vehiculoPorMatricula(matricula);
        } catch (DataAccessException e) {
            throw e;
        }
	}
	public Contribuyente contribuyente(String dni) throws DataAccessException {
		try {
            return contribuyentesDAO.contribuyente(dni);
        } catch (DataAccessException e) {
            throw e;
        }
	}
	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValidaException, DataAccessException {
		Contribuyente contribuyente = contribuyentesDAO.contribuyente(dni);
        if (contribuyente == null) {
            throw new OperacionNoValidaException("El contribuyente no existe");
        }
        contribuyente.getVehiculos().add(v);
        vehiculosDAO.creaVehiculo(v);
        return v;
	}
	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValidaException, DataAccessException {
		Contribuyente contribuyente = contribuyentesDAO.contribuyente(dni);
        if (contribuyente == null) {
            throw new OperacionNoValidaException("El contribuyente no existe");
        }
        Vehiculo vehiculo = contribuyente.buscaVehiculo(matricula);
        if (vehiculo == null) {
            throw new OperacionNoValidaException("El veh�culo no est� registrado a nombre del contribuyente");
        }
        contribuyente.getVehiculos().remove(vehiculo);
        vehiculosDAO.eliminaVehiculo(matricula);
        return vehiculo;
	}
	public boolean cambiaTitularVehiculo(String matricula, String dniActual, String dniNuevo)
			throws OperacionNoValidaException, DataAccessException {
		Contribuyente actual = contribuyentesDAO.contribuyente(dniActual);
        Contribuyente nuevo = contribuyentesDAO.contribuyente(dniNuevo);
        if (actual == null || nuevo == null) {
            throw new OperacionNoValidaException("Uno de los contribuyentes no existe");
        }
        Vehiculo vehiculo = actual.buscaVehiculo(matricula);
        if (vehiculo == null) {
            throw new OperacionNoValidaException("El veh�culo no est� registrado a nombre del contribuyente actual");
        }
        actual.getVehiculos().remove(vehiculo);
        nuevo.getVehiculos().add(vehiculo);
        return true;
	}
	public Contribuyente altaContribuyente(Contribuyente c) throws DataAccessException {
		try {
			return contribuyentesDAO.creaContribuyente(c);
		} catch (DataAccessException e) {
			throw e;
		}
	}
	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValidaException, DataAccessException {
		Contribuyente contribuyente = contribuyentesDAO.contribuyente(dni);
        if (contribuyente == null) {
            throw new OperacionNoValidaException("El contribuyente no existe");
        }
        if (!contribuyente.getVehiculos().isEmpty()) {
            throw new OperacionNoValidaException("El contribuyente tiene veh�culos registrados");
        }
        contribuyentesDAO.eliminaContribuyente(dni);
        return contribuyente;
	}

}

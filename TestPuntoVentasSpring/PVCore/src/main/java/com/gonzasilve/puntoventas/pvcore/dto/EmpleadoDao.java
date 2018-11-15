package com.gonzasilve.puntoventas.pvcore.dto;

import java.util.LinkedList;
import java.util.List;

/**
 * www.notas-programacion.com
 * Clase que implementa interface Dao con operaciones CRUD sobre el POJO Empleado
 * @author gonzasilve
 *
 */
public class EmpleadoDao implements IEmpleadoDao {

	//Simulamos una fuente de datos (la fuente de datos aqui es 
	//una coleccion pero en una aplicacion real es una conexion a una BD)
	private static List<Empleado> fuenteDatosEmpleados = new LinkedList<Empleado>();
	
	@Override
	public boolean agregar(Empleado empleado) {
		// Implementacion para agregar un Empleado		
		return fuenteDatosEmpleados.add(empleado);
	}

	@Override
	public boolean eliminar(Empleado empleado) {
		// Implementacion para eliminar un Empleado
		return fuenteDatosEmpleados.remove(empleado);
	}

	@Override
	public boolean eliminarPorId(int idEmpleado) {
		// Implementacion para buscar un Empleado por su Id
		for(Empleado emp : fuenteDatosEmpleados) {
			if(emp.getIdEmpleado()==idEmpleado)
				return fuenteDatosEmpleados.remove(emp);
		}
		return false;
	}

	@Override
	public List<Empleado> obtenerTodos() {
		// Implementacion para obtener la coleccion de todos los Empleados
		return fuenteDatosEmpleados;
	}

	@Override
	public Empleado buscarPorId(int idEmpleado) {
		// Implementacion para buscar un Empleado por su Id
		for(Empleado emp : fuenteDatosEmpleados) {
			if(emp.getIdEmpleado()==idEmpleado)
				return emp;
		}
		return null;
	}

	@Override
	public boolean actualizar(Empleado empleado) {
		// Implementacion para actualizar los datos de un Empleado
		for(Empleado emp : fuenteDatosEmpleados) {
			if(emp.getIdEmpleado()==empleado.getIdEmpleado()) {
				emp.setNombre(empleado.getNombre());
				emp.setApMaterno(empleado.getApMaterno());
				emp.setApPaterno(empleado.getApPaterno());
				emp.setDepartamento(empleado.getDepartamento());
				return true;
			}
				
		}
		return false;
	}


}

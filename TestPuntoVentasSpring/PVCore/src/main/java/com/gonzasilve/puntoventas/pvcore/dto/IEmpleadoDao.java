package com.gonzasilve.puntoventas.pvcore.dto;

import java.util.List;
/**
 * www.notas-programacion.com
 * Interface Dao con operaciones CRUD sobre el POJO Empleado
 * @author gonzasilve
 *
 */
public interface IEmpleadoDao {
	//Alta
	public boolean agregar(Empleado empleado);
	//Baja
	public boolean eliminar(Empleado empleado);
	public boolean eliminarPorId(int idEmpleado);
	//Consulta
	public List<Empleado> obtenerTodos();
	public Empleado buscarPorId(int idEmpleado);
	//Modificaciones
	public boolean actualizar(Empleado empleado);
	
}

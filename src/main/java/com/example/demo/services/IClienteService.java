package com.example.demo.services;

import java.util.List;
import com.example.demo.entity.Cliente;

public interface IEmpleadoService {
	
	public List<Cliente> getLista();

	public Cliente empleadoId(Long Id);
	
	public Cliente guardaEmpleado(Cliente empleado);
	
	public void Eliminar(Long id);
}

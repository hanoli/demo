package com.example.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> getLista();

	public Empleado empleadoId(Long Id);
	
	public Empleado guardaEmpleado(Empleado empleado);
	
	public void Eliminar(Long id);
}

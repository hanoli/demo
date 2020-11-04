package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> getLista();

	public Empleado empleadoId(Long Id);
}

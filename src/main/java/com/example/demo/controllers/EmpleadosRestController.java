package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Empleado;
import com.example.demo.services.IEmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadosRestController {

	@Autowired
	private IEmpleadoServiceImpl empleadosImpl;
	
	@GetMapping("/lista")
	public List<Empleado> getEmpleados(){
		return empleadosImpl.getLista();
		
		
	}
	
	
}

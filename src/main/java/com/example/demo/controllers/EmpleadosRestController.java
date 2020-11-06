package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Empleado;
import com.example.demo.services.IEmpleadoServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api
public class EmpleadosRestController {

	@Autowired
	private IEmpleadoServiceImpl empleadosImpl;
	
	@ApiOperation(value = "getEmpleados", notes = "Obtiene todos los empleados de la Base de Datos")
	@GetMapping("/lista")
	public List<Empleado> getEmpleados(){
		return empleadosImpl.getLista();
	}
	
	@ApiOperation(value = "getEmpleadoById", notes = "Obtiene un solo empleado de la Base de Datos por su Id")
	@GetMapping("/idEmpleado/{id}")
	public ResponseEntity<?> getEmpleadoById(@PathVariable Long id){
		Empleado empleado = empleadosImpl.empleadoId(id);
		
		Map<String,Object> response = new HashMap<>();
		
		if(empleado == null) {
			response.put("mensaje", "El Id del empleado no existe");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(empleado, HttpStatus.OK); 
	}
	
	
}

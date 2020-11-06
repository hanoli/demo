package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@ApiOperation(value = "Is Alive operation", notes = "Encuentra un empleado por su ID")
	@ApiResponses({@ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
	@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER"),
	@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "UNAUTHORIZED"),
	@ApiResponse(code = HttpServletResponse.SC_FORBIDDEN, message = "FORBIDDEN"),
	@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "ELEMENTO NOT FOUND")})
	@GetMapping("/lista")
	public List<Empleado> getEmpleados(){
		return empleadosImpl.getLista();
	}
	
	@GetMapping("/idEmpleado/{id}")
	public Empleado getEmpleadoById(@PathVariable Long id){
		return empleadosImpl.empleadoId(id);
	}
	
	
}

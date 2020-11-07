package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Empleado;
import com.example.demo.services.IEmpleadoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	
	@ApiOperation(value = "guardaEmpleado", notes = "Guarda un empleado en la BD")
	@PostMapping("/guardar")
	public ResponseEntity<?> guardaEmpleado(@RequestBody Empleado empleado ) {
		
		Map<String,Object> response = new HashMap<>();
		
		try {
			empleadosImpl.guardaEmpleado(empleado);	
		}catch (Exception e) {
			response.put("mensaje", "Hubo un problema al guardar el empleado");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El empleado se guardo con exito");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
		
	}
	
	@ApiOperation(value = "actualiza", notes = "Actualiza un empleado en la BD")
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualiza(@RequestBody Empleado empleado, @PathVariable Long id){
		
		Empleado empl = empleadosImpl.empleadoId(id);
		
		Map<String,Object> response = new HashMap<>();
		
		if(empl == null) {
			
			
			response.put("mensaje", "El Id del empleado no existe");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}else {
			try {
				
				empl.setNombre(empleado.getNombre());
				empl.setApellido(empleado.getApellido());
				
				empleadosImpl.guardaEmpleado(empl);
				
			}catch (Exception e) {
				response.put("mensaje", "Hubo un problema al actualizar el empleado");
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put("mensaje", "El empleado se actualizo con exito");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}
		
	}
	
	@ApiOperation(value = "actualiza", notes = "Elimina un empleado en la BD")
	@DeleteMapping("/Eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		
		empleadosImpl.Eliminar(id);
		
	}
	
	
}

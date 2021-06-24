package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Folio;
import com.example.demo.servicesImpl.ClienteServiceImpl;
import com.example.demo.servicesImpl.FolioServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api")
@Api
public class FoliosRestController {
	
	@Autowired
	private FolioServiceImpl foliosImpl;
	
	@ApiOperation(value = "getFolios", notes = "Obtiene todos los folios generados")
	@GetMapping("/listaFolios")
	public List<Folio> getFolios(){
		return foliosImpl.getLista();
	}
	
	@ApiOperation(value = "getFolioById", notes = "Obtiene un solo empleado de la Base de Datos por su Id")
	@GetMapping("/idFolio/{id}")
	public ResponseEntity<?> getFolioById(@PathVariable Long id){
		Folio folio = foliosImpl.folioId(id);
		
		Map<String,Object> response = new HashMap<>();
		
		if(folio == null) {
			response.put("mensaje", "El Id del empleado no existe");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(folio, HttpStatus.OK); 
	}
	
	@ApiOperation(value = "guardaFolio", notes = "Guarda un folio en la BD")
	@PostMapping("/guardarFolio")
	public ResponseEntity<?> guardaFolio(@RequestBody Folio folio ) {
			
		
		Map<String,Object> response = new HashMap<>();
		
		try {
			foliosImpl.guardaFolio(folio);	
		}catch (Exception e) {
			response.put("mensaje", "Hubo un problema al guardar el folio");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El folio se guardo con exito");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
		
	}
	
	/*@ApiOperation(value = "actualiza", notes = "Actualiza un empleado en la BD")
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualiza(@RequestBody Empleado empleado, @PathVariable Long id){
		
		Folio empl = foliosImpl.folioId(id);
		
		Map<String,Object> response = new HashMap<>();
		
		if(empl == null) {
			
			
			response.put("mensaje", "El Id del empleado no existe");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}else {
			try {
				
				empl.setNombre(empleado.getNombre());
				empl.setApellidoPat(empleado.getApellidoPat());
				
				foliosImpl.guardaEmpleado(empl);
				
			}catch (Exception e) {
				response.put("mensaje", "Hubo un problema al actualizar el empleado");
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put("mensaje", "El empleado se actualizo con exito");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}
		
	}*/
	
	@ApiOperation(value = "Eliminar", notes = "Elimina un empleado en la BD")
	@DeleteMapping("/eliminarFolio/{id}")
	public void eliminar(@PathVariable Long id) {
		
		foliosImpl.Eliminar(id);
		
	}
	
	
}

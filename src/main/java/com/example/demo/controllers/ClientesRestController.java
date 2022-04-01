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
import com.example.demo.servicesImpl.ClienteServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api")
@Api
public class ClientesRestController {

	@Autowired
	private ClienteServiceImpl clientesImpl;
	
	@ApiOperation(value = "getClientes", notes = "Obtiene todos los clientes de la Base de Datos")
	@GetMapping("/lista")
	public List<Cliente> getClientes(){
		return clientesImpl.getLista();
	}
	
	@ApiOperation(value = "getClienteById", notes = "Obtiene un solo cliente de la Base de Datos por su Id")
	@GetMapping("/idCliente/{id}")
	public ResponseEntity<?> getClienteById(@PathVariable Long id){
		Cliente cliente = clientesImpl.clienteId(id);
		
		Map<String,Object> response = new HashMap<>();
		
		if(cliente == null) {
			response.put("mensaje", "El Id del empleado no existe");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity(cliente, HttpStatus.OK); 
	}
	
	@ApiOperation(value = "guardaCliente", notes = "Guarda un cliente en la BD")
	@PostMapping("/guardar")
	public ResponseEntity<?> guardaCliente(@RequestBody Cliente empleado ) {
			
		
		Map<String,Object> response = new HashMap<>();
		
		try {
			clientesImpl.guardaCliente(empleado);	
		}catch (Exception e) {
			response.put("mensaje", "Hubo un problema al guardar el cliente");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente se guardo con exito");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
		
	}
	
	@ApiOperation(value = "actualiza", notes = "Actualiza un cliente en la BD")
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualiza(@RequestBody Cliente cliente, @PathVariable Long id){
		
		Cliente clte = clientesImpl.clienteId(id);
		
		Map<String,Object> response = new HashMap<>();
		
		if(clte == null) {
			
			
			response.put("mensaje", "El Id del empleado no existe");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}else {
			try {
				
				clte.setNombre(cliente.getNombre());
				clte.setApellidoPat(cliente.getApellidoPat());
				clte.setApellidoMat(cliente.getApellidoMat());
				clte.setDireccion(cliente.getDireccion());
				clte.setTelefono(cliente.getTelefono());
				clte.setCorreo(cliente.getCorreo());
				
				clientesImpl.guardaCliente(clte);
				
			}catch (Exception e) {
				response.put("mensaje", "Hubo un problema al actualizar el cliente");
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put("mensaje", "El cliente se actualizo con exito");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}
		
	}
	
	@ApiOperation(value = "Eliminar", notes = "Elimina un cliente en la BD")
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Long id) {
		
		clientesImpl.Eliminar(id);
		
	}
	
	
}

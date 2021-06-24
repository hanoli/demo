package com.example.demo.services;

import java.util.List;
import com.example.demo.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> getLista();

	public Cliente clienteId(Long Id);
	
	public Cliente guardaCliente(Cliente empleado);
	
	public void Eliminar(Long id);
}

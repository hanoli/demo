package com.example.demo.servicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.IClienteDAO;
import com.example.demo.entity.Cliente;
import com.example.demo.services.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteDAO clientesDao;

	@Override
	public List<Cliente> getLista() {
		
		return (List<Cliente>) clientesDao.findAll();
	
	}

	
	@Override
	public Cliente clienteId(Long id) {
		 return clientesDao.findById(id).orElse(null);
	}


	@Override
	public Cliente guardaCliente(Cliente empleado) {
		return clientesDao.save(empleado);
	}


	@Override
	public void Eliminar(Long id) {
		 clientesDao.deleteById(id);
		
	}
	

}

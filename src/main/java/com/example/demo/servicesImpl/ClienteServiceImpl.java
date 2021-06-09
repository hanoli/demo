package com.example.demo.servicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.IEmpleadoDAO;
import com.example.demo.entity.Cliente;
import com.example.demo.services.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
	
	@Autowired
	private IEmpleadoDAO empleadosDao;

	@Override
	public List<Cliente> getLista() {
		
		return (List<Cliente>) empleadosDao.findAll();
	
	}

	
	@Override
	public Cliente empleadoId(Long id) {
		 return empleadosDao.findById(id).orElse(null);
	}


	@Override
	public Cliente guardaEmpleado(Cliente empleado) {
		return empleadosDao.save(empleado);
	}


	@Override
	public void Eliminar(Long id) {
		 empleadosDao.deleteById(id);
		
	}
	

}

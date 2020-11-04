package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.IEmpleadoDAO;
import com.example.demo.entity.Empleado;

@Service
public class IEmpleadoServiceImpl implements IEmpleadoService{
	
	@Autowired
	private IEmpleadoDAO empleadosDao;

	@Override
	public List<Empleado> getLista() {
		
		return (List<Empleado>) empleadosDao.findAll();
	
	}

	
	@Override
	public Empleado empleadoId(Long id) {
		 return empleadosDao.findById(id).orElse(null);
	}
	

}

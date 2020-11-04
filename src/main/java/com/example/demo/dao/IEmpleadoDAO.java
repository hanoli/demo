package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Empleado;

public interface IEmpleadoDAO extends CrudRepository<Empleado, Long>{
	

}

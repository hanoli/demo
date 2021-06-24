package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long>{
	

}

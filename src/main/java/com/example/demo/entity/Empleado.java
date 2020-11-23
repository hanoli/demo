package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 4629780573695595838L;
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	//Configuracion para Oracle
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CUST_SEQ")
	@SequenceGenerator(sequenceName = "empleado_seq", allocationSize = 1, name = "CUST_SEQ")
	private Long id;
	private String nombre;
	private String apellido;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	

}

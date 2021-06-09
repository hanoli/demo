package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="folios")
public class Folio implements Serializable{
	
	private static final long serialVersionUID = 4629780573695595838L;
	
	@Id
	//Configuracion para Oracle
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FOL_SEQ")
	@SequenceGenerator(name = "FOL_SEQ",sequenceName = "folio_seq",initialValue=1, allocationSize = 1 )
	private Long id;
	private String folio;
	
	
	private Date fecha;
	private String tipoEquipo;
	private String marca;
	private String modelo;
	private String numSerie;
	
	@JsonIgnoreProperties(value={"folios", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	public String getTipoEquipo() {
		return tipoEquipo;
	}
	public void setTipoEquipo(String tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
	
	
	
	

}

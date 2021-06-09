package com.example.demo.dto;

import java.util.Date;

public class FolioDTO {
	
	private String folio;
	private Date fecha;
	private String nombre;
	private Integer idTipoEquipo;
	private String marca;
	private String modelo;
	private String numSerie;
	
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getIdTipoEquipo() {
		return idTipoEquipo;
	}
	public void setIdTipoEquipo(Integer idTipoEquipo) {
		this.idTipoEquipo = idTipoEquipo;
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
	
	
	

}

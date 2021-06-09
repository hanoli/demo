package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.FolioDTO;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Folio;

public interface IFolioService {
	
	public List<Folio> getLista();

	public Folio folioId(Long Id);
	
	public Folio guardaFolio(Folio empleado);
	
	public void Eliminar(Long id);
}

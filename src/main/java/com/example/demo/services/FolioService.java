package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FolioDTO;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Folio;
import com.example.demo.entity.FoliosAprobados;
import com.example.demo.repository.FolioRepository;
import com.example.demo.repository.FoliosAprobadosRepository;

@Service
public class FolioService {
	
	@Autowired
    FolioRepository folioRepository;
	
	@Autowired
	FoliosAprobadosRepository foliosAprobadosRepository;
	
	public List<Folio> getLista(){
		return folioRepository.findAll();
	}

	
	public List<FoliosAprobados> getListaAprobados(){
		return foliosAprobadosRepository.findAll();
	}
	
	public Folio folioId(Long Id) {
		return folioRepository.findById(Id).orElse(null);
	}
	
	public Folio guardaFolio(Folio empleado) {
		return folioRepository.save(empleado);
	}
	
	public FoliosAprobados guardaFolioAprobado(FoliosAprobados folio) {
		return foliosAprobadosRepository.save(folio);
	}
	/*public Object Eliminar(Long id) {
		return folioRepository.deleteById(id);
	}*/
	
	public Integer getEndFolio() {
		return folioRepository.getEndFolio();
	}
	
	public List<Folio> getFolioByMarca(String marca){
		return folioRepository.getFoliByMarca(marca);
	}
	
	public List<Folio> getByFiltros(FolioDTO folioDTO){
		return folioRepository.getByFiltros(folioDTO);
	}

	/**
	 * @param id
	 */
	public void Eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}
}

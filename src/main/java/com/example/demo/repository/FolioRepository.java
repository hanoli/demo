package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Folio;
import com.example.demo.services.FolioServiceCustom;

public interface FolioRepository extends JpaRepository<Folio, Long>, FolioServiceCustom{
	
	@Query("SELECT MAX(f.folio) FROM Folio f")
	 Integer getEndFolio();
	
	
	@Query("SELECT f FROM Folio f where f.marca = ?1")
	 List<Folio> getFoliByMarca(String marca);
	
	

}

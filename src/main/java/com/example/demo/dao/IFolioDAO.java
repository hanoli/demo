package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Folio;

public interface IFolioDAO extends JpaRepository<Folio, Long>{
	
	/*@Query("SELECT F.folio,F.fecha,E.nombre,F.idTipoEquipo,F.marca,F.modelo,F.numSerie FROM Folio F INNER JOIN Empleado E ON F.empleado = E.id")
	public List<Folio> getDatos();*/
	

}

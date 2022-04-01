/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Folio;
import com.example.demo.entity.FoliosAprobados;
import com.example.demo.services.FolioServiceCustom;

/**
 * @author hanoli
 *
 */
public interface FoliosAprobadosRepository extends JpaRepository<FoliosAprobados, Long>{

}

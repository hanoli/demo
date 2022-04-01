/**
 * 
 */
package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.FolioDTO;
import com.example.demo.entity.Folio;

/**
 * @author hanoli
 *
 */
public interface FolioServiceCustom {
	
	public List<Folio> getByFiltros(FolioDTO folioDTO);
	
}

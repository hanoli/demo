/**
 * 
 */
package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.FolioDTO;
import com.example.demo.entity.Folio;
import com.example.demo.entity.Imagen;

/**
 * @author hanoli
 *
 */
public interface ImagenServiceCustom {
	
	public List<Imagen> getImagenByFolio(FolioDTO folioDTO);
	
}

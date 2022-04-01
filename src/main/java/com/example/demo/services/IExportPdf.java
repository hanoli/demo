/**
 * 
 */
package com.example.demo.services;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.example.demo.entity.Folio;
import com.example.demo.entity.Imagen;

/**
 * @author hanoli
 *
 */
public interface IExportPdf {
	
	public ByteArrayInputStream pdfReport(Folio idFolio,List<Imagen> imagen) ;

}

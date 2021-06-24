package com.example.demo.servicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.IClienteDAO;
import com.example.demo.dao.IFolioDAO;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Folio;
import com.example.demo.services.IClienteService;
import com.example.demo.services.IFolioService;

@Service
public class FolioServiceImpl implements IFolioService{
	
	@Autowired
	private IFolioDAO folioDAO;

	@Override
	public List<Folio> getLista() {
		
		return (List<Folio>) folioDAO.findAll();
	
	}

	
	@Override
	public Folio folioId(Long id) {
		 return folioDAO.findById(id).orElse(null);
	}


	@Override
	public Folio guardaFolio(Folio folio) {
		return folioDAO.save(folio);
	}


	@Override
	public void Eliminar(Long id) {
		folioDAO.deleteById(id);
		
	}
	

}

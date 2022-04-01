/**
 * 
 */
package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.FolioDTO;
import com.example.demo.entity.Folio;
import com.example.demo.services.FolioServiceCustom;

/**
 * @author hanoli
 *
 */
@Repository
public class FolioRepositoryImpl implements FolioServiceCustom {

	@PersistenceContext
    EntityManager em;
	
	@Override
	public List<Folio> getByFiltros(FolioDTO folioDTO) {
		String folio = folioDTO.getFolio();
		String tipoEquipo = folioDTO.getTipoEquipo();
        String marca = folioDTO.getMarca();
        String modelo = folioDTO.getModelo();
        Date fechaInicio = folioDTO.getFechaInicio();
        Date fechaFin = folioDTO.getFechaFin();

        System.out.println("folio in getByFiltros: " + folio);
        System.out.println("tipoEquipo in getByFiltros: " + tipoEquipo);
        System.out.println("marca in getByFiltros: " + marca);
        System.out.println("modelo in getByFiltros: " + modelo);
        System.out.println("fechaInicio in getByFiltros: " + fechaInicio);
        System.out.println("fechaFin in getByFiltros: " + fechaFin);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Folio> cq = cb.createQuery(Folio.class);
        Root<Folio> data = cq.from(Folio.class);
        List<Predicate> predicates = new ArrayList<>();

        if (folio != null) {
             predicates.add(cb.equal(data.get("folio"), folio));
        }
        if (tipoEquipo != null) {
            predicates.add(cb.equal(data.get("tipoEquipo"), tipoEquipo));
        }
        
        if (marca != null) {
            predicates.add(cb.equal(data.get("marca"), marca));
       }
       if (modelo != null) {
           predicates.add(cb.equal(data.get("modelo"), modelo));
       }
        
        if (fechaInicio != null || fechaFin != null ) {
            predicates.add(cb.between(data.get("fecha"), fechaInicio, fechaFin));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();
	}

}

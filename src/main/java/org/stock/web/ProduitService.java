package org.stock.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stock.entities.Produit;
import org.stock.repository.ProduitRepository;

@RestController
@RequestMapping("/produit")
public class ProduitService extends GenericServices<Produit,Long>{
	@Autowired
	private ProduitRepository produitRepository;

	@Override
	public JpaRepository<Produit,Long> getRepository() {
		
		return produitRepository;
	}
	
	
	
}

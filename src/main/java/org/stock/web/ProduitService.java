package org.stock.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.stock.entities.Produit;
import org.stock.repository.ProduitRepository;

@RestController
@RequestMapping("/produit")
public class ProduitService {
	@Autowired
	private ProduitRepository produitRepository;
	
	
	@GetMapping(value="getAll")
	public  ResponseEntity<Object>  getproducts(){
		return new ResponseEntity<Object>(produitRepository.findAll(),HttpStatus.OK);
	}

	@GetMapping(value="/getByRef/{ref}")
	public ResponseEntity<Object> getContacts(@PathVariable Long ref){
		return new ResponseEntity<Object>(produitRepository.findOne(ref),HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@RequestBody Produit p){
		return new ResponseEntity<Object>(produitRepository.save(p),HttpStatus.OK);
	}


	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Object> supprimer(@PathVariable Long id){
			return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Object> save(@PathVariable Long ref,@RequestBody Produit p){
		p.setRef(ref);
		return new ResponseEntity<Object>(produitRepository.save(p),HttpStatus.OK);
	}

	
	
	
}

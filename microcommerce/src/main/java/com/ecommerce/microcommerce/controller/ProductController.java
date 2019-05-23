package com.ecommerce.microcommerce.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class ProductController {

	@Autowired
	private ProductDao productDao;

	@GetMapping(value = "produits")
	public MappingJacksonValue listProduits() {

		List<Product> produits = productDao.findAll();

		SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prix_achat");

		FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

		MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);

		produitsFiltres.setFilters(listDeNosFiltres);

		return produitsFiltres;
	}

	@GetMapping(value = "produit/{id}")
	public Product afficherProduit(@PathVariable int id) {
		return productDao.findById(id);
	}

	@PostMapping(value = "produits")
	public ResponseEntity<Void> ajouterProduit(@RequestBody Product product) {

		Product productAdded = productDao.save(product);
		if (productAdded == null) {
			return ResponseEntity.noContent().build();
		} else {

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(productAdded.getId()).toUri();

			return ResponseEntity.created(location).build();
		}
	}

	@GetMapping(value = "produits/{prixLimit}")
	public List<Product> findByPrixGreaterThan(@PathVariable int prixLimit) {
		return productDao.findByPrixGreaterThan(prixLimit);
	}

}

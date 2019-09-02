package com.example.prueba.controller;

import com.example.prueba.model.*;
import com.example.prueba.repo.*;
import com.example.prueba.exception.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductRestController {
	
	@Autowired
	private ProductRepository repo;
	
	ProductRestController(ProductRepository repo){
		this.repo = repo;
	}
	  
	// Raiz
	@GetMapping("/products")
	List<Product> all() {
		return repo.findAll();
		}
	
	// Items individuales

	@GetMapping("/products/{id}")
	Product one(@PathVariable int id) {
		return repo.findById(id)
				.orElseThrow(() -> new ProductNotFoundException(id));
		}
}

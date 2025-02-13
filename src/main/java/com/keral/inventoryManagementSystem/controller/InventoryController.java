package com.keral.inventoryManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.keral.inventoryManagementSystem.model.Product;
import com.keral.inventoryManagementSystem.service.InventoryManagementService;

import java.util.List;

@RestController
@RequestMapping("/inventory") 
public class InventoryController {

	@Autowired
	private InventoryManagementService inService;

	@PostMapping("/save")
	public ResponseEntity<Product> addProduct(@RequestBody Product p) {
		Product savedProduct = inService.save(p);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}



	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = inService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	// other


}

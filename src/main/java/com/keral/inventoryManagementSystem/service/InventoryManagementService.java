package com.keral.inventoryManagementSystem.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keral.inventoryManagementSystem.model.Product;
import com.keral.inventoryManagementSystem.repository.InventoryRepo;


@Service
public class InventoryManagementService {

	private final InventoryRepo repo;

	@Autowired
	public InventoryManagementService(InventoryRepo repo) {
		this.repo = repo;
	}

	public Product save(Product p) {
		return repo.save(p);
	}

	public List<Product> getAllProducts() {
		return repo.findAll(); 
	}
	
	public Product productById(Long id) {
		return repo.findById(id).get();
		
	}
	
	public void deleteById(long id) {
		repo.deleteById(id);
	}
	
	 public Product updateProduct(Long id, Product product) {
	        Optional<Product> existingUser = repo.findById(id);
	        if (existingUser.isPresent()) {
	            product.setProduct_id(id);
	            return repo.save(product);
	        }
	        return null;
	    }
}

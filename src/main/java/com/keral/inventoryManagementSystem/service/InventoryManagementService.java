package com.keral.inventoryManagementSystem.service;

import java.util.List;

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
		return repo.findAll(); // Tüm ürünleri çekmek için JpaRepository'nin sağladığı metodu kullanıyoruz.
	}
}

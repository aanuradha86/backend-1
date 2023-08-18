package com.keral.inventoryManagementSystem.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keral.inventoryManagementSystem.model.Sale;
import com.keral.inventoryManagementSystem.repository.SalesRepo;
@Service
public class SalesManagementService {
	
	
		private final SalesRepo repo;

		@Autowired
		public SalesManagementService(SalesRepo repo) {
			this.repo = repo;
		}
		public Sale save(Sale sale) {
	        return repo.save(sale);
	    }

	    public List<Sale> getAllSales() {
	        return repo.findAll(); 
	    }

	    public Sale getSaleById(Long id) {
	        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("Sale with ID " + id + " not found"));
	    }

	    public void deleteSaleById(long id) {
	        repo.deleteById(id);
	    }

	    public Sale updateSale(Long id, Sale sale) {
	        Optional<Sale> existingSale = repo.findById(id);
	        if (existingSale.isPresent()) {
	        	sale.setSale_id(id);
	            return repo.save(sale);
	        }
	        throw new NoSuchElementException("Sale with ID " + id + " not found");
	    }
	}


package com.ecommerce.microcommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.ecommerce.microcommerce.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

	Product findById(int id);
	List<Product> findByPrixGreaterThan(int prixLimit);
}

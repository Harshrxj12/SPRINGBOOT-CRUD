package com.app.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.product.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}

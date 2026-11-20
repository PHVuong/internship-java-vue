package com.vingapfc.superapp.productservice.repository;


import com.vingapfc.superapp.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
package com.devjoliveira.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devjoliveira.demo.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

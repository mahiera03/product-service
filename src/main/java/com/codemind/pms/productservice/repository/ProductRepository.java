package com.codemind.pms.productservice.repository;

import com.codemind.pms.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {



}

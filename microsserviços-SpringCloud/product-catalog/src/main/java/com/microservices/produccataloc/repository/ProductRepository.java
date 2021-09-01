package com.microservices.produccataloc.repository;

import com.microservices.produccataloc.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}

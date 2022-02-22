package com.dt.ducthuygreen.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.dt.ducthuygreen.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

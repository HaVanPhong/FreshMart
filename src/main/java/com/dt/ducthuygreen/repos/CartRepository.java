package com.dt.ducthuygreen.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dt.ducthuygreen.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}

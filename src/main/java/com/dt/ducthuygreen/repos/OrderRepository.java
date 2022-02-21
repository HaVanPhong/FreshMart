package com.dt.ducthuygreen.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dt.ducthuygreen.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}

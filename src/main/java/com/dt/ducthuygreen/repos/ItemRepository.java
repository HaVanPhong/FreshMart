package com.dt.ducthuygreen.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dt.ducthuygreen.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}

package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {
	
}

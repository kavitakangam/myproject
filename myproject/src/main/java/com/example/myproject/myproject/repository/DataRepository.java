package com.example.myproject.myproject.repository;

import org.springframework.stereotype.Repository;

import com.example.myproject.myproject.domain.Data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface DataRepository  extends MongoRepository<Data, String> {
	List<Data> findByStock(String stock);
}

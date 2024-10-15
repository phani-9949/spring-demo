package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Product;
import com.example.demo.repository.repository;

@org.springframework.stereotype.Service
public class Service {
	
	
	@Autowired
	private repository repo;
	
	public void insertproduct(Product pro)
	{
		repo.save(pro);
	}
	
	public List<Product> getAllProduct()

	{
		return repo.findAll();
	}
	
	public Product getproductByid(Long id)
	{
		return repo.findById(id).get();
	}
	
	public void deleteproduct(Long id)
	{
		repo.deleteById(id);
	}

}

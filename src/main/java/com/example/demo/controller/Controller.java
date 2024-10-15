package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.Service;


@RestController
@RequestMapping("/curd/Products")

public class Controller {
	
	
	@Autowired
	Service service;
	
	@PostMapping 
	public ResponseEntity<Product> addProducr(@RequestBody Product pro)
	{
		service.insertproduct(pro);
		return new ResponseEntity<>(pro,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProduct()
	{
		return new ResponseEntity<>(service.getAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductByid(@PathVariable Long id)
	{
		return new ResponseEntity<>(service.getproductByid(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateCar(@PathVariable Long id, @RequestBody Product pros){
		service.insertproduct(pros);
		return new ResponseEntity<>(pros, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCar(@PathVariable Long id){
		service.deleteproduct(id);
		return new ResponseEntity<>("deleted Successfully", HttpStatus.OK);
	}
	

}

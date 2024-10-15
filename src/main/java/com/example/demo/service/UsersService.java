package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UsersService {
	
	@Autowired
	private UserRepository repo;
	
	public void registerUser(Users user)
	{
		 repo.save(user);
	}
	
	public List<Users> getAllUsers()
	
	{
		List<Users> response=repo.findAll();		
				return  response;
		
	}

}

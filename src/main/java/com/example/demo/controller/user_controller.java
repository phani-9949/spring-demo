package com.example.demo.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Users;
import com.example.demo.service.UsersService;




@Controller
@RequestMapping("/app")
public class user_controller {
	
	@Autowired
	private UsersService userservice;
	
	@GetMapping("/home")
	public String home(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
		return "home";
	}
	
	@GetMapping("/reg")
	public String showReg(Model model) {
		model.addAttribute("user", new Users());
		return "user";
	}
	
	@PostMapping("/reg")
	public String register( @ModelAttribute Users user, Model model) {
		userservice.registerUser(user);
		return "redirect:/home";
	}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("user", new Users());
		return "home";
	}
	
	@GetMapping("/users")
	public String showUsers(Model model)
	{
		List<Users> user=userservice.getAllUsers() ;
		model.addAttribute("users",user);
		return "listofusers";
	}
}

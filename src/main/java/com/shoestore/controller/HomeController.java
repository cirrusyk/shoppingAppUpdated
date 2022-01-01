package com.shoestore.controller;



import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoestore.domain.Shoes;
import com.shoestore.domain.User;
import com.shoestore.service.ShoesService;
import com.shoestore.service.UserService;



@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private ShoesService shoesService;
	
	@RequestMapping("/login")
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	
	
	@RequestMapping(value="/log", method=RequestMethod.POST)
	public String addUserPost(
			@ModelAttribute("user") User user, HttpServletRequest request
			) {
		
		userService.save(user);
		return "redirect:profile";
		
	}
		
		
	@RequestMapping("/profile")
	public String profile(Model model) {
		List<User> userList = userService.findAll(); 
		
		model.addAttribute("user", userList);
		
		return "profile";
		
		
	}
		
		
		
	
	
	
	
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	
	@RequestMapping("/newReleases")
	public String newReleases(Model model) {
		List<Shoes> shoesList = shoesService.findAll();
		model.addAttribute("shoesList", shoesList);
		
		
		return "newReleases";
	}
	
	
	
	@RequestMapping("/productPage")
	public String productPage(
			@PathParam("id") Long id, Model model, Principal principal
			
			) {
		
		if(principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
			
		} 
		
		Shoes shoes = shoesService.findOne(id);
		
		model.addAttribute("shoes", shoes);
		
		List<Integer> qtyList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		model.addAttribute("qtyList", qtyList);
		model.addAttribute("qty", 1);
		
		
		return "productPage";
		
	}
	
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	
	@RequestMapping("/trackOrdersUser")
	public String trackOrdersUser() {
		return "trackOrdersUser";
	}
	
	
	
	
	
	@RequestMapping("/payment")
	public String payment() {
		return "payment";
	}
	
	@RequestMapping("/confirmPayment")
	public String  confirmPayment() {
		return "confirmPayment";
	}
	
	@RequestMapping("/cart")
	public String  cart() {
		return "cart";
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("/runningShoes")
	public String runningShoes() {
		return "runningShoes";
	}
	
	@RequestMapping("/skateShoes")
	public String skateShoes() {
		return "skateShoes";
	}
	
	@RequestMapping("/basketBallShoes")
	public String basketBallShoes() {
		return "basketBallShoes";
	}
	
	
	
	
	
	
	
	
	
	
}

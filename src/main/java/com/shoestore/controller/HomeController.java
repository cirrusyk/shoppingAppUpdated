package com.shoestore.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shoestore.domain.User;
import com.shoestore.repository.UserRepository;



@Controller
public class HomeController {
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/login")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	     
	    return "login";
	}
	
	
	
	@PostMapping ("/process_register")
	 public String processingUserRegistration(User user,  RedirectAttributes redirAttrs) {
		
		   
		 repository.save(user);
		 redirAttrs.addFlashAttribute("You have registered successfully");
		 return "profile";
	 }
	
	
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	
	@RequestMapping("/newReleases")
	public String newReleases() {
		return "newReleases";
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
	
	
	
	@RequestMapping("/productPage")
	public String productPage() {
		return "productPage";
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
	
	@RequestMapping("/manageUsers")
	public String  manageUsers() {
		return "manageUsers";
	}
	
	@RequestMapping("/manageOrders")
	public String  manageOrders() {
		return "manageOrders";
	}
	
	@RequestMapping("/manageProducts")
	public String  manageProducts() {
		return "manageProducts";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct() {
		return "addProduct";
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
	
	@RequestMapping("/profile")
	public String profile() {
		return "profile";
	}
	
	
	
	
	
	
	
	
	
	
}

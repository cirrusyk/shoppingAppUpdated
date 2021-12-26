package com.shoestore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	
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
	
	@RequestMapping("/profile")
	public String profile() {
		return "profile";
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
	
	
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("classActiveLogin", true);
		return "loginRegistration";
	}
	
	@RequestMapping("/newUser")
	public String newUser(Model model) {
		model.addAttribute("classActiveNewUser", true);
		return "loginRegistration";
	}
	
	
}

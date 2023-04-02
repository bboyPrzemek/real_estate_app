package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
	
	@GetMapping(path =  "/new-estate/categories")
	public String categories() {
		return "category";
	}

}

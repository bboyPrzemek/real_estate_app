package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuccessController {
	
	@GetMapping(path = { "/success" })
	public String newEstate() {
		return "success";
	}

}

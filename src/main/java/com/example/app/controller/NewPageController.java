package com.example.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.formData.CreateFormData;
import com.example.app.service.FlatService;

@Controller
public class NewPageController {

	@Autowired
	FlatService flatService;

	@GetMapping(path =  "/new-estate/{estateType}")
	public String newEstate(@ModelAttribute ("formData") CreateFormData formData, @PathVariable(value= "estateType") String estateType) {
		return "new";
	}

	@RequestMapping(path = "/new-estate/{estateType}" , method = RequestMethod.POST)
	public String create(
			@ModelAttribute ("formData") @Valid CreateFormData formData, 
			BindingResult theBindingResult,
			@PathVariable(value= "estateType") String estateType) {

		if (!theBindingResult.hasErrors()) {
			flatService.create(formData);
			return "success";
		}else {
			return "new";
		}
	}
}

package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Address;
import com.example.app.repository.AddressRepository;

@RestController
public class AddressController {
	
	@Autowired
	private AddressRepository aRepository;
	
	@GetMapping("/location/search/{searchText}")
	public List<Address> searchLocation(@PathVariable String  searchText){
		System.out.println(searchText);
		List<Address> al = aRepository.searchLocation(searchText);
		System.out.println(al.size());
		return al;
	}

}

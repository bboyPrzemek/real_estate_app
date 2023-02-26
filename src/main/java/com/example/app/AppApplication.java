package com.example.app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import com.example.app.model.Estate;
import com.example.app.model.Flat;
import com.example.app.model.House;
import com.example.app.model.User;
import com.example.app.repository.EstateRepository;
import com.example.app.repository.FlatRepository;
import com.example.app.repository.HouseRepository;
import com.example.app.repository.UserRepository;

@SpringBootApplication
public class AppApplication{

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		
	}
	


}

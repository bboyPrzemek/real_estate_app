package com.example.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<Estate> estates;
}

package com.example.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String city;
	private String street;
	private String province;
	
	@OneToMany(mappedBy="address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Estate> estates;
}

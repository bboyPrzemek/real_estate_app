package com.example.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Estate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String name;
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="userId", nullable = false)
	private User user;
	
	
	@OneToMany(mappedBy="estate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Image> images;
	private double price;
	private double size;
}

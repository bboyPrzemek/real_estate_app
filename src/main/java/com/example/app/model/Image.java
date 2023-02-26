package com.example.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Image {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String url;
	
	@Column(nullable = false)
	private Boolean isPrimary;
	@ManyToOne
    @JoinColumn(name ="estateId", nullable = false)
	private Estate estate;
	
	
	
}

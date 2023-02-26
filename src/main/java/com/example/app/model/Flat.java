package com.example.app.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.NoArgsConstructor;

@Entity
@PrimaryKeyJoinColumn(name="houseId")
@NoArgsConstructor
public class Flat extends Home{
	private int floor;
}

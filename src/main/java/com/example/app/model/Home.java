package com.example.app.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="homeId")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Home extends Estate {
	private int rooms;
	private Boolean garage;
	private Boolean balcony;
	@Enumerated
	private MarketType marketType;
}

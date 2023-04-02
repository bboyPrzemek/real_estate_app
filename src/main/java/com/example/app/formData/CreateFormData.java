package com.example.app.formData;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateFormData {

	@NotBlank(message = "Tytuł ogłoszenia nie może być pusty.")
	private String name;
	@NotBlank(message = "Podaj lokalizację.")
	private String location;
	private String locationName;
	@NotBlank(message = "Podaj cenę nieruchomości.")
	private String price;
	@NotBlank(message = "Podaj wielkość nieruchomości.")
	private String size;
	private String rooms;
	private String floor;
	private String marketType;
	private String buildingType;
	private String offerType;
	private String estateType;
	private Boolean garage;
	private String description;
	private String address;
}

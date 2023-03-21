package com.example.app.formData;

import org.springframework.stereotype.Component;

import com.example.app.model.OfferType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class FormData {
	 private String keywords;
	 private String location;
	 private String priceFrom;
	 private String priceTo;
	 private String areaFrom;
	 private String areaTo;
	 private String rooms;
	 private String floor;
	 private String marketType;
	 private String buildingType;
	 private String offerType;
	 
	 
	 @Override
	 public String toString() {
		 return "FormData [keywords=" + keywords + ", location=" + location + ", priceFrom=" + priceFrom + ", priceTo=" + priceTo
				 + ", areaFrom=" + areaFrom + ", areaTo=" + areaTo + ", rooms=" + rooms + ", floor=" + floor
				 + ", market=" + marketType + ", buildingType=" + buildingType + ", offerType=" + offerType + "]";
	 }
	
}





package com.example.app.formData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class FlatFormData {
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
	 
	@Autowired
	public FlatFormData(FormData baseSearchFormDto) {
		this.keywords = baseSearchFormDto.getKeywords();
		this.location = baseSearchFormDto.getLocation();
		this.priceFrom = baseSearchFormDto.getPriceFrom();
		this.priceTo = baseSearchFormDto.getPriceTo();
		this.areaFrom = baseSearchFormDto.getAreaFrom();
		this.areaTo = baseSearchFormDto.getAreaTo();
		this.rooms = baseSearchFormDto.getRooms();
		this.floor = baseSearchFormDto.getFloor();
		this.marketType = baseSearchFormDto.getMarketType();
		this.buildingType = baseSearchFormDto.getBuildingType();
		this.offerType = baseSearchFormDto.getOfferType();
	}

	@Override
	public String toString() {
		return "FlatFormData [keywords=" + keywords + ", location=" + location + ", priceFrom=" + priceFrom + ", priceTo="
				+ priceTo + ", areaFrom=" + areaFrom + ", areaTo=" + areaTo + ", rooms=" + rooms + ", floor=" + floor
				+ ", marketType=" + marketType + ", buildingType=" + buildingType + "]";
	}
	
	
}

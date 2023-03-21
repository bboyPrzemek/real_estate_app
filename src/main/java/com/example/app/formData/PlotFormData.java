package com.example.app.formData;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlotFormData{
	 private String keywords;
	 private String location;
	 private String priceFrom;
	 private String priceTo;
	 private String areaFrom;
	 private String areaTo;
	 
	public PlotFormData(FormData baseSearchFormDto) {
		this.keywords = baseSearchFormDto.getKeywords();
		this.location = baseSearchFormDto.getLocation();
		this.priceFrom = baseSearchFormDto.getPriceFrom();
		this.priceTo = baseSearchFormDto.getPriceTo();
		this.areaFrom = baseSearchFormDto.getAreaFrom();
		this.areaTo = baseSearchFormDto.getAreaTo();
	}
}

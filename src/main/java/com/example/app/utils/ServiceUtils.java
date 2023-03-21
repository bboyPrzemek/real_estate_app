package com.example.app.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.example.app.model.Image;

public class ServiceUtils {
	
	public static List<Image> getImages(List<Image> images, Long Id) {
		return images.stream()
				.filter(i -> i.getEstate().getId() == Id)
				.sorted((i1, i2) -> Boolean.compare(i2.getIsPrimary(),i1.getIsPrimary()))
				.collect(Collectors.toList());
	}

}

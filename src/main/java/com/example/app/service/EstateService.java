package com.example.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.app.model.Estate;
import com.example.app.model.Image;
import com.example.app.repository.EstateRepository;
import com.example.app.repository.ImageRepository;

@Service
public class EstateService {
	
	private static final int PAGE_SIZE = 10;
	
	@Autowired
	private EstateRepository estateRepository;
	@Autowired
	private ImageRepository imageRepository;
	
	public List<Estate> getEstates(int page) {
		
		List<Estate> estates =  estateRepository.findAll(PageRequest.of(page, PAGE_SIZE)).getContent();	
		List<Long> ids = estates.stream()
				.map(e -> e.getId())
				.collect(Collectors.toList());

		List<Image> images = imageRepository.findImagesByEstateIds(ids);
		estates.stream().forEach(e -> e.setImages(getImages(images, e.getId())));
		return estates;
	}
	
	private List<Image> getImages(List<Image> images, Long Id) {
		return images.stream()
				.filter(i -> i.getEstate().getId() == Id)
				.sorted((i1, i2) -> Boolean.compare(i2.getIsPrimary(),i1.getIsPrimary()))
				.collect(Collectors.toList());
	}

}

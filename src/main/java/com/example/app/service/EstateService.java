package com.example.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.app.model.Estate;
import com.example.app.model.Image;
import com.example.app.repository.EstateRepository;
import com.example.app.repository.ImageRepository;
import com.example.app.utils.ServiceUtils;

@Service
public class EstateService {
	
	private static final int PAGE_SIZE = 24;
	
	@Autowired
	private EstateRepository estateRepository;
	@Autowired
	private ImageRepository imageRepository;
	
	public Page<Estate> getEstates(Integer page) {
		page = (page == null || page <= 0) ? 0 : page - 1;
		Page<Estate> estates =  estateRepository.findAll(PageRequest.of(page, PAGE_SIZE));	
		
		List<Long> ids = estates.getContent().stream()
				.map(e -> e.getId())
				.collect(Collectors.toList());

		List<Image> images = imageRepository.findImagesByEstateIds(ids);
		estates.getContent().stream().forEach(e -> e.setImages(ServiceUtils.getImages(images, e.getId())));
		
		return estates;
	}
	
	

}

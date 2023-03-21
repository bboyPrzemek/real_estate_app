package com.example.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.app.formData.FlatFormData;
import com.example.app.formData.FormData;
import com.example.app.formData.FormServiceInterface;
import com.example.app.model.Address;
import com.example.app.model.Flat;
import com.example.app.model.Image;
import com.example.app.model.MarketType;
import com.example.app.model.OfferType;
import com.example.app.repository.FlatRepository;
import com.example.app.repository.ImageRepository;
import com.example.app.utils.ServiceUtils;

@Service
public class FlatService implements FormServiceInterface {

	@Autowired
	private FlatRepository flatRepository;
	@Autowired
	private ImageRepository imageRepository;
	private int PAGE_SIZE = 12;

	public Page<Flat> search(FormData formData, Integer page) {
		FlatFormData fFormData = new FlatFormData(formData);
		page = (page == null || page <= 0) ? 0 : page - 1;

		Page<Flat> flats = flatRepository.findAll(new Specification<Flat>() {
			@Override
			public Predicate toPredicate(Root<Flat> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();

				if (fFormData.getKeywords() != null) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.or(criteriaBuilder.like(root.get("name"), fFormData.getKeywords()),
									criteriaBuilder.like(root.get("description"), fFormData.getKeywords()))));
				}
				if (fFormData.getPriceFrom() != null) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), fFormData.getPriceFrom())));
				}
				if (fFormData.getPriceTo() != null) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.lessThanOrEqualTo(root.get("price"), fFormData.getPriceTo())));
				}
				if (fFormData.getAreaFrom() != null) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.greaterThanOrEqualTo(root.get("size"), fFormData.getAreaFrom())));
				}
				if (fFormData.getAreaTo() != null) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.lessThanOrEqualTo(root.get("size"), fFormData.getAreaTo())));
				}
				if (fFormData.getOfferType() != null) {
					predicates.add(criteriaBuilder.and(
							criteriaBuilder.equal(root.get("offerType"), OfferType.valueOf(fFormData.getOfferType()))));
				}
				if (fFormData.getMarketType() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("marketType"),
							MarketType.valueOf(fFormData.getMarketType()))));
				}
				if (fFormData.getFloor() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("floor"), fFormData.getFloor())));
				}
				if (fFormData.getRooms() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("rooms"), fFormData.getRooms())));
				}

				Join<Address, Flat> flatAddress = currentQueryIsCountRecords(query) ? root.join("address") : (Join) root.fetch("address", JoinType.INNER);

				if (fFormData.getLocation() != null) {
					predicates.add(criteriaBuilder.and(
							criteriaBuilder.or(criteriaBuilder.like(flatAddress.get("city"), fFormData.getLocation()),
									criteriaBuilder.like(flatAddress.get("province"), fFormData.getLocation()),
									criteriaBuilder.like(flatAddress.get("street"), fFormData.getLocation()))));
				}

				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}, PageRequest.of(page, PAGE_SIZE));

		List<Long> ids = flats.getContent().stream().map(e -> e.getId()).collect(Collectors.toList());

		List<Image> images = imageRepository.findImagesByEstateIds(ids);
		flats.getContent().stream().forEach(e -> e.setImages(ServiceUtils.getImages(images, e.getId())));

		return flats;
	}

	private boolean currentQueryIsCountRecords(CriteriaQuery<?> criteriaQuery) {
		return criteriaQuery.getResultType() == Long.class || criteriaQuery.getResultType() == long.class;
	}

}

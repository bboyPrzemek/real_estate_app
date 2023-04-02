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

import com.example.app.formData.CreateFormData;
import com.example.app.formData.FormServiceInterface;
import com.example.app.formData.SearchFormData;
import com.example.app.model.Address;
import com.example.app.model.EstateType;
import com.example.app.model.Flat;
import com.example.app.model.Image;
import com.example.app.model.MarketType;
import com.example.app.model.OfferType;
import com.example.app.model.User;
import com.example.app.repository.AddressRepository;
import com.example.app.repository.FlatRepository;
import com.example.app.repository.ImageRepository;
import com.example.app.repository.UserRepository;
import com.example.app.utils.ServiceUtils;

@Service
public class FlatService implements FormServiceInterface {

	@Autowired
	private FlatRepository flatRepository;
	@Autowired
	private UserRepository uRepository;
	@Autowired
	private AddressRepository aRepository;
	@Autowired
	private ImageRepository imageRepository;
	private int PAGE_SIZE = 12;

	public Page<Flat> search(SearchFormData formData, Integer page) {
		page = (page == null || page <= 0) ? 0 : page - 1;

		Page<Flat> flats = flatRepository.findAll(new Specification<Flat>() {
			@Override
			public Predicate toPredicate(Root<Flat> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();

				if (formData.getName() != null) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.or(criteriaBuilder.like(root.get("name"), "%" + formData.getName() + "%"),
									criteriaBuilder.like(root.get("description"),"%" + formData.getName() + "%"))));
				}
				if (formData.getPriceFrom() != null) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), formData.getPriceFrom())));
				}
				if (formData.getPriceTo() != null) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.lessThanOrEqualTo(root.get("price"), formData.getPriceTo())));
				}
				if (formData.getAreaFrom() != null) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.greaterThanOrEqualTo(root.get("size"), formData.getAreaFrom())));
				}
				if (formData.getAreaTo() != null) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.lessThanOrEqualTo(root.get("size"), formData.getAreaTo())));
				}
				if (formData.getOfferType() != null) {
					predicates.add(criteriaBuilder.and(
							criteriaBuilder.equal(root.get("offerType"), OfferType.valueOf(formData.getOfferType()))));
				}
				if (formData.getMarketType() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("marketType"),
							MarketType.valueOf(formData.getMarketType()))));
				}
				if (formData.getFloor() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("floor"), formData.getFloor())));
				}
				if (formData.getRooms() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("rooms"), formData.getRooms())));
				}

				Join<Address, Flat> flatAddress = currentQueryIsCountRecords(query) ? root.join("address") : (Join) root.fetch("address", JoinType.INNER);

				if (formData.getLocation() != null) {
					predicates.add(criteriaBuilder.and(
							criteriaBuilder.or(criteriaBuilder.like(flatAddress.get("city"), formData.getLocation()),
									criteriaBuilder.like(flatAddress.get("province"), formData.getLocation()),
									criteriaBuilder.like(flatAddress.get("street"), formData.getLocation()))));
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

	@Override
	public Boolean create(CreateFormData formData) {
		
		Address address = aRepository.findById(Long.valueOf(formData.getLocation())).get();
		
		User user = uRepository.findById(3L).get();		
		Flat flat  = new Flat();
		flat.setEstateType(EstateType.valueOf(formData.getEstateType()));
		flat.setOfferType(OfferType.valueOf(formData.getOfferType()));
		flat.setName(formData.getName());
		flat.setDescription(formData.getDescription());
		flat.setAddress(address);
		flat.setUser(user);
		flatRepository.save(flat);
		
		
		return null;
	}

}

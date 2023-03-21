package com.example.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.formData.FormData;
import com.example.app.model.Address;
import com.example.app.model.Estate;
import com.example.app.model.Flat;
import com.example.app.model.Image;
import com.example.app.model.MarketType;
import com.example.app.model.OfferType;
import com.example.app.model.User;
import com.example.app.repository.AddressRepository;
import com.example.app.repository.FlatRepository;
import com.example.app.repository.ImageRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.EstateService;
import com.example.app.service.FlatService;

@Controller
public class IndexPageController implements CommandLineRunner{
	
	@Autowired
	private EstateService eService;
	
	@Autowired
	private FlatService flatService;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FlatRepository flatRepository;
	@Autowired
	private ImageRepository iRepository;
	
	@Autowired
	private AddressRepository aRepository;
	
	//FormServiceInterface formServiceInterface;
	
	@GetMapping(path = {"/"})
	public String getEstates(@RequestParam( required = false, value = "page") Integer page, @ModelAttribute FormData formDTO, Model model) {
		Page<Estate> data = eService.getEstates(page);
		model.addAttribute("data", data);
		return "index";
	}
	
	@GetMapping(path = "/search/{offerType}/{estateType}")
	public String searchEstates(@RequestParam( required = false, value = "page") Integer page,
			@ModelAttribute FormData baseSearchFormDto, 
			@PathVariable("offerType") String offerType, 
			@PathVariable("estateType") 
			String estateType,
			Model model) {
		
		
		Page<Estate> estates = (Page<Estate>)(Page<?>) flatService.search(baseSearchFormDto, page);
		model.addAttribute("data", estates);
		return "index";
	}
	
	



	@Override
	public void run(String... args) throws Exception {
//	
//		Address address = new Address();
//		address.setCity("Koszalin");
//		address.setProvince("zachodniopomorskie");
//		address.setStreet("Zwyciestwa");
//		aRepository.save(address);
//		
//		for (int j = 0; j < 30; j++) {
//			
//	
//		
//
//		User user = new User();
//		user.setFirstName("Janusz");
//		user.setLastName("Mniamek");
//		userRepository.save(user);
//		
//		Flat f = new Flat();
//		f.setUser(user);
//		f.setOfferType(OfferType.sell);
//		f.setAddress(address);
//		f.setPrice(1200);
//		f.setBalcony(false);
//		f.setMarketType(MarketType.secondary);
//		flatRepository.save(f);
//		
//		
//		List<Image> imageList = new ArrayList<>();
//		
//		
//		for (int i=1; i <= 5; i++ ) {
//			Image im = new Image();
//			if (i== 1) {
//				im.setIsPrimary(true);
//			}else {
//				im.setIsPrimary(false);
//			}
//			im.setUrl("/estates/house" + i + ".webp");
//			im.setEstate(f);
//			imageList.add(im);
//		}
//		iRepository.saveAll(imageList);
//		
//	
//		}
//		
	}

}

package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.app.dao.PaginationDto;
import com.example.app.model.Estate;
import com.example.app.repository.FlatRepository;
import com.example.app.repository.ImageRepository;
import com.example.app.repository.UserRepository;
import com.example.app.service.EstateService;

@Controller
public class IndexPageController implements CommandLineRunner{
	
	@Autowired
	private EstateService eService;
	@Autowired
	private FlatRepository flatRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ImageRepository iRepository;
	
	
	@GetMapping(path = {"/", "/{page}"})
	public String getEstates(@PathVariable(required = false, value = "page") Integer page, Model model) {
		PaginationDto<Estate> dao = eService.getEstates(page);
		model.addAttribute("estates", dao);
		return "index";
	}




	@Override
	public void run(String... args) throws Exception {
		
		
//		for (int j = 0; j < 30; j++) {
//
//		User user = new User();
//		user.setFirstName("Przemek");
//		user.setLastName("Kozibroda");
//		userRepository.save(user);
//		
//		Flat f = new Flat();
//		f.setUser(user);
//		f.setPrice(20000);
//		f.setBalcony(true);
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
	}

}

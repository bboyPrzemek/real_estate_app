package app.example.com.mapper;

import com.example.app.formData.CreateFormData;
import com.example.app.model.EstateType;
import com.example.app.model.Flat;
import com.example.app.model.MarketType;
import com.example.app.model.OfferType;

public class FormToFlatMapper {
	
	public static Flat toFlat(CreateFormData form) {
		Flat flat = new Flat();
		
		flat.setName(form.getName());
		flat.setDescription(form.getDescription());
		flat.setEstateType(EstateType.valueOf(form.getEstateType()));
		flat.setMarketType(MarketType.valueOf(form.getMarketType()));
		flat.setOfferType(OfferType.valueOf(form.getOfferType()));
		flat.setPrice(Double.valueOf(form.getPrice()));
		flat.setSize(Double.valueOf(form.getSize()));
		
		
		
		return flat;
	}

}

package com.mobileapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public class MobileServiceImpl implements IMobileService {

	public Mobile getById(int mobileId) throws MobileNotFoundException {

//		return showMobiles().stream().filter(mobile -> mobile.getMobileId() == mobileId).findAny().orElseThrow(
//				() -> new MobileNotFoundException("The given " + mobileId + " mobile is not available..."));
//		Optional<Mobile> optmobile =
			return	showMobiles().stream()
				.filter(mobile->mobile.getMobileId()==mobileId)
				.findFirst()
				.orElseThrow(()->new MobileNotFoundException("Id not found"));
//				if(optmobile.isPresent())
//						return optmobile.get();
//		throw new MobileNotFoundException("Id not found");
				
	}

	public List<Mobile> getByBrand(String brand) throws MobileNotFoundException {

		
		  List<Mobile> mobileByBrand = showMobiles()
				  .stream()
				  .filter(mobile ->mobile.getBrand().equalsIgnoreCase(brand)) 
				  .sorted((mobile1, mobile2) ->mobile1.getBrand().compareToIgnoreCase(mobile2.getBrand()))
				  .collect(Collectors.toList());
	if (mobileByBrand.isEmpty()) 
		throw new  MobileNotFoundException("The given " + brand +
				  " mobiles list is not available"); 
		 
	return mobileByBrand;
	}

	private List<Mobile> showMobiles() {
		return Arrays.asList(new Mobile(1234, "Redmi", "Note10s", 15687.23),
				new Mobile(5674, "Samsung", "SG198", 18654.96), new Mobile(9842, "Vivo", "V146", 20389.23),
				new Mobile(2863, "Oppo", "O762", 17982.43), new Mobile(6194, "Poco", "P123", 16234.82),
				new Mobile(1853, "Oppo", "O981", 18931.45));

	}

}

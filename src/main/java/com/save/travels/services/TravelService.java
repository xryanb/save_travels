package com.save.travels.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.save.travels.models.Travel;
import com.save.travels.repositories.TravelRepository;


@Service
public class TravelService {
 private final TravelRepository travelRepository;
 
  public TravelService(TravelRepository travelRepository) {
      this.travelRepository = travelRepository;
  }
  
  public List<Travel> allTravels() {
      return travelRepository.findAll();
  }
 
  public Travel createTravel(Travel t) {
      return travelRepository.save(t);
  }

  public Travel findTravel(Long id) {
      Optional<Travel> optionalTravel = travelRepository.findById(id);
      if(optionalTravel.isPresent()) {
          return optionalTravel.get();
      } else {
          return null;
      }
  }

public Travel updateTravel(Long id, String name, String desc, String vendor, Integer amount) {
	Travel travel= findTravel(id);
	 if(travel != null) {
		travel.setName(name);
		travel.setDescription(desc);
		travel.setVendor(vendor);
		travel.setAmount(amount);
	} 
	 return travelRepository.save(travel);
}

public void deleteTravel(Long id) {
	travelRepository.deleteById(id);
	
}

public void updateTravel(Travel travel) {
	// TODO Auto-generated method stub
	travelRepository.save(travel);
}
}


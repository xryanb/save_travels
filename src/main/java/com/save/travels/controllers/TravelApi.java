package com.save.travels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.save.travels.models.Travel;
import com.save.travels.services.TravelService;

@RestController
public class TravelApi {
	private final TravelService travelService;
	
	public TravelApi(TravelService travelService) {
		this.travelService=travelService;
	}
	
	@RequestMapping("/api/travels")
	public List<Travel> index(){
		return travelService.allTravels();
	}
	
	@RequestMapping(value="/api/travels", method=RequestMethod.POST)
    public Travel create(@RequestParam(value="name") String name, @RequestParam(value="description") String desc, @RequestParam(value="vendor") String vendor, @RequestParam(value="amount") Integer amount) {
        Travel travel = new Travel(name, desc, vendor, amount);
        return travelService.createTravel(travel);
    }
	
	@RequestMapping("/api/travels/{id}")
	public Travel show(@PathVariable("id") Long id) {
		Travel travel=travelService.findTravel(id);
		return travel;
	}
	
	   @RequestMapping(value="/api/travels/{id}", method=RequestMethod.PUT)
	    public Travel update(
	    		@PathVariable("id") Long id, 
	    		@RequestParam(value="name") String name, 
	    		@RequestParam(value="description") String desc, 
	    		@RequestParam(value="vendor") String vendor,
	    		@RequestParam(value="amount") Integer amount) {
	       Travel travel = travelService.updateTravel(id, name, desc, vendor, amount);
	        return travel;
	    }
	    
	    @RequestMapping(value="/api/travels/{id}", method=RequestMethod.DELETE)
	    public void destroy(@PathVariable("id") Long id) {
	       travelService.deleteTravel(id);
	    }
}

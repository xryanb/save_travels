package com.save.travels.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.save.travels.models.Travel;
import com.save.travels.services.TravelService;

@Controller
public class TravelController {
	
	@Autowired
	TravelService travelService;
	
	//show all
	 @RequestMapping("/expenses")
	    public String index(@ModelAttribute("travel") Travel travel,Model model) {
			 ArrayList<Travel> travels= (ArrayList<Travel>) travelService.allTravels();
	        model.addAttribute("travels", travels);
	        return "index.jsp";
	    }
	
	//show one
	@GetMapping("/expenses/{travelId}/show")
	public String show(@PathVariable("travelId") Long travelId, Model model) {
		System.out.println(travelId);
		Travel travel=travelService.findTravel(travelId);
		System.out.println(travel);
		model.addAttribute("travel",travel);
		return "show.jsp";
	}
	
	//create
	@PostMapping("/expenses/create")
	public String create(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            travelService.createTravel(travel);
            return "redirect:/expenses";
        }
    }
	
	//update
	    @RequestMapping("/expenses/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	       Travel travel = travelService.findTravel(id);
	        model.addAttribute("travel", travel);
	        return "edit.jsp";
	    }
	    
	    @RequestMapping(value="/expenses/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
	        if (result.hasErrors()) {
	        	System.out.println("hello");
	            return "edit.jsp";
	        } else {
	            travelService.updateTravel(travel);
	            return "redirect:/expenses";
	        }
	    }
	    
	    //delete
	    @DeleteMapping("/expenses/{id}/delete")
	    public String destroy(@PathVariable("id") Long id) {
	        travelService.deleteTravel(id);
	        return "redirect:/expenses";
	    }


	    
	}

	


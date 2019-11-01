package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Beer;

@Controller
public class BeerController {
	
	@RequestMapping("/beer/new")
	public String create(Beer beer) {
		return "beer/CreateBeer";
	}
	
	@RequestMapping(value = "/beer/new", method = RequestMethod.POST)
	public String register(@Valid Beer beer, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return create(beer);
		}
		
		attributes.addFlashAttribute("message", "It was save successfully!");
		System.out.println(">>>> sku " + beer.getSku());
		return "redirect:/beer/new";
	}
	
}

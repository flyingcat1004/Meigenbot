package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Meigen;
import com.example.demo.repository.MeigenRepository;


@Controller
public class MeigenController {

	private final MeigenRepository repository;
	
	public MeigenController(MeigenRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/")
	public String getAllComments(@ModelAttribute Meigen meigen, Model model) {
		model.addAttribute("meigens",repository.findAll());
		return "form";
	}
	
	@PostMapping("/add")
	public String addMeigen(@Validated @ModelAttribute Meigen meigen, BindingResult result, Model model) {
		model.addAttribute("meigens", repository.findAll());
		
		if(result.hasErrors()) {
			return "form";
		}
		
		repository.save(meigen);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteMeigen(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/";
	}
	
}

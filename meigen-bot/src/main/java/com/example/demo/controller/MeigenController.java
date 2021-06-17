package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Meigen;
import com.example.demo.model.MeigenForm;
import com.example.demo.repository.MeigenRepository;
import com.example.demo.service.MeigenService;


@Controller

public class MeigenController {
	
	/*private final MeigenRepository repository;
	
	public MeigenController(MeigenRepository repository) {
		this.repository = repository;
	}*/
	@Autowired
	MeigenService meigenService;
	//MeigenRepository repository;
	
	@GetMapping("/")
	public String getAllComments(@ModelAttribute Meigen meigen, Model model) {
		model.addAttribute("meigens",meigenService.findAll());
		return "form";
	}
	
	@PostMapping("/add")
	public String addMeigen(@Validated @ModelAttribute Meigen meigen, BindingResult result, Model model) {
		model.addAttribute("meigens", meigenService.findAll());
		
		
		if(result.hasErrors()) {
			return "form";
		}
		
		meigenService.create(meigen);
		return "redirect:/";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteMeigen(@PathVariable Long id) {
		meigenService.delete(id);
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	String delete(@RequestParam Long id) {
		meigenService.delete(id);
		return "redirect:/";
	}
	
	@GetMapping(path = "edit")
	String editForm(@RequestParam Long id, MeigenForm form) {
		
		Meigen meigen = meigenService.findOne(id);
		
		BeanUtils.copyProperties(meigen, form);
		
		return "edit";
	}
	
	@PostMapping("/edit")
	String edit(@RequestParam Long id, @Validated MeigenForm form, BindingResult result) {
		if(result.hasErrors()) {
			return editForm(id, form);
		}
		Meigen meigen = new Meigen();
		BeanUtils.copyProperties(form, meigen);
		meigen.setId(id);
		meigen.setDate(LocalDate.now());
		meigenService.update(meigen);
		return "redirect:/";
	}
}

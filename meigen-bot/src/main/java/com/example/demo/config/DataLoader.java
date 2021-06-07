package com.example.demo.config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Meigen;
import com.example.demo.repository.MeigenRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner{
	
	private final MeigenRepository repository;
	
	
	@Override
	public void run(String... args) throws Exception{
		Meigen meigen = new Meigen();
		meigen.setContent("Hello World");
		meigen.setDate(LocalDate.now());
		meigen.setUserRegi("相原健太");
		repository.save(meigen);
		
		
	}

}

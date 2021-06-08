package com.example.demo.config;

import org.springframework.stereotype.Component;

import com.example.demo.repository.MeigenRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader {
	
	private final MeigenRepository repository;
	
}

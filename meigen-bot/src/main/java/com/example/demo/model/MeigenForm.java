package com.example.demo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MeigenForm {
	@NotNull
	@Size(min = 1, max = 100)
	private String content;
	
	@NotNull
	@Size(min = 1, max = 20)
	private String userRegi;
}

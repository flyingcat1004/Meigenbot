package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Meigen {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	@Size(max = 100)
	private String content; //名言本文
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date; //登録日時
	
	@NotBlank
	@Size(max = 20)
	private String userRegi; //登録者
}

package com.example.demo.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TargetForm {

	@NotBlank
	private int ude;

	@NotBlank
	private int hara;

	@NotBlank
	private int asi;

	@NotBlank
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date kigen;

}

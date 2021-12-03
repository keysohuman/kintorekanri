package com.example.demo.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RecordForm {

	@NotBlank
	private int ude;

	@NotBlank
	private int hara;

	@NotBlank
	private int asi;

}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.RecordForm;
import com.example.demo.service.RecordService;

@Controller
public class recordController {

	@Autowired
	private RecordService recordService;


	@GetMapping("/record")
	public String getRecord(@ModelAttribute RecordForm recordform, Model model) {

		return "record";
	}


	@PostMapping("/record")
	public String postRecord(@ModelAttribute @Validated RecordForm recordform,BindingResult bindingresult, Model model) {



		if(bindingresult.hasErrors()) {

			return getRecord(recordform, model);
		}



		recordService.insert(recordform);


		return  "redirect:home";





	}

}

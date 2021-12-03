package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.TargetForm;
import com.example.demo.service.TargetService;

@Controller
public class targetController {

	@Autowired
	private TargetService targetservice;


	@GetMapping("/target")
	public String getTarget(@ModelAttribute TargetForm targetform,Model model) {

		return "target";

	}

	@PostMapping("/target")
	public String postTarget(@ModelAttribute TargetForm targetform,BindingResult bindingResult,Model model) {

		if(bindingResult.hasErrors()) {

			return getTarget(targetform,model);
		}



		System.out.println(targetform.getKigen());

		if(bindingResult.hasErrors()) {

			return "target";
		}





		targetservice.insert(targetform);


		return  "redirect:home";
	}

}

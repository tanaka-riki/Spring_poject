package com.example.demo.AnimalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.AnimalsAPI.data.AnimalsAPIData;
import com.example.demo.AnimalsAPI.service.AnimalsAPIService;

@Controller
public class AnimalsAPIController {

	private final AnimalsAPIService animalsAPIService;

	public AnimalsAPIController(AnimalsAPIService animalsAPIService) {
		this.animalsAPIService = animalsAPIService;
	}

	@GetMapping("animalsSearch")
	public String animalsSearch(Model model) throws IOException {

		List<AnimalsAPIData> animalsList = animalsAPIService.getAnimalsAPIData();

		model.addAttribute("animalsList", animalsList);

		return "animalsApiSearch.html";
	}

	@GetMapping("animalsResult")
	public String animalDetails(@RequestParam("animalsId") String animalsId, Model model) throws IOException {

		List<AnimalsAPIData> hitAnimalsList = animalsAPIService.getSpecificAnimalsAPIData(animalsId);

		model.addAttribute("hitAnimalsList", hitAnimalsList);

		return "animalsApiResult.html";

	}

}
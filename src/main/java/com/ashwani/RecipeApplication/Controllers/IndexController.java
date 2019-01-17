package com.ashwani.RecipeApplication.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ashwani.RecipeApplication.Service.RecipeService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {

	private final RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}

	@RequestMapping({"","/","index"})
	public String getIndexPage(Model model) {
		model.addAttribute("recipes", recipeService.getRecipe());
		return "index";
	}
}

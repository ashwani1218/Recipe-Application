package com.ashwani.RecipeApplication.Service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import com.ashwani.RecipeApplication.Model.Recipe;
import com.ashwani.RecipeApplication.Repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	private final RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipe() {
		Set<Recipe> recipeSet=new HashSet<Recipe>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		return recipeSet;
	}
	
	

}

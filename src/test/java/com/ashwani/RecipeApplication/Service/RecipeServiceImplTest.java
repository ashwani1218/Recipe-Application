package com.ashwani.RecipeApplication.Service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ashwani.RecipeApplication.Model.Recipe;
import com.ashwani.RecipeApplication.Repository.RecipeRepository;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;
	@Mock
	RecipeRepository recipeRepository;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		recipeService=new RecipeServiceImpl(recipeRepository);
		
	}
	
	@Test
	public void testGetRecipe() {
		HashSet<Recipe> recipes=new HashSet<Recipe>();
		Recipe recipeData=new Recipe();
		recipes.add(recipeData);
		
		when(recipeService.getRecipe()).thenReturn(recipes);
		
		Set<Recipe> recipe=recipeService.getRecipe();
		
		assertEquals(recipe.size(), 1);
		verify(recipeRepository, times(1)).findAll();
	}

}

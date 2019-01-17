package com.ashwani.RecipeApplication.Model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	Category category;
	
	@Before
	public void setUp() {
		category = new Category();
	}
	
	@Test
	public void testGetId() {
		Long id=4L;
		category.setId(id);
		assertEquals(id, category.getId());
	}

	@Test
	public void testGetDescription() {
		String description="Indian";
		category.setDescription(description);
		assertEquals(description, category.getDescription());
	}

	@Test
	public void testGetRecipe() {
		Set<Recipe> recipe=new HashSet<Recipe>();
		category.setRecipe(recipe);
		assertEquals(recipe, category.getRecipe());
	}

}

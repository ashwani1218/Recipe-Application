package com.ashwani.RecipeApplication.Controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.ashwani.RecipeApplication.Model.Recipe;
import com.ashwani.RecipeApplication.Service.RecipeService;

public class IndexControllerTest {

	@Mock
	RecipeService recipeService;
	@Mock
	Model model;
	Set<Recipe> anySet =new HashSet<Recipe>();
	
	IndexController indexController;
	
	@Before
	public void setUp() throws Exception {
	MockitoAnnotations.initMocks(this);
	indexController=new IndexController(recipeService);
	}
	@Test
	public void testMockMvc() throws Exception{
		MockMvc mockMvc=MockMvcBuilders.standaloneSetup(indexController).build();
		
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
	}
	

	@Test
	public void testGetIndexPage() {
		String viewController= indexController.getIndexPage(model);
		assertEquals("index", viewController);
		verify(recipeService, times(1)).getRecipe();
		verify(model,times(1)).addAttribute("recipes", anySet);
	}

}

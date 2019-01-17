package com.ashwani.RecipeApplication.BootStrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ashwani.RecipeApplication.Model.Category;
import com.ashwani.RecipeApplication.Model.Difficulty;
import com.ashwani.RecipeApplication.Model.Ingredient;
import com.ashwani.RecipeApplication.Model.Notes;
import com.ashwani.RecipeApplication.Model.Recipe;
import com.ashwani.RecipeApplication.Model.UnitOfMeasure;
import com.ashwani.RecipeApplication.Repository.CategoryRepository;
import com.ashwani.RecipeApplication.Repository.RecipeRepository;
import com.ashwani.RecipeApplication.Repository.UnitOfMeasureRepository;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RecipeBootStrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	
	public RecipeBootStrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}
	
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		recipeRepository.saveAll(getRecipe());
		
	}



	private List<Recipe> getRecipe(){
		List<Recipe> recipes= new ArrayList<Recipe>();
		
		Optional<UnitOfMeasure> eachUomOptional=unitOfMeasureRepository.findByDescription("Each");
		
		if(!eachUomOptional.isPresent()) {
			throw new RuntimeException("Expected Unit of measure not found");
		}
		
		Optional<UnitOfMeasure> teaspoonUomOptional=unitOfMeasureRepository.findByDescription("Teaspoon");
		
		if(!teaspoonUomOptional.isPresent()) {
			throw new RuntimeException("Expected Unit of measure not found");
		}
		
		Optional<UnitOfMeasure> tablespoonUomOptional=unitOfMeasureRepository.findByDescription("Tablespoon");
		
		if(!tablespoonUomOptional.isPresent()) {
			throw new RuntimeException("Expected Unit of measure not found");
		}
		
		Optional<UnitOfMeasure> pinchUomOptional=unitOfMeasureRepository.findByDescription("Pinch");
		
		if(!pinchUomOptional.isPresent()) {
			throw new RuntimeException("Expected Unit of measure not found");
		}
		
		Optional<UnitOfMeasure> cupUomOptional=unitOfMeasureRepository.findByDescription("Cup");
		
		if(!cupUomOptional.isPresent()) {
			throw new RuntimeException("Expected Unit of measure not found");
		}

		Optional<UnitOfMeasure> ounchUomOptional=unitOfMeasureRepository.findByDescription("Ounch");
		
		if(!ounchUomOptional.isPresent()) {
			throw new RuntimeException("Expected Unit of measure not found");
		}

		Optional<UnitOfMeasure> dashUomOptional=unitOfMeasureRepository.findByDescription("Dash");
		
		if(!dashUomOptional.isPresent()) {
			throw new RuntimeException("Expected Unit of measure not found");
		}

		UnitOfMeasure eachUom= eachUomOptional.get();
		UnitOfMeasure teaspoonUom= teaspoonUomOptional.get();
		UnitOfMeasure tablespoonUom= tablespoonUomOptional.get();
		UnitOfMeasure pinchUom=pinchUomOptional.get();
		UnitOfMeasure cupUom=cupUomOptional.get();
		UnitOfMeasure ounchUom=ounchUomOptional.get();
		UnitOfMeasure dashUom=dashUomOptional.get();
		
		List<Category> categories=new ArrayList<Category>();
		
		Optional<Category> americanCategoryOptional=categoryRepository.findByDescription("American");
		if(!americanCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category Not Found");
		}
		
		Optional<Category> indianCategoryOptional=categoryRepository.findByDescription("Indian");
		if(!indianCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category Not Found");
		}
		
		Optional<Category> italianCategoryOptional=categoryRepository.findByDescription("Italian");
		if(!italianCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category Not Found");
		}
		
		Optional<Category> fastfoodCategoryOptional=categoryRepository.findByDescription("Fast-food");
		if(!fastfoodCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category Not Found");
		}
		
		Optional<Category> mexicanCategoryOptional=categoryRepository.findByDescription("Mexican");
		if(!mexicanCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category Not Found");
		}
		Category americanCategory=americanCategoryOptional.get();
		Category indiaCategory=indianCategoryOptional.get();
		Category italianCategory=italianCategoryOptional.get();
		Category fastfoodCategory=fastfoodCategoryOptional.get();
		Category mexicanCategory=mexicanCategoryOptional.get();
		
		
		Recipe guacRecipe=new Recipe();
		guacRecipe.setDescription("Perfect Guacamole");
		guacRecipe.setPrepTime(30);
		guacRecipe.setCookTime(0);
		guacRecipe.setDifficulty(Difficulty.EASY);
		guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon."
				+ "/n"
				+ "2  Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)"
				+ "/n"
				+ "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\r\n" + 
				"\r\n" + 
				"Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\r\n" + 
				"\r\n" + 
				"Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste."
				+"/n"
				+"4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\r\n" + 
				"\r\n" + 
				"Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving."
				);
		Notes guacNotes=new Notes();
		guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados."
				+"/n"
				+ "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries"
				+"/n"
				+ "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole. "
				+ "/n"
				+"To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");
		
		guacRecipe.setNotes(guacNotes);
	
		guacRecipe.addIngredient(new Ingredient("ripe Avacados",new BigDecimal(2),eachUom));
		guacRecipe.addIngredient(new Ingredient("Kosher Salt",new BigDecimal(0.5),teaspoonUom));
		guacRecipe.addIngredient(new Ingredient("Fresh lime juice or lemon juice",new BigDecimal(2),tablespoonUom));
		guacRecipe.addIngredient(new Ingredient("Minced red onion or green onion",new BigDecimal(2),tablespoonUom));
		guacRecipe.addIngredient(new Ingredient("Serrano chiles,stems and seeds removed, minced",new BigDecimal(2),eachUom));
		guacRecipe.addIngredient(new Ingredient("Cilantro",new BigDecimal(2),tablespoonUom));
		guacRecipe.addIngredient(new Ingredient("Freshly grated black pepper",new BigDecimal(2),dashUom));
		guacRecipe.addIngredient(new Ingredient("ripped tomato, seeds and pulp removed, chopped ",new BigDecimal(0.5),eachUom));
		
		guacRecipe.getCategory().add(americanCategory);
		guacRecipe.getCategory().add(mexicanCategory);

		recipes.add(guacRecipe);
		
		Recipe tacosRecipe=new Recipe();
		
		tacosRecipe.setDescription("Chicken Tacos");
		tacosRecipe.setCookTime(15);
		tacosRecipe.setPrepTime(20);
		tacosRecipe.setServings(5);
		tacosRecipe.setDifficulty(Difficulty.MODERATE);
		tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\r\n" + 
				"\r\n" + 
				"2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\r\n" + 
				"\r\n" + 
				"Set aside to marinate while the grill heats and you prepare the rest of the toppings.\r\n" + 
				"\r\n" + 
				"3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\r\n" + 
				"\r\n" + 
				"4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\r\n" + 
				"\r\n" + 
				"Wrap warmed tortillas in a tea towel to keep them warm until serving.\r\n" + 
				"\r\n" + 
				"5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
		Notes tacosNotes=new Notes();
		tacosNotes.setRecipeNotes("The ancho chiles I use in the marinade are named for their wide shape. They are large, have a deep reddish brown color when dried, and are mild in flavor with just a hint of heat. You can find ancho chile powder at any markets that sell Mexican ingredients, or online.\r\n" + 
				"\r\n" + 
				"I like to put all the toppings in little bowls on a big platter at the center of the table: avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. I add arugula, as well – this green isn’t traditional for tacos, but we always seem to have some in the fridge and I think it adds a nice green crunch to the tacos.\r\n" + 
				"\r\n" + 
				"Everyone can grab a warm tortilla from the pile and make their own tacos just they way they like them.");
		
		tacosRecipe.setNotes(tacosNotes);
		
		tacosRecipe.addIngredient(new Ingredient("Ancho Chilli powder",new BigDecimal(2),tablespoonUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("Dried Oregano",new BigDecimal(1),teaspoonUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("Dried Cumin",new BigDecimal(1),teaspoonUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("Sugar",new BigDecimal(1),teaspoonUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("Salt",new BigDecimal(0.5),teaspoonUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("Orange Zest, finely grated",new BigDecimal(1),tablespoonUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("Orange juice, freshly squeezed",new BigDecimal(3),tablespoonUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("olive oil",new BigDecimal(2),tablespoonUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("Boneless chicken thighs",new BigDecimal(4),tablespoonUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("small corn tortilla",new BigDecimal(8),eachUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("Packed Baby arugula",new BigDecimal(3),cupUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("Medium Avocado , sliced",new BigDecimal(2),eachUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("Redish , thinly Sliced",new BigDecimal(4),eachUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("pint cherry Tamoto",new BigDecimal(0.5),eachUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("lime, cute",new BigDecimal(1),eachUom,tacosRecipe));
		tacosRecipe.addIngredient(new Ingredient("Cilantro, roughly chopped",new BigDecimal(1),eachUom,tacosRecipe));
		
		tacosRecipe.getCategory().add(americanCategory);
		tacosRecipe.getCategory().add(mexicanCategory);
		
		recipes.add(tacosRecipe);
		return recipes;
		
	}
}

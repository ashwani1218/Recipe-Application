package com.ashwani.RecipeApplication.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ashwani.RecipeApplication.Model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Long>{

}

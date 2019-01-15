package com.ashwani.RecipeApplication.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.ashwani.RecipeApplication.Model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	Optional<Category> findByDescription(String description);

}

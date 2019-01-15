package com.ashwani.RecipeApplication.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ashwani.RecipeApplication.Model.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(String description);
}
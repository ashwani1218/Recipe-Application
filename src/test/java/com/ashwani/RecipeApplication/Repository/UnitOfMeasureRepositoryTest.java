package com.ashwani.RecipeApplication.Repository;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ashwani.RecipeApplication.Model.UnitOfMeasure;



@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTest {

	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindByDescription() {
		Optional<UnitOfMeasure> uomOptional=unitOfMeasureRepository.findByDescription("Teaspoon");
		
		assertEquals("Teaspoon", uomOptional.get().getDescription());
	}

	@Test
	public void testFindByDescriptionCup() {
		Optional<UnitOfMeasure> uomOptional=unitOfMeasureRepository.findByDescription("Cup");
		
		assertEquals("Cup", uomOptional.get().getDescription());
	}

	@Test
	public void testFindByDescriptionTable() {
		Optional<UnitOfMeasure> uomOptional=unitOfMeasureRepository.findByDescription("Tablespoon");
		
		assertEquals("Tablespoon", uomOptional.get().getDescription());
	}
	@Test
	public void testFindByDescriptionPinch() {
		Optional<UnitOfMeasure> uomOptional=unitOfMeasureRepository.findByDescription("Pinch");
		
		assertEquals("Pinch", uomOptional.get().getDescription());
	}
	@Test
	public void testFindByDescriptionDash() {
		Optional<UnitOfMeasure> uomOptional=unitOfMeasureRepository.findByDescription("Dash");
		
		assertEquals("Dash", uomOptional.get().getDescription());
	}
	@Test
	public void testFindByDescriptionOunch() {
		Optional<UnitOfMeasure> uomOptional=unitOfMeasureRepository.findByDescription("Ounch");
		
		assertEquals("Ounch", uomOptional.get().getDescription());
	}
	@Test
	public void testFindByDescriptionEach() {
		Optional<UnitOfMeasure> uomOptional=unitOfMeasureRepository.findByDescription("Each");
		
		assertEquals("Each", uomOptional.get().getDescription());
	}

}

package com.qa.persistence.repository;

public interface HeroesRepository {
	
	String getAllHeroes();

	String getSingleHero(Long id);

	String updateHero(Long id, String heroToUpdate);
}

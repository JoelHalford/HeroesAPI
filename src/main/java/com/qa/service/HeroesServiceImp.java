package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.repository.HeroesRepository;

public class HeroesServiceImp implements HeroesService {
	
	@Inject
	private HeroesRepository repo;
	
	public String getAllHeroes() {
		return repo.getAllHeroes();
	}

	public String getHero(Long id) {
		return repo.getSingleHero(id);
	}
}

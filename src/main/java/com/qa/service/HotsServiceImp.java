package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.repository.HotsRepository;
import com.qa.util.JSONUtil;


public class HotsServiceImp implements HotsService {
	
	@Inject
	private HotsRepository repo;
	@Inject
	private JSONUtil util;

	
	public String getAllHeroes() {
		return repo.getAllHeroes();
	}
}

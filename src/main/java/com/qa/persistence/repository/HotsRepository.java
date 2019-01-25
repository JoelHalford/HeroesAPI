package com.qa.persistence.repository;

public interface HotsRepository {
	
	String getAllHeroes();

	String addUser(String hero);

	String updateUser(Long id, String accountToUpdate);

	String deleteUser(Long id);

	String getSingleHero(Long id);
}

package com.qa.persistence.repository;

public interface HotsRepository {
	
	String getAllHeroes();

	String createAccount(String account);

	String updateUser(Long id, String accountToUpdate);

	String deleteUser(Long id);

	String getSingleHero(Long id);
}

package com.qa.persistence.repository;

public interface HotsRepository {
	
	String getAllHeroes();

	String createAccount(String account);

	String updateAccount(Long id, String accountToUpdate);

	String deleteAccount(Long id);

	String getSingleHero(Long id);
	
	String getSingleAccount(String username);

	String getAllAccounts();
}

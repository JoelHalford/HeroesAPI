package com.qa.service;

public interface HotsService {

	String getAllHeroes();

	String getHero(Long id);
	
	String getAllAccounts();
	
	String getAccount(String username);

	String addAccount(String account);
	
	String updateAccount(Long id, String account);
	
	String  deleteAccount(Long id);
}

package com.qa.service;

public interface AccountService {
	
	String getAllAccounts();
	
	String getAccount(String username);

	String addAccount(String account);
	
	String updateAccount(Long id, String account);
	
	String  deleteAccount(Long id);
}

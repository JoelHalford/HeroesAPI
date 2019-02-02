package com.qa.persistence.repository;

public interface AccountRepository {
	
	String createAccount(String account);

	String updateAccount(Long id, String accountToUpdate);

	String deleteAccount(Long id);
	
	String getSingleAccount(String username);

	String getAllAccounts();
}

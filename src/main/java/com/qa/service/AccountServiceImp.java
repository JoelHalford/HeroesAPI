package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.repository.AccountRepository;

public class AccountServiceImp implements AccountService {
	
	@Inject
	private AccountRepository repo;
	
	
	public String addAccount(String account) {
		return repo.createAccount(account);
	}

	public String getAllAccounts() {
		// TODO Auto-generated method stub
		return repo.getAllAccounts();
	}
	
	public String getAccount(String username) {
		// TODO Auto-generated method stub
		return repo.getSingleAccount(username);
	}
	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);
	}

	public String deleteAccount(Long id) {
		// TODO Auto-generated method stub
		return repo.deleteAccount(id);
	}
}

package com.qa.service;

import javax.inject.Inject;

import com.qa.domain.User;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class AccountServiceImp implements AccountService {
	
	String[] naughtyNames = new String[] {"fool", "poobrain", "biotrash", "tithead", "butt",
			"chadmayr", "coolboyz09", "nutmayr", "nightmayr", "mayr", "moomayr", "dipstick", "pinhead", "rustytrombone", "nutstains"};
		
	@Inject
	private JSONUtil util;
	
	@Inject
	private AccountRepository repo;
	
	
	public String addAccount(String account) {
		
		String upperAlphaRegex = ".*[A-Z].*";
		
		User anAccount = util.getObjectForJSON(account, User.class);
		
		for (int i = 0; i < naughtyNames.length; i++)
		{
			if (anAccount.getUsername().equals(naughtyNames[i]))
			{
				return "Username too naughty to continue, hero!";
			}
			else if (anAccount.getUsername().length() < 4)
			{
				return "Username too short, hero!";
			}
			else if (anAccount.getUsername().length() > 12)
			{
				return "Hero, your username is too long!";
			}
			else if (!anAccount.getUsername().matches(upperAlphaRegex))
			{
				return "For some reason, you need a capital letter.";
			}
		}
		return repo.createAccount(account);
	}

	public String getAllAccounts() {
		return repo.getAllAccounts();
	}
	
	public String getAccount(String username) {
		return repo.getSingleAccount(username);
	}
	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);
	}

	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}
}

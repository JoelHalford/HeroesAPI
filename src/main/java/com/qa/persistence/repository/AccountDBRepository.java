package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.domain.User;
import com.qa.util.JSONUtil;

public class AccountDBRepository implements AccountRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM User a");
		Collection<User> users = (Collection<User>) query.getResultList();
		return util.getJSONForObject(users);
	}
	
	@Transactional(REQUIRED)
	public String getSingleAccount(String username) {
		User account = findAccount(username);
		if (account != null) {
			return util.getJSONForObject(account);
		}
		return "{\"message\": \"Account not found.\"}";
	}
	
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		User anAccount = util.getObjectForJSON(account, User.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String accountToUpdate) {
		User foundAccount = findUser(id);
		User jsonAccount = util.getObjectForJSON(accountToUpdate, User.class);
		if (foundAccount != null)
		{
			manager.remove(foundAccount);
			manager.persist(jsonAccount);
			return "{\"message\": \"account sucessfully updated\"}";
		}
		return null;
	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		// TODO Auto-generated method stub
		User userInDB = findUser(id);
		if (userInDB != null) {
			manager.remove(userInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}
	
	private User findAccount(String username) {
		return manager.find(User.class, username);
	}
	
	private User findUser(Long id) {
		return manager.find(User.class, id);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}

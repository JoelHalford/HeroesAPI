package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.domain.Hero;
import com.qa.domain.User;

import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class HotsDBRepository implements HotsRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllHeroes() {
		Query query = manager.createQuery("Select a FROM Hero a");
		Collection<Hero> heroes = (Collection<Hero>) query.getResultList();
		return util.getJSONForObject(heroes);
	}
	
	@Transactional(REQUIRED)
	public String getSingleHero(Long id) {
		Hero hero = findHero(id);
		if (hero != null) {
			return util.getJSONForObject(hero);
		}
		return "{\"message\": \"Hero not found.\"}";
	}

	@Transactional(REQUIRED)
	public String createAccount(String account) {
		User anAccount = util.getObjectForJSON(account, User.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String accountToUpdate) {
		System.out.println(accountToUpdate);
		User updatedAccount = util.getObjectForJSON(accountToUpdate, User.class);
		User accountFromDB = findUser(id);
		if (accountToUpdate != null) {
			accountFromDB = updatedAccount;
			manager.merge(accountFromDB);
		}
		return "{\"message\": \"account sucessfully updated\"}";
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
	
	private User findUser(Long id) {
		return manager.find(User.class, id);
	}
	
	private Hero findHero(Long id) {
		return manager.find(Hero.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM User a");
		Collection<User> users = (Collection<User>) query.getResultList();
		return util.getJSONForObject(users);
	}
}

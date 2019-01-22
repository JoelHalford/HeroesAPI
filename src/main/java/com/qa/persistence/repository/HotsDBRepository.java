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

	public String getAll() {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("Select a FROM Hero a");
		Collection<Hero> heroes = (Collection<Hero>) query.getResultList();
		return util.getJSONForObject(heroes);
	}

	@Transactional(REQUIRED)
	public String addUser(String user) {
		// TODO Auto-generated method stub
		User aUser = util.getObjectForJSON(user, User.class);
		manager.persist(aUser);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	public String updateUser(Long id, String userToUpdate) {

		return "{\"message\": \"account sucessfully updated\"}";
	}

	public String deleteUser(Long id) {
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

}

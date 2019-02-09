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

import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class HeroesDBRepository implements HeroesRepository {

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
	
	public String updateHero(Long id, String heroToUpdate) {
		Hero foundHero = findHero(id);
		Hero jsonHero = util.getObjectForJSON(heroToUpdate, Hero.class);
		if (foundHero != null)
		{
			manager.remove(foundHero);
			manager.persist(jsonHero);
			return "{\"message\": \"hero sucessfully updated\"}";
		}
		return null;
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

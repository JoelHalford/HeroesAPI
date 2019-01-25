package com.qa.REST;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.service.HotsService;

@Path("/heroes")
public class HeroesEndpoint {
	
	@Inject
	private HotsService service;

	@Path("/getAllHeroes")
	@GET
	@Produces({ "application/json" })
	public String getAllHeroes() {
		return service.getAllHeroes();
	}
	
	@Path("/hero/{id}")
	@GET
	@Produces({ "application/json" })
	public String getHero(@PathParam("id") Long id) {
		return service.getHero(id);
	}
	
	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return service.addAccount(account);
	}
		
	public void setService(HotsService service) {
		this.service = service;
	}	
}
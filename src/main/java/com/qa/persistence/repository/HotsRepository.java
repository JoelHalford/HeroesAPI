package com.qa.persistence.repository;

public interface HotsRepository {
	
	String getAll();

	String addUser(String hero);

	String updateUser(Long id, String accountToUpdate);

	String deleteUser(Long id);
}

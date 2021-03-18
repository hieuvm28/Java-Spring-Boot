package com.vn.service;

import java.util.List;
import java.util.Optional;

import com.vn.entities.User;

public interface UserService {

	void deleteAll();

	void deleteAll(List<User> entities);

	void delete(User entity);

	void deleteById(String id);

	int count();

	List<User> findAll();

	boolean existsById(String id);

	Optional<User> findById(String id);

	List<User> saveAll(List<User> entities);

	User save(User entity);

	boolean checkLogin(String username, String password);
}

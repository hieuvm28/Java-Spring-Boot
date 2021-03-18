package com.vn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.vn.entities.Staffs;

public interface StaffService {

	void deleteAll();

	void deleteAll(List<Staffs> entities);

	void delete(Staffs entity);

	void deleteById(Integer id);

	long count();

	Iterable<Staffs> findAll();

	boolean existsById(Integer id);

	Optional<Staffs> findById(Integer id);

	List<Staffs> saveAll(List<Staffs> entities);

	Staffs save(Staffs entity);

	List<Staffs> getStaffByName(String name);

	List<Staffs> getStaffByEmail(String email);
	
	List<Staffs> getStaffByPage(int page, int total );
	
}

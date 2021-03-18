package com.vn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vn.entities.Staffs;
import com.vn.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	
}

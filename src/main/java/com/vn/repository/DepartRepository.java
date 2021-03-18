package com.vn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vn.entities.Depart;

@Repository
public interface DepartRepository extends CrudRepository<Depart, Integer>{

}

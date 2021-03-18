package com.vn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vn.entities.Record;

@Repository
public interface RecordRepository extends CrudRepository<Record, Integer>{

}

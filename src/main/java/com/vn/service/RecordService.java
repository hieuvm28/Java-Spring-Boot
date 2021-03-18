package com.vn.service;

import java.util.List;
import java.util.Optional;

import com.vn.entities.Record;

public interface RecordService {

	void deleteAll();

	void deleteAll(List<Record> entities);

	void delete(Record entity);

	void deleteById(Integer id);

	long count();

	Iterable<Record> findAll();

	boolean existsById(Integer id);

	Optional<Record> findById(Integer id);

	List<Record> saveAll(List<Record> entities);

	Record save(Record entity);

	

}

package com.vn.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.entities.Record;
import com.vn.repository.RecordRepository;
import com.vn.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService{
	
	@Autowired
	RecordRepository recordRepository;
	
	@Override
	public Record save(Record entity) {
		entity.setDate(new Date());
		if (entity.getType().equals("true")) {
			entity.setType("Good");
		} else {
			entity.setType("Not Good");
		}
		return recordRepository.save(entity);
	}

	@Override
	public List<Record> saveAll(List<Record> entities) {
		return (List<Record>) recordRepository.saveAll(entities);
	}

	@Override
	public Optional<Record> findById(Integer id) {
		return recordRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return recordRepository.existsById(id);
	}

	@Override
	public Iterable<Record> findAll() {
		return recordRepository.findAll();
	}

	@Override
	public long count() {
		return recordRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		recordRepository.deleteById(id);
	}

	@Override
	public void delete(Record entity) {
		recordRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Record> entities) {
		recordRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		recordRepository.deleteAll();
	}
	
	
}

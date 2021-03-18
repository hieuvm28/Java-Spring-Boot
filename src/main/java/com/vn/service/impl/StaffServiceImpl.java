package com.vn.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.entities.Staffs;
import com.vn.repository.StaffRepository;
import com.vn.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	StaffRepository staffRepository;

	@Override
	public Staffs save(Staffs entity) {
		return staffRepository.save(entity);
	}

	@Override
	public List<Staffs> saveAll(List<Staffs> entities) {
		return (List<Staffs>) staffRepository.saveAll(entities);
	}

	@Override
	public Optional<Staffs> findById(Integer id) {
		return staffRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return staffRepository.existsById(id);
	}

	@Override
	public Iterable<Staffs> findAll() {
		return staffRepository.findAll();
	}

	@Override
	public long count() {
		return staffRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		staffRepository.deleteById(id);
	}

	@Override
	public void delete(Staffs entity) {
		staffRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Staffs> entities) {
		staffRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		staffRepository.deleteAll();
	}

	@Override
	public List<Staffs> getStaffByName(String name) {
		return staffRepository.getStaffByName(name);
	}

	@Override
	public List<Staffs> getStaffByEmail(String email) {
		return staffRepository.getStaffByEmail(email);
	}

	@Autowired
	EntityManagerFactory emf;

	@Override
	public List<Staffs> getStaffByPage(int page, int total) {
		Session session = emf.createEntityManager().unwrap(Session.class);
		String hql = "From Staffs";
		Query query = session.createQuery(hql);
		if (page == 1) {
			query.setFirstResult(page - 1);
			query.setMaxResults(total);
		} else {
			
			page = (page - 1) * total + 1;
			
			query.setFirstResult(page - 1);
			query.setMaxResults(total);
		}
			List<Staffs> list = query.list();
		
//		List<Staffs> list = staffRepository.getStaffByPage(page-1, total);
		
		
		return list;
	}

}

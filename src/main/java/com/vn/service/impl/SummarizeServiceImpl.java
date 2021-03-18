package com.vn.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.repository.DepartRepository;
import com.vn.repository.RecordRepository;
import com.vn.repository.StaffRepository;
import com.vn.repository.UserRepository;
import com.vn.service.SummarizeService;

@Service
public class SummarizeServiceImpl implements SummarizeService {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Autowired
	UserRepository userRepository;

	@Autowired
	DepartRepository departRepository;

	@Autowired
	StaffRepository staffRepository;

	@Autowired
	RecordRepository recordRepository;

	@Override
	public List<Object[]> getReport() {
		List<Object[]> list = new ArrayList<>();
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "SELECT r.staff.name, SUM(case when r.type= 'Good' then 1 else 0 end), "
				+ "SUM(case when r.type= 'Not Good' then 1 else 0 end) FROM Record r GROUP BY r.staff.name";
		Query query = session.createQuery(hql);
		list = query.list();
		return list;
	}

	@Override
	public List<Object[]> getListStaffGood() {
		List<Object[]> list = new ArrayList<>();
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		String hql = "SELECT s.photo, s.id, s.name, s.email, SUM(case when r.type= 'Good' then 1 else 0 end), "
				+ "SUM(case when r.type= 'Not Good' then 1 else 0 end) " + "FROM Record r inner join Staffs s "
				+ "ON r.staff.id = s.id " + "GROUP BY s.photo, s.id, s.name, s.email "
				+ "HAVING (SUM(case when r.type= 'Good' then 1 else 0 end) - SUM(case when r.type= 'Not Good' then 1 else 0 end)) >= 2";

		Query query = session.createQuery(hql).setMaxResults(2);
		list = query.list();
		return list;
	}

	@Override
	public Integer getCountUser() {
		Integer countUser = (int) userRepository.count();
		return countUser;
	}

	@Override
	public Long getCountDepart() {
		Long countDepart = departRepository.count();
		return countDepart;
	}

	@Override
	public Long getCountStaff() {

		return staffRepository.count();
	}

	@Override
	public Long getCountRecord() {
		return recordRepository.count();
	}

}

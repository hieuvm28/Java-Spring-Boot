package com.vn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vn.entities.Staffs;

@Repository
public interface StaffRepository extends JpaRepository<Staffs, Integer>{
	
	@Query(value = " SELECT * FROM Staffs  WHERE name like %:name%", nativeQuery = true)
	List<Staffs> getStaffByName(@Param("name") String name);
	
	@Query(value = " SELECT * FROM Staffs  WHERE email like %:email%", nativeQuery = true)
	List<Staffs> getStaffByEmail(@Param("email") String email);
	
	@Query(value = "SELECT * FROM Staffs LIMIT :pageid , :total", nativeQuery = true)
	List<Staffs> getStaffByPage(@Param("pageid") int page, @Param("total") int total);
	
	String s = "SELECT s.photo, s.id, s.name, s.email, SUM(case when r.type= 'Good' then 1 else 0 end), SUM(case when r.type= 'Not Good' then 1 else 0 end) FROM Record r, Staffs s where r.staff.id = s.id GROUP BY s.photo, s.id, s.name, s.email ";
	
}

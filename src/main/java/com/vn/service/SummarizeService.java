package com.vn.service;

import java.util.List;

public interface SummarizeService {
	List<Object[]> getReport();
	
	List<Object[]> getListStaffGood();
	
	Integer getCountUser();
	
	Long getCountDepart();
	
	Long getCountStaff();
	
	Long getCountRecord();
	
}

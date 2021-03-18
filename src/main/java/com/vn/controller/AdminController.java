package com.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.service.SummarizeService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	SummarizeService summarizeService;
	
	@GetMapping("")
	public String admin(ModelMap model) {
	 	model.addAttribute("staffGood",summarizeService.getListStaffGood());
		return "admin";
	}
	
	@ModelAttribute("countUser")
	public Integer countUser() {
		System.out.println(summarizeService.getCountUser());
		return summarizeService.getCountUser();
	}
	
	@ModelAttribute("countDepart")
	public Long countDepart() {
		System.out.println(summarizeService.getCountDepart());
		return summarizeService.getCountDepart();
	}
	
	@ModelAttribute("countStaff")
	public Long countStaff() {
		System.out.println(summarizeService.getCountStaff());
		return summarizeService.getCountStaff();
	}
	
	@ModelAttribute("countRecord")
	public Long countRecord() {
		System.out.println(summarizeService.getCountRecord());
		return summarizeService.getCountRecord();
	}
}

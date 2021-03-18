package com.vn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.service.SummarizeService;

@Controller
@RequestMapping("/summarize")
public class SummarizeController {

	
	
	@Autowired
	SummarizeService summarizeService;
	
	@GetMapping("")
	public String summarize(ModelMap model) {
		model.addAttribute("report", summarizeService.getReport());
		return "summarize/listSummarize";
	}

	
}

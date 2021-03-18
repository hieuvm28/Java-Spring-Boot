package com.vn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.entities.Record;
import com.vn.entities.Staffs;
import com.vn.service.RecordService;
import com.vn.service.StaffService;

@Controller
@RequestMapping("/record")
public class RecordController {
	
	@Autowired
	RecordService recordService;
	
	@Autowired
	StaffService staffService;
	
	@GetMapping("/listRecord")
	public String listRecord(ModelMap model) {
		model.addAttribute("record", recordService.findAll());
		return "record/listRecord";
	}
	
	@GetMapping("/insert")
	public String formInsert(ModelMap model) {
		model.addAttribute("record", new Record());
		return "record/insertRecord";
	}
	
	@PostMapping("/insertRecord")
	public String insert(ModelMap model, @ModelAttribute(name = "record") Record record, BindingResult errors) {
		if (record.getType() == null) {
			errors.rejectValue("type", "record", "Vui lòng chọn loại");
		}
		
		if (record.getReason().trim().length() == 0) {
			errors.rejectValue("reason", "record", "Lý do gì, nhập lý do");
		}
		
		if (errors.hasErrors()) {
			return "record/insertRecord";
		} else {
			recordService.save(record);
		}
		
		model.addAttribute("mess", "Insert Sussefully");
		return "record/insertRecord";
	}
	
	@GetMapping("/update/{id}")
	public String updateRecord(ModelMap model, @PathVariable(name = "id") int id) {
		
		Optional<Record> record = recordService.findById(id);
		System.out.println("lay dc id can update");
		if (record.isPresent()) {
			model.addAttribute("record", record.get());
			return "record/updateRecord";
		} else {
			return "record/listRecord";
		}
		
		
	}

	@PostMapping(value = "/update/{id}")
	public String updateDepart(ModelMap model, @ModelAttribute(name = "record") Record record,
			@PathVariable(name = "id") int id, BindingResult errors) {
		if (record.getType() == null) {
			errors.rejectValue("type", "record", "Vui lòng chọn loại");
		}
		
		if (record.getReason().trim().length() == 0) {
			errors.rejectValue("reason", "record", "Lý do gì, nhập lý do");
		}
		
		if (errors.hasErrors()) {
			return "record/updateRecord";
		} else {
			recordService.save(record);
		}
		model.addAttribute("mess", "Update Sussefully");
		return "record/updateRecord";
	}

	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") int id) {
		recordService.deleteById(id);
		return "redirect:/record/listRecord";
	}
	
	@ModelAttribute("staff")
	public List<Staffs> getStaff(){
		return (List<Staffs>) staffService.findAll();
	}
}

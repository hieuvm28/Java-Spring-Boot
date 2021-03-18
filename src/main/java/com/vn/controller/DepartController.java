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

import com.vn.entities.Depart;
import com.vn.service.DepartService;

@Controller
@RequestMapping("/depart")
public class DepartController {
	@Autowired
	DepartService departService;

	@GetMapping("/listDepart")
	public String listDepart(ModelMap model) {
		List<Depart> list = departService.findAll();
		model.addAttribute("listDepart", list);
		System.out.println("Đã lấy được List");
		return "/depart/listDepart";
	}

	@GetMapping("/insert")
	public String insert(ModelMap model) {
		model.addAttribute("depart", new Depart());
		return "depart/insertDepart";
	}

	@PostMapping("/insertDepart")
	public String insert(ModelMap model, @ModelAttribute("depart") Depart depart, BindingResult errors) {

		if (depart.getName().trim().length() == 0) {
			errors.rejectValue("name", "depart", "Nhập tên Phòng ban");
		}

		if (errors.hasErrors()) {
			return "depart/insertDepart";
		} else {
			departService.save(depart);
			System.out.println("Thêm thành công Depart");
			return "redirect:/depart/listDepart";
		}

	}

	@GetMapping("/update/{id}")
	public String updateDepart(ModelMap model, @PathVariable(name = "id") int id) {

		Optional<Depart> depart = departService.findById(id);
		System.out.println("lay dc id can update");
		if (depart.isPresent()) {
			model.addAttribute("depart", depart.get());
			return "depart/updateDepart";
		} else {
			return "depart/insertDepart";
		}

	}

	@PostMapping(value = "/update/{id}")
	public String updateDepart(ModelMap model, @ModelAttribute(name = "depart") Depart depart,
			@PathVariable(name = "id") int id, BindingResult errors) {

		if (depart.getName().trim().length() == 0) {
			errors.rejectValue("name", "depart", "Nhập tên Phòng ban");
		}

		if (errors.hasErrors()) {
			return "depart/insertDepart";
		} else {
			departService.save(depart);
			System.out.println("Update thành công");
		}
		return "redirect:/depart/listDepart";
	}

	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") int id) {
		departService.deleteById(id);
		return "redirect:/depart/listDepart";
	}

	@ModelAttribute("depart")
	public List<Depart> getDepart() {
		List<Depart> list = departService.findAll();
		System.out.println(list.get(0).getName());
		return list;
	}

}

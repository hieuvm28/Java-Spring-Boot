package com.vn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.entities.User;
import com.vn.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String listUser(ModelMap model) {
		model.addAttribute("user", userService.findAll());
		return "user/listUser";
	}

	@GetMapping("/insertUser")
	public String insert(ModelMap model) {
		model.addAttribute("user", new User());
		return "user/insertUser";
	}

	@PostMapping("/insert")
	public String insert(ModelMap model, @ModelAttribute(name = "user") User user, BindingResult errors) {
		
		if (user.getFullname().trim().length() == 0) {
			errors.rejectValue("fullname", "employee", "Không được để trống tên");
		}
		
		if (user.getUsername().trim().length() == 0) {
			errors.rejectValue("username", "employee", "Không được để trống Username");
		} else if (checkUser(user.getUsername())) {
			errors.rejectValue("username", "employee", "Đã tồn tại username");
		}
		
		if (user.getPassword().trim().length() == 0) {
			errors.rejectValue("password", "employee", "Không được để trống Password");
		}
		
		if (errors.hasErrors()) {
			return "user/insertUser";
		} else {
			user.setRole(0);
			userService.save(user);
			model.addAttribute("mess", "Them thanh cong");
		}
	
		return "user/insertUser";
	}

	@GetMapping("/updateUser/{username}")
	public String update(ModelMap model, @PathVariable("username") String username) {
		Optional<User> user = userService.findById(username);
		if (user.isPresent()) {
			model.addAttribute("user", user.get());
		} else {
			model.addAttribute("user", new User());
		}

		return "user/updateUser";
	}

	@PostMapping("/update/{username}")
	public String update(ModelMap model, @ModelAttribute(name = "user") User user,
			@PathVariable(name = "username") String username) {
//		if (errors.hasErrors()) {
//			return "user/updateUser";
//		} else {
//			userService.save(user);
//			model.addAttribute("mess", "Update thanh cong");
//		}
		userService.save(user);
		model.addAttribute("mess", "Update thanh cong");
		return "user/updateUser";
	}

	@GetMapping("delete/{username}")
	public String delete(ModelMap model, @PathVariable(name = "username") String username) {
		userService.deleteById(username);
		return "redirect:/user/";
	}

	public boolean checkUser(String username) {
		Optional<User> model = userService.findById(username);
		if (model.isPresent()) {
			return true;
		}
		return false;
	}

}

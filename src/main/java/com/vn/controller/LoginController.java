package com.vn.controller;

import javax.security.auth.message.config.AuthConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.entities.User;
import com.vn.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String formLogin(ModelMap model) {
		model.addAttribute("auth", new User());
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam(name = "username") String username, @ModelAttribute(name = "auth") User auth,
			@RequestParam(name = "password") String password, BindingResult errors) {

		System.out.println("post");

		if (auth.getUsername().trim() == "") {
			errors.rejectValue("username","auth", "Empty Username");
		}
		if (auth.getPassword().trim() == "") {
			errors.rejectValue("password","auth", "Empty Password");
		}

		if (errors.hasErrors()) {
			return "login";
		} else {
			if (userService.checkLogin(username, password)) {
				return "redirect:/admin";
			} else {
				return "login";
			}

		}

	}

	@GetMapping("/logOut")
	public String logOut() {
		return "redirect:/login";
	}
}

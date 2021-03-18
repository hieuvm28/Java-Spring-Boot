package com.vn.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.entities.Depart;
import com.vn.entities.Staffs;
import com.vn.service.DepartService;
import com.vn.service.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {

	public static String uploadDirectory = System.getProperty("user.dir") + "images";



	@Autowired
	DepartService departService;

	@Autowired
	StaffService staffService;

	@GetMapping("/listStaff")
	public String listStaff(ModelMap model) {
		System.out.println("Da lay dc list Staff");
		model.addAttribute("listStaff", staffService.getStaffByPage(1, 3));

		Long countStaff = staffService.count();
		int countPage = (int) ((countStaff / 3) + 1);
		System.out.println("Tổng số trang: " + countPage);
		model.addAttribute("countPage", countPage);

		return "staff/listEmployee";
	}

	@GetMapping("/listStaff/{page}")
	public String listStaff(ModelMap model, @PathVariable("page") int page) {
		System.out.println("Da lay dc list Staff");
		model.addAttribute("listStaff", staffService.getStaffByPage(page, 3));

		Long countStaff = staffService.count();
		int countPage = (int) ((countStaff / 3) + 1);
		System.out.println("Tổng số trang: " + countPage);
		model.addAttribute("countPage", countPage);

		return "staff/listEmployee";
	}

	@GetMapping("/insert")
	public String insert(ModelMap model) {
		System.out.println("Form insert Staff");
		model.addAttribute("employee", new Staffs());
		return "staff/insertEmployee";
	}

	@PostMapping("/insert")
	public String insert(ModelMap model, @ModelAttribute(name = "employee") Staffs staff, BindingResult errors) {
		System.out.println("insert Staff");

		if (staff.getPhoto().isEmpty()) {
			errors.rejectValue("photo", "employee", "Chon anh");
		}

		if (staff.getName().trim().length() == 0) {
			errors.rejectValue("name", "employee", "Nhap");
		}

//		if(staff.getBirthday().equals(null)) {
//			errors.rejectValue("birthday", "employee", "Birthday Null");
//		}
		
		if (staff.getEmail().trim().length() == 0) {
			errors.rejectValue("email", "employee", "Nhap Email va dung dinh dang");
		} else if (checkEmail(staff.getEmail().trim())) {
			errors.rejectValue("email", "employee", "Email đã tồn tại");
		}

		if (staff.getPhone().trim().length() < 10 || staff.getPhone().trim().length() > 10) {
			errors.rejectValue("phone", "employee", "Nhap so va phai 10 chu so");
		}

		if (staff.getNote().trim().length() == 0) {
			errors.rejectValue("note", "employee", "Nhap ghi chu di");
		}

		if (errors.hasErrors()) {
			return "staff/insertEmployee";
		} else {
			// Paths.get("E:\\Java5\\JAVA5-ASSIGNMENT\\Java5\\src\\main\\webapp\\images/");
			try {

//				InputStream inputStream = file.getInputStream();
//				Files.copy(inputStream, path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

				String fileName = staff.getPhoto();
				if (uploadFile(fileName)) {
					staffService.save(staff);
					System.out.println("Insert thanh cong");
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "redirect:/staff/listStaff";
		}

	}

	@GetMapping("/update/{id}")
	public String updateDepart(ModelMap model, @PathVariable(name = "id") int id) {

		Optional<Staffs> staff = staffService.findById(id);
		System.out.println("lay dc id can update");
		if (staff.isPresent()) {
			model.addAttribute("employee", staff.get());
			return "staff/updateEmployee";
		} else {
			return "staff/listEmployee";
		}

	}

	@PostMapping(value = "/update/{id}")
	public String updateDepart(ModelMap model, @ModelAttribute(name = "employee") Staffs staff,
			@PathVariable(name = "id") int id, BindingResult errors) throws IOException {

		if (staff.getPhoto().isEmpty()) {
			errors.rejectValue("photo", "employee", "Chon anh");
		}

		if (errors.hasErrors()) {
			return "staff/updateEmployee";
		} else {
			String fileName = staff.getPhoto();
			if (uploadFile(fileName)) {
				staffService.save(staff);
			}
		}
		return "redirect:/staff/listStaff";
	}

	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") int id) {
		staffService.deleteById(id);
		return "redirect:/staff/listStaff";
	}

	@ModelAttribute("depart")
	public List<Depart> getDepart() {
		List<Depart> list = departService.findAll();
		System.out.println(list.get(0).getName());
		return list;
	}

	@GetMapping("/search")
	public String findByName(ModelMap model, @RequestParam("name") String name) {
		List<Staffs> list = staffService.getStaffByName(name);

		model.addAttribute("listStaff", list);
		return "staff/listEmployee";

	}

	public boolean uploadFile(String fileName) throws IOException {
		File file = new File(fileName);
		System.out.println("Ten file: " + file.getName());
		System.out.println("Path trước khi thêm: " + file.getAbsolutePath());
		File dir = new File("E:\\Java5\\JAVA5-ASSIGNMENT\\Java5\\src\\main\\webapp/images");
		// Tạo thư mục nếu chưa tồn tại
		if (!dir.exists()) {
			dir.mkdirs();
		}

		File newFile = new File(dir, file.getName());
		System.out.println("Ten file sau khi thêm: " + newFile.getAbsolutePath());
		System.out.println("");
		Path source = Paths.get("C:\\Users\\ADMIN\\Desktop/" + file.getName());
		System.out.println("soure: " + source);

		Path destination = Paths.get(newFile.getAbsolutePath());
		System.out.println("Des: " + destination);

		System.out.println("Bắt đầu copy ảnh");
		Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);

		System.out.println("Đã chuyển vào folder");
		return true;
	}

	public boolean checkEmail(String email) {
		List<Staffs> list = staffService.getStaffByEmail(email);
		if (list.size() > 0) {
			return true;
		}

		return false;
	}

}

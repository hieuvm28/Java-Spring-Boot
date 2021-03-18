package com.vn.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vn.entities.Staffs;
import com.vn.service.StaffService;



@Controller
public class UploadFileController {
	@Autowired
	private StaffService staffService;

	@RequestMapping(value = "images/{photo}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getImage(@PathVariable(name = "photo") String photo) {
		
		if (!photo.equals("") || photo != null) {
			try {
		 		Path filename = Paths.get("E:\\Java5\\JAVA5-ASSIGNMENT\\Java5\\src\\main\\webapp\\images/", photo);
				byte[] buffer = Files.readAllBytes(filename);

				ByteArrayResource brs = new ByteArrayResource(buffer);
				return ResponseEntity.ok().contentLength(buffer.length)
						.contentType(MediaType.parseMediaType("image/**")).body(brs);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return ResponseEntity.badRequest().build();
	}
	
}


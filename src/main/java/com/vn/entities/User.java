package com.vn.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Table(name = "	Users")
@Component
public class User implements Serializable{
	
	@Id
	@Column(name = "username")
	//@NotBlank(message = "Không được để trống Username")
	private String username;
	
	//@NotBlank(message = "Không được để trống Password")
	@Column(name = "password")
	private String password;
	
	//@NotBlank(message = "Không được để trống Fullname")
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "role")
	private int role;
	
}

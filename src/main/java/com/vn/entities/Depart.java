package com.vn.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Table(name = "Departs")
@Component
public class Depart implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "namedepart")
	//@NotBlank(message = "Không được để trống tên phòng ban")
	private String name;

	@OneToMany(mappedBy = "depart", fetch = FetchType.EAGER)
	private Collection<Staffs> staff;

}

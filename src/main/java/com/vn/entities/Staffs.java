package com.vn.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Table(name="Staffs")
@Component
public class Staffs implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	//@NotBlank(message = "Không được để trống tên")
	private String name;
	
	//@NotNull(message = "Vui lòng chọn giới tính")
	private boolean gender;
	
	//@NotNull(message = "Chọn ngày sinh")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
	
	//@NotBlank(message = "Chọn ảnh đi")
	private String photo;
	
	//@NotBlank(message = "Quên Email à")
	//@Email(message = "Đúng định dạng Email")
	private String email;
	
	//@NotBlank(message = "Không Sđt gọi điện kiểu gì")
	private String phone;
	
	//@NotBlank(message = "Làm free à")
	private double salary;
	
	//@NotBlank(message = "Ghi chú")
	private String note;
	
	
	@OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
	private Collection<Record> record;
	
	@ManyToOne
	@JoinColumn(name = "departid")
	private Depart depart;

	@Override
	public String toString() {
		return this.birthday.toString();
	}
	
	
	
}

package com.customs.entity;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    @NotEmpty(message = "姓名不可为空")
    private String name;

    @Size(min = 6, max = 20, message = "密码长度为6~20")
    private String password;

    @NotNull(message = "年龄不可为空")
    @Min(value = 0, message = "年龄最小为0")
    @Max(value = 150, message = "年龄最大为150")
    private Integer age;

    private String address;

    @Email(message = "邮箱有误")
    private String email;

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password == null ? null : password.trim();
    }

    public Integer getAge() {
	return age;
    }

    public void setAge(Integer age) {
	this.age = age;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address == null ? null : address.trim();
    }
}
package com.customs.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private String password;

    private Integer age;

    private String address;

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
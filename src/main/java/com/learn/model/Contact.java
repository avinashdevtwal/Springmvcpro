package com.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
 @Table(name="CONTACT")
public class Contact {
 @Id 
 @GeneratedValue(strategy =GenerationType.IDENTITY)
	private int cid; 
private String name; 
private String secondname;  
private String work; 
private String cemail; 
private String phone; 
 @Column(length=1000)
private String describtion;
 @ManyToOne
 private User user;
 
 
 
 public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSecondname() {
	return secondname;
}
public void setSecondname(String secondname) {
	this.secondname = secondname;
}
public String getWork() {
	return work;
}
public void setWork(String work) {
	this.work = work;
}
public String getcEmail() {
	return cemail;
}
public void setEmail(String cemail) {
	this.cemail = cemail;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getDescribtion() {
	return describtion;
}
public void setDescribtion(String describtion) {
	this.describtion = describtion;
}
 
}

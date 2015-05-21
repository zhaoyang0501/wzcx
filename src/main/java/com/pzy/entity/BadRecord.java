package com.pzy.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.struts2.json.annotations.JSON;

@Entity
@Table(name = "t_badrecord")
public class BadRecord {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.EAGER)
	private Car car;
	private Date createDate;
	private String address;
	@ManyToOne(fetch = FetchType.EAGER)
	private BadRecordType badRecordType;
	private String state;
	private String license;
	private Date cleanDate;
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public Date getCleanDate() {
		return cleanDate;
	}
	public void setCleanDate(Date cleanDate) {
		this.cleanDate = cleanDate;
	}
	public BadRecordType getBadRecordType() {
		return badRecordType;
	}
	public void setBadRecordType(BadRecordType badRecordType) {
		this.badRecordType = badRecordType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@JSON(format="yyyy-MM-dd")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}

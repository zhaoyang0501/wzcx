package com.pzy.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.pzy.entity.BadRecord;
import com.pzy.entity.Car;
import com.pzy.service.BadRecordService;
import com.pzy.service.CarService;

@Namespace("/badrecord")
@ParentPackage("json-default") 
public class BadRecordAction extends PageAction {
	private String name;
	private Long id;
	private BadRecord badRecord;
	private List<BadRecord> badRecords;
	private  List<Car> cars;
	@Autowired
	private BadRecordService badRecordService;
	@Autowired
	private CarService carService;

	@Action(value = "list", results = { @Result(name = "success", type = "json",params={"ignoreHierarchy","false"}) })  
	public String list() {
		int pageNumber = (int) (this.getIDisplayStart() / this.getIDisplayLength()) + 1;
		int pageSize =  this.getIDisplayLength();
		Car car=carService.find(name);
		Page<BadRecord> list= badRecordService.findAll(pageNumber, pageSize,car);
		this.getResultMap().put("aaData", car==null?new ArrayList():list.getContent());
		this.getResultMap().put("iTotalRecords", list.getTotalElements());
		this.getResultMap().put("iTotalDisplayRecords", list.getTotalElements());
		this.getResultMap().put("sEcho", getSEcho());
		return SUCCESS;
	}
	@Action(value = "licenselist", results = { @Result(name = "success", type = "json",params={"ignoreHierarchy","false"}) })  
	public String licenselist() {
		int pageNumber = (int) (this.getIDisplayStart() / this.getIDisplayLength()) + 1;
		int pageSize =  this.getIDisplayLength();
		Page<BadRecord> list= badRecordService.findAll(pageNumber, pageSize,name);
		this.getResultMap().put("aaData", list.getContent());
		this.getResultMap().put("iTotalRecords", list.getTotalElements());
		this.getResultMap().put("iTotalDisplayRecords", list.getTotalElements());
		this.getResultMap().put("sEcho", getSEcho());
		return SUCCESS;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public BadRecord getBadRecord() {
		return badRecord;
	}

	public void setBadRecord(BadRecord badRecord) {
		this.badRecord = badRecord;
	}

	public List<BadRecord> getBadRecords() {
		return badRecords;
	}

	public void setBadRecords(List<BadRecord> badRecords) {
		this.badRecords = badRecords;
	}
	
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
}

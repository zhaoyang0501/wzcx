package com.pzy.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.pzy.action.PageAction;
import com.pzy.entity.BadRecord;
import com.pzy.entity.BadRecordType;
import com.pzy.entity.Car;
import com.pzy.entity.Category;
import com.pzy.entity.Load;
import com.pzy.service.BadRecordService;
import com.pzy.service.BadRecordTypeService;
import com.pzy.service.CarService;
import com.pzy.service.CategoryService;
import com.pzy.service.LoadService;

@Namespace("/admin/badrecord")
@ParentPackage("json-default") 
public class BadRecordAction extends PageAction {
	private String name;
	private Long id;
	private BadRecord badRecord;
	private List<BadRecord> badRecords;
	private  List<Car> cars;
	private List<BadRecordType> badRecordTypes;
	@Autowired
	private BadRecordService badRecordService;
	@Autowired
	private CarService carService;
	@Autowired
	private BadRecordTypeService badRecordTypeService;
	@Action(value = "index", results = { @Result(name = "success", location = "/WEB-INF/views/admin/badrecord/index.jsp") })
	public String index() {
		badRecordTypes=badRecordTypeService.findAll();
		cars=this.carService.findAll();
		return SUCCESS;
	}

	@Action(value = "list", results = { @Result(name = "success", type = "json",params={"ignoreHierarchy","false"}) })  
	public String list() {
		int pageNumber = (int) (this.getIDisplayStart() / this.getIDisplayLength()) + 1;
		int pageSize =  this.getIDisplayLength();
		
		Page<BadRecord> list = badRecordService.findAll(pageNumber, pageSize,carService.find(name));
		this.getResultMap().put("aaData", list.getContent());
		this.getResultMap().put("iTotalRecords", list.getTotalElements());
		this.getResultMap().put("iTotalDisplayRecords", list.getTotalElements());
		this.getResultMap().put("sEcho", getSEcho());
		return SUCCESS;
	}

	@Action(value = "delete", results = { @Result(name = "success", type = "json",params={"ignoreHierarchy","false"}) })  
	public String delete() {
		badRecordService.delete(id);
		getResultMap().put("state", "success");
		getResultMap().put("msg", "删除成功");
		return SUCCESS;
	}

	@Action(value = "get", results = { @Result(name = "success", type = "json",params={"ignoreHierarchy","false"}) })  
	public String get() {
		getResultMap().put("object", badRecordService.find(id));
		getResultMap().put("state", "success");
		getResultMap().put("msg", "删除成功");
		return SUCCESS;
	}

	@Action(value = "update", results = { @Result(name = "success",  type = "json",params={"ignoreHierarchy","false"}) })  
	public String update() {
		BadRecord bean = badRecordService.find(badRecord.getId());
		BeanUtils.copyProperties(badRecord, bean);
		badRecordService.save(badRecord);
		getResultMap().put("state", "success");
		getResultMap().put("msg", "修改成功");
		return SUCCESS;
	}
	@Action(value = "save", results = { @Result(name = "success",  type = "json",params={"ignoreHierarchy","false"}) })  
	public String saveit() {
		badRecordService.save(badRecord);
		getResultMap().put("state", "success");
		getResultMap().put("msg", "保存成功");
		return SUCCESS;
	}
	
	public List<BadRecordType> getBadRecordTypes() {
		return badRecordTypes;
	}

	public void setBadRecordTypes(List<BadRecordType> badRecordTypes) {
		this.badRecordTypes = badRecordTypes;
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

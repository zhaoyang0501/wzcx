package com.pzy.action.admin;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.pzy.action.PageAction;
import com.pzy.entity.Accident;
import com.pzy.entity.Car;
import com.pzy.entity.Load;
import com.pzy.service.AccidentService;
import com.pzy.service.CarService;
import com.pzy.service.LoadService;

@Namespace("/admin/accident")
@ParentPackage("json-default") 
public class AccidentAction extends PageAction {
	private String name;
	private Date start;
	private Date end;
	private Long id;
	private Accident accident;
	private List<Accident> accidents;
	private List<Car> cars;
	private List<Load> loads;
	@Autowired
	private AccidentService accidentService;
	@Autowired
	private CarService carService;
	@Autowired
	private LoadService loadService;
	@Action(value = "index", results = { @Result(name = "success", location = "/WEB-INF/views/admin/accident/index.jsp") })
	public String index() {
		cars=this.carService.findAll();
		loads=loadService.findAll();
		return SUCCESS;
	}

	@Action(value = "list", results = { @Result(name = "success", type = "json",params={"ignoreHierarchy","false"}) })  
	public String list() {
		int pageNumber = (int) (this.getIDisplayStart() / this.getIDisplayLength()) + 1;
		int pageSize =  this.getIDisplayLength();
		Page<Accident> list = accidentService.findAll(pageNumber, pageSize,start,end);
		this.getResultMap().put("aaData", list.getContent());
		this.getResultMap().put("iTotalRecords", list.getTotalElements());
		this.getResultMap().put("iTotalDisplayRecords", list.getTotalElements());
		this.getResultMap().put("sEcho", getSEcho());
		return SUCCESS;
	}

	@Action(value = "delete", results = { @Result(name = "success", type = "json",params={"ignoreHierarchy","false"}) })  
	public String delete() {
		accidentService.delete(id);
		getResultMap().put("state", "success");
		getResultMap().put("msg", "删除成功");
		return SUCCESS;
	}

	@Action(value = "get", results = { @Result(name = "success", type = "json",params={"ignoreHierarchy","false"}) })  
	public String get() {
		getResultMap().put("object", accidentService.find(id));
		getResultMap().put("state", "success");
		getResultMap().put("msg", "删除成功");
		return SUCCESS;
	}

	@Action(value = "update", results = { @Result(name = "success",  type = "json",params={"ignoreHierarchy","false"}) })  
	public String update() {
		Accident bean = accidentService.find(accident.getId());
		BeanUtils.copyProperties(accident, bean);
		accidentService.save(accident);
		getResultMap().put("state", "success");
		getResultMap().put("msg", "修改成功");
		return SUCCESS;
	}
	@Action(value = "save", results = { @Result(name = "success",  type = "json",params={"ignoreHierarchy","false"}) })  
	public String saveit() {
		accidentService.save(accident);
		getResultMap().put("state", "success");
		getResultMap().put("msg", "保存成功");
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
	public Accident getAccident() {
		return accident;
	}

	public void setAccident(Accident accident) {
		this.accident = accident;
	}

	public List<Accident> getAccidents() {
		return accidents;
	}

	public void setAccidents(List<Accident> accidents) {
		this.accidents = accidents;
	}
	
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Load> getLoads() {
		return loads;
	}

	public void setLoads(List<Load> loads) {
		this.loads = loads;
	}
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
}

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
import com.pzy.entity.Car;
import com.pzy.entity.Category;
import com.pzy.service.CarService;
import com.pzy.service.CategoryService;

@Namespace("/admin/car")
@ParentPackage("json-default") 
public class CarAction extends PageAction {
	private String name;
	private String id;
	private Car car;
	private List<Car> cars;
	private List<Category> categorys;
	@Autowired
	private CarService carService;
	@Autowired
	private CategoryService categoryService;
	@Action(value = "index", results = { @Result(name = "success", location = "/WEB-INF/views/admin/car/index.jsp") })
	public String index() {
		categorys=categoryService.findCategorys();
		return SUCCESS;
	}

	@Action(value = "list", results = { @Result(name = "success", type = "json",params={"ignoreHierarchy","false"}) })  
	public String list() {
		int pageNumber = (int) (this.getIDisplayStart() / this.getIDisplayLength()) + 1;
		int pageSize =  this.getIDisplayLength();
		Page<Car> list = carService.findAll(pageNumber, pageSize,name);
		this.getResultMap().put("aaData", list.getContent());
		this.getResultMap().put("iTotalRecords", list.getTotalElements());
		this.getResultMap().put("iTotalDisplayRecords", list.getTotalElements());
		this.getResultMap().put("sEcho", getSEcho());
		return SUCCESS;
	}

	@Action(value = "delete", results = { @Result(name = "success", type = "json",params={"ignoreHierarchy","false"}) })  
	public String delete() {
		carService.delete(id);
		getResultMap().put("state", "success");
		getResultMap().put("msg", "删除成功");
		return SUCCESS;
	}

	@Action(value = "get", results = { @Result(name = "success", type = "json",params={"ignoreHierarchy","false"}) })  
	public String get() {
		getResultMap().put("object", carService.find(id));
		getResultMap().put("state", "success");
		getResultMap().put("msg", "删除成功");
		return SUCCESS;
	}

	@Action(value = "update", results = { @Result(name = "success",  type = "json",params={"ignoreHierarchy","false"}) })  
	public String update() {
		Car bean = carService.find(car.getId());
		BeanUtils.copyProperties(car, bean);
		carService.save(bean);
		getResultMap().put("state", "success");
		getResultMap().put("msg", "修改成功");
		return SUCCESS;
	}
	@Action(value = "save", results = { @Result(name = "success",  type = "json",params={"ignoreHierarchy","false"}) })  
	public String save() {
		carService.save(car);
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

}

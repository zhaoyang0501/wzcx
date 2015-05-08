package com.pzy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_accident")
public class Accident {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String type;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="load_")
	private Load Load;
	private Date createDate;
	private String remark;
	@ManyToOne(fetch = FetchType.EAGER)
	private Car car;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Load getLoad() {
		return Load;
	}
	public void setLoad(Load load) {
		Load = load;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
}

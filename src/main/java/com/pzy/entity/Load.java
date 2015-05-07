package com.pzy.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_load")
public class Load {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String oneway;
	public String getOneway() {
		return oneway;
	}
	public void setOneway(String oneway) {
		this.oneway = oneway;
	}
	private String way;
	private Double maxspeed;
	private Double minspeed;
	private String remark;
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
		this.name = name;
	}
	public String getWay() {
		return way;
	}
	public void setWay(String way) {
		this.way = way;
	}
	public Double getMaxspeed() {
		return maxspeed;
	}
	public void setMaxspeed(Double maxspeed) {
		this.maxspeed = maxspeed;
	}
	public Double getMinspeed() {
		return minspeed;
	}
	public void setMinspeed(Double minspeed) {
		this.minspeed = minspeed;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}

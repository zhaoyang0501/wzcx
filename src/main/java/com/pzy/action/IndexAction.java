package com.pzy.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")  
@Namespace("/")
public class IndexAction extends ActionSupport{
	public String execute() throws Exception {
		return SUCCESS;
	}
	@Action(value = "load", results = { @Result(name = "success", location = "/WEB-INF/views/load.jsp") })
	public String load() throws Exception {
		return SUCCESS;
	}
	@Action(value = "badrecord", results = { @Result(name = "success", location = "/WEB-INF/views/badrecord.jsp") })
	public String badrecord() throws Exception {
		return SUCCESS;
	}
	@Action(value = "news", results = { @Result(name = "success", location = "/WEB-INF/views/news.jsp") })
	public String news() throws Exception {
		return SUCCESS;
	}
	@Action(value = "notice", results = { @Result(name = "success", location = "/WEB-INF/views/notice.jsp") })
	public String notice() throws Exception {
		return SUCCESS;
	}
}

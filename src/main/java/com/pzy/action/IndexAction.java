package com.pzy.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.pzy.entity.News;
import com.pzy.entity.Notice;
import com.pzy.service.NewsService;
import com.pzy.service.NoticeService;

@ParentPackage("struts-default")  
@Namespace("/")
public class IndexAction extends ActionSupport{
	private Long id;
	private News news;
	private Notice notice;
	
	@Autowired
	private NewsService newsService;
	@Autowired
	private NoticeService noticeService;
	
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
	
	@Action(value = "newsdetail", results = { @Result(name = "success", location = "/WEB-INF/views/newsdetail.jsp") })
	public String newsdetail() throws Exception {
		news=newsService.find(id);
		return SUCCESS;
	}
	@Action(value = "noticedetail", results = { @Result(name = "success", location = "/WEB-INF/views/noticedetail.jsp") })
	public String noticedetail() throws Exception {
		notice=noticeService.find(id);
		return SUCCESS;
	}
	@Action(value = "notice", results = { @Result(name = "success", location = "/WEB-INF/views/notice.jsp") })
	public String notice() throws Exception {
		return SUCCESS;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}

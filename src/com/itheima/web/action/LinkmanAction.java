package com.itheima.web.action;

import com.itheima.domain.Linkman;
import com.itheima.service.CustomerService;
import com.itheima.service.LinkmanService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman> {

	private Linkman linkman = new Linkman();
	@Override
	public Linkman getModel() {
		return linkman;
	}
	private LinkmanService linkmanService;
	public void setLinkmanService(LinkmanService linkmanService) {
		this.linkmanService = linkmanService;
	}

	public String saveUI() {
		List<Customer> list = CustomerService.findAll();
		return "saveUI";
	}

}

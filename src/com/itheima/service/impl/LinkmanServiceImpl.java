package com.itheima.service.impl;

import com.itheima.dao.LinkmanDao;
import com.itheima.service.LinkmanService;

public class LinkmanServiceImpl implements LinkmanService {
	private LinkmanDao linkmanDao;
	public void setLinkmanDao(LinkmanDao linkmanDao) {
		this.linkmanDao = linkmanDao;
	}
}

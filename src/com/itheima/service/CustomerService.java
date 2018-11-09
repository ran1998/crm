package com.itheima.service;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.Customer;
import com.itheima.domain.PageBean;
import com.itheima.web.action.List;

public interface CustomerService {

	void save(Customer customer);

	PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer pageSize, Integer currentPage);

	Customer findById(long cust_id);

	void update(Customer customer);

	void delete(Customer customer);

	static List<com.itheima.web.action.Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


}

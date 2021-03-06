package com.itheima.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.domain.PageBean;
import com.itheima.service.CustomerService;


@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
		
	}
	@Override
	public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer pageSize, Integer currentPage) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		// 设置每页显示条数
		pageBean.setPageSize(pageSize);
		// 当前第几页
		pageBean.setCurrentPage(currentPage);
		// 总条数
		Integer totalCount = customerDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		// 总页数
		Double tc = totalCount.doubleValue();
		Double totalPage = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		// list
		int begin = (currentPage - 1)*pageSize;
		List<Customer> list = customerDao.findByPage(detachedCriteria, begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public Customer findById(long cust_id) {
		return customerDao.finById(cust_id);
		
	}
	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
		
	}
	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
		
	}
	
	public List<Customer> findAll() {
		return customerDao.findAll();
	}
	
}

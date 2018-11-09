package com.itheima.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.Customer;

public interface CustomerDao {

	void save(Customer customer);

	Integer findCount(DetachedCriteria detachedCriteria);

	List<Customer> findByPage(DetachedCriteria detachedCriteria, int begin, Integer pageSize);

	Customer finById(long cust_id);

	void update(Customer customer);

	void delete(Customer customer);

}

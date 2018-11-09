package com.itheima.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.itheima.domain.Customer;
import com.itheima.domain.PageBean;
import com.itheima.service.CustomerService;
import com.itheima.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private Integer pageSize=3;
	private Integer currentPage=1;
	
	public void setPageSize(Integer pageSize) {
		if (null == pageSize) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}
	public void setCurrentPage(Integer currentPage) {
		if (null == currentPage) {
			currentPage = 1;
		}
		this.currentPage = currentPage;
	}

	public String saveUI() {
		return "saveUI";
	}
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName; // 文件名称
	
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	public String save() throws IOException {
		if (null != upload) {
			String filename = UploadUtils.getUuidFileName(uploadFileName);
			String realPath = "F:/upload" + UploadUtils.getPathName(filename);
			File file = new File(realPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			
			File dictFile = new File(realPath + "/" + filename);
			FileUtils.copyFile(upload, dictFile);
			customer.setCust_image(realPath + "/" + filename);
		}
		customerService.save(customer);
		return "saveSuccess";
	}
	
	public String edit() {
		System.out.println(789);
		customer =  customerService.findById(customer.getCust_id());
		return "editSuccess";
	}
	
	public String update() throws IOException {
		if (null != upload) {
			if (null != customer.getCust_image()) {
				File file = new File(customer.getCust_image());
				if (file.exists()) {
					file.delete();
				}
			}
			String filename = UploadUtils.getUuidFileName(uploadFileName);
			String realPath = "F:/upload" + UploadUtils.getPathName(filename);
			File file = new File(realPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			
			File dictFile = new File(realPath + "/" + filename);
			FileUtils.copyFile(upload, dictFile);
			customer.setCust_image(realPath + "/" + filename);
		}
		customerService.update(customer);
		return "updateSuccess";
	}
	
	public String delete() {
		customer = customerService.findById(customer.getCust_id());
		if (null != customer.getCust_image()) {
			File file = new File(customer.getCust_image());
			if (file.exists()) {
				file.delete();
			}
		}
		customerService.delete(customer);
		return "deleteSuccess";
	}
	
	public String findAll() {
		System.out.println(customer);
		DetachedCriteria detachedCriteria= DetachedCriteria.forClass(customer.getClass());
		if (null != customer.getCust_name() && !"".equals(customer.getCust_name())) {
			detachedCriteria.add(Restrictions.like("cust_name", "%"+ customer.getCust_name() + "%"));
		}
		if (null != customer.getDictSource()) {
			if (customer.getDictSource().getDict_id() != 0 && !"".equals(customer.getDictSource().getDict_id())) {
				detachedCriteria.add(Restrictions.eq("dictSource.dict_id", customer.getDictSource().getDict_id()));
			}
		}
		if (null != customer.getDictIndustry()) {
			if (customer.getDictIndustry().getDict_id() != 0 && !"".equals(customer.getDictIndustry().getDict_id())) {
				detachedCriteria.add(Restrictions.eq("dictIndustry.dict_id", customer.getDictIndustry().getDict_id()));
			}
		}
		if (null != customer.getDictLevel()) {
			if (customer.getDictLevel().getDict_id() != 0 && !"".equals(customer.getDictLevel().getDict_id())) {
				detachedCriteria.add(Restrictions.eq("dictLevel.dict_id", customer.getDictLevel().getDict_id()));
			}
		}
		PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria, pageSize, currentPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

}

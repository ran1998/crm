package com.itheima.domain;

public class Linkman {
	/*CREATE TABLE `cst_linkman` (
			  `lkm_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '联系人编号(主键)',
			  `lkm_name` varchar(16) DEFAULT NULL COMMENT '联系人姓名',
			  `lkm_cust_id` bigint(32) NOT NULL COMMENT '客户id',
			  `lkm_gender` char(1) DEFAULT NULL COMMENT '联系人性别',
			  `lkm_phone` varchar(16) DEFAULT NULL COMMENT '联系人办公电话',
			  `lkm_mobile` varchar(16) DEFAULT NULL COMMENT '联系人手机',
			  `lkm_email` varchar(64) DEFAULT NULL COMMENT '联系人邮箱',
			  `lkm_qq` varchar(16) DEFAULT NULL COMMENT '联系人qq',
			  `lkm_position` varchar(16) DEFAULT NULL COMMENT '联系人职位',
			  `lkm_memo` varchar(512) DEFAULT NULL COMMENT '联系人备注',
			  PRIMARY KEY (`lkm_id`),
			  KEY `FK_cst_linkman_lkm_cust_id` (`lkm_cust_id`),
			  CONSTRAINT `FK_cst_linkman_lkm_cust_id` FOREIGN KEY (`lkm_cust_id`) REFERENCES `cst_customer` (`cust_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
			) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;*/
	private long lkm_id;
	private String lkm_name;
	private String lkm_cust_id;
	private String lkm_gender;
	private String lkm_phone;
	private String lkm_mobile;
	private String lkm_email;
	private String lkm_qq;
	private String lkm_position;
	private String lkm_memo;
	
	private Customer customer;
}

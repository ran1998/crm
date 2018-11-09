package com.itheima.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.BaseDict;
import com.itheima.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict>{

	private BaseDict baseDict = new BaseDict();
	@Override
	public BaseDict getModel() {
		return baseDict;
	}
	
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	
	
	public String findByTypeCode() throws IOException {
		System.out.println(123);
		List<BaseDict> list = baseDictService.findByTypeCode(baseDict.getDict_type_code());
		/*
		 * JSONConfig: 转json配置对象
		 * JSONArray: 将数组list集合转化为json对象
		 * JSONObject: 将map和Object转化为json对象
		 * */
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] {""});
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(jsonArray.toString());
		return NONE;
	}

}

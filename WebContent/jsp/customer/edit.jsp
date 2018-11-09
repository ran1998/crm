<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
$(function() {
	$.post('${pageContext.request.contextPath}/baseDict_findByTypeCode.action', {dict_type_code: "002"}, function(data) {
		$(data).each(function (i, obj) {	
			$("#custSource").append("<option value="+obj.dict_id+">"+obj.dict_item_name+"</option>");
		})
		$("#custSource option[value='${model.dictSource.dict_id}']").attr("selected","selected");
	}, 'json')
	
	$.post('${pageContext.request.contextPath}/baseDict_findByTypeCode.action', {dict_type_code: "001"}, function(data) {
		$(data).each(function (i, obj) {	
			$("#custIndustry").append("<option value="+obj.dict_id+">"+obj.dict_item_name+"</option>");
		})
		$("#custIndustry option[value='${model.dictIndustry.dict_id}']").attr("selected","selected");
	}, 'json')
	
	$.post('${pageContext.request.contextPath}/baseDict_findByTypeCode.action', {dict_type_code: "006"}, function(data) {
		$(data).each(function (i, obj) {	
			$("#custLevel").append("<option value="+obj.dict_id+">"+obj.dict_item_name+"</option>");
		})
		$("#custLevel option[value='${model.dictLevel.dict_id}']").attr("selected","selected");
	}, 'json')
})
</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/customer_update.action"
		method=post enctype="multipart/form-data">
		<input type="hidden" name="cust_id" value="<s:property value="model.cust_id"/>"/>
		<s:debug/>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 添加客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_name" value="<s:property value="model.cust_name"/>">
								</td>
								<td>客户级别 ：</td>
								<td>
									<select name="dictLevel.dict_id" id="custLevel"></select>
								</td>
							</TR>
							
							<TR>
								
								<td>信息来源 ：</td>
								<td>
									<select name="dictSource.dict_id" id="custSource"></select>
								</td>
								<td>所属行业 ：</td>
								<td>
									<select name="dictIndustry.dict_id" id="custIndustry"></select>
								</td>
							</TR>
							
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_phone" value="<s:property value="model.cust_phone"/>">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_mobile" value="<s:property value="model.cust_mobile"/>">
								</td>
							</TR>
							<tr>
								<td></td>
								<td>
								<input type="file" name="upload"/></td>
							</tr>
							
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="<s:property value="model.cust_image"/>">
					<IMG src="<s:property value="model.cust_image"/>" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>

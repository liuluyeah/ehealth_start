<!-- 我的门诊页面病人分组，维护诊疗计到patient_detail列表--byliulu -->
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<% 
request.setCharacterEncoding("UTF-8"); 
response.setCharacterEncoding("UTF-8"); 
response.setContentType("text/html; charset=utf-8"); 
%>
    <% 
      String medicine = request.getParameter("YYYY");//药品名称
      String num = request.getParameter("MM");//药品数量
      String fre = request.getParameter("DD");//药品频率
      String remark = request.getParameter("remark");//备注
      String demand = request.getParameter("demand");//下次随访要求
      String medicinetime = request.getParameter("medicinetime");
      String medicinetel = request.getParameter("medicinetel");
      String intpage = request.getParameter("intpage");
    %>
<html>
<head>
<title>往数据库插入数据</title>
</head>
	<body>
		<sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://101.201.40.158:3306/ehealth?useUnicode=true&characterEncoding=gbk" user="root" password="123456" />
		<c:catch var="error">
		<c:set var="medicine" value="<%=medicine%>"/><c:set var="num" value="<%=num%>"/><c:set var="fre" value="<%=fre%>"/>
		<c:set var="remark" value="<%=remark%>"/><c:set var="demand" value="<%=demand%>"/>
		<c:set var="time" value="<%=medicinetime%>" /><c:set var="tel" value="<%=medicinetel%>" />
			<sql:update>
			update patient_detail set medicine = ? , num=? , fre=? , remark=? , demand=? where time=? and tel=?
			<sql:param value="${medicine}"/><sql:param value="${num}"/><sql:param value="${fre}"/><sql:param value="${remark}"/><sql:param value="${demand}"/>
			<sql:param value="${time}" /><sql:param value="${tel}" />
			</sql:update>
			<sql:update>
			update mypatient set medicine = ? where tell=?
			<sql:param value="${medicine}" /> <sql:param value="${tel}" />
			</sql:update>
		</c:catch>
		<c:out value="${error}"></c:out><br>
		<c:redirect url="/doctorPatient.jsp">
		  <c:param name="page" value="<%=intpage%>"><%=intpage%></c:param>
		</c:redirect>
		<c:set var="temp" value="value" scope="session"></c:set>
	</body>
</html>
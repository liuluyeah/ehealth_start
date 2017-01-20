<!-- 我的门诊页面病人分组，插入组别到clinic_assistant列表--byliulu -->
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
      String group = request.getParameter("radio");
      String groupid = request.getParameter("groupid");
      String intpage = request.getParameter("intpage");
    %>
<html>
<head>
<title>往数据库插入数据</title>
</head>
	<body>
		<sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://101.201.40.158:3306/ehealth?useUnicode=true&characterEncoding=gbk" user="root" password="123456" />
		<c:catch var="error">
		<c:set var="group" value="<%=group %>" />
		<c:set var="id" value="<%=groupid%>" />
			<sql:update>
			update mypatient set divide = ? where idmypatient=?
			<sql:param value="${group}" /> <sql:param value="${id}" />
			</sql:update>
		</c:catch>
		<c:out value="${error}"></c:out><br>
		<c:redirect url="/doctorPatient.jsp">
		  <c:param name="page" value="<%=intpage %>"><%=intpage %></c:param>
		</c:redirect>
		<c:set var="temp" value="value" scope="session"></c:set>
	</body>
</html>
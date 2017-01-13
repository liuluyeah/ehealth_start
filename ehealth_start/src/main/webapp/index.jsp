<%@ page language="java" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<% 
 request.setCharacterEncoding("UTF-8"); 
 response.setCharacterEncoding("UTF-8"); 
 response.setContentType("text/html; charset=UTF-8"); 
%>  
<html>
<head>
<meta http-equiv="Content-Type"content="text/html; charset=utf-8"/>
<title>sql test</title>
<style type="text/css">

td{


font-size:12px;


background-color:#C6E9FD;

}
</style>
</head>
<body>
<h2>Hello World 2017 !</h2>
${user1.name} ${user1.sex} ${user1.tel} 
<c:out value="&lt要显示的数据对象（使用转义字符）&gt" escapeXml="false" default="默认值"></c:out><br/>
<c:catch var="ex">
<sql:setDataSource var="dataSour" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://101.201.40.158:3306/ehealth" user="root" password="123456"/>
</c:catch>
<c:if test="${ex != null}">
数据库连接失败，请联系管理员！
</c:if>
<!-- 数据读取 -->
<sql:query var="userlist" dataSource="${dataSour}" sql="SELECT * FROM user"/>
<table width="80%" align="center" cellspacing="1" cellpadding="1" style="border-bottom:0px; background-color:#8080FF">
<tr>
 <td width="10%" align="center" style="background-color:#8080FF; font-size:14px;color:#FFFFFF; border:1px #FFFFFF solid;"height="25">编号</td>
 <td width="14%" align="center" style="background-color:#8080FF; font-size:14px;color:#FFFFFF; border:1px #FFFFFF solid;">电话</td>
 <td width="11%" align="center" style="background-color:#8080FF; font-size:14px;color:#FFFFFF; border:1px #FFFFFF solid;">密码</td>
 <td width="11%" align="center" style="background-color:#8080FF; font-size:14px;color:#FFFFFF; border:1px #FFFFFF solid;">身份</td>
 <td width="12%" align="center" style="background-color:#8080FF; font-size:14px;color:#FFFFFF; border:1px #FFFFFF solid;">姓名</td>
 <td width="32%" align="center" style="background-color:#8080FF; font-size:14px;color:#FFFFFF; border:1px #FFFFFF solid;">性别</td>
 <td width="10%" align="center" style="background-color:#8080FF; font-size:14px;color:#FFFFFF; border:1px #FFFFFF solid;">出生日期</td>
</tr>
 <c:forEach var="row" items="${userlist.rows}">
<tr>
 <td align="center" style="background-color:#FFFFFF;"height="20"><c:out value="${row.id}"/></td>
 <td align="center" style="background-color:#FFFFFF;"><c:out value="${row.tel}"/></td>
 <td align="center" style="background-color:#FFFFFF;"><c:out value="${row.pwd}"/></td>
 <td align="center" style="background-color:#FFFFFF;"><c:out value="${row.d_p}"/></td>
 <td align="center" style="background-color:#FFFFFF;"><c:out value="${row.name}"/></td>
 <td align="center" style="background-color:#FFFFFF;"><c:out value="${row.sex}"/></td>
 <td align="center" style="background-color:#FFFFFF;"><c:out value="${row.birth}"/></td>
</tr>
</c:forEach>
</table>


</body>
</html>

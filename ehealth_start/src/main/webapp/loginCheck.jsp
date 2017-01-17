<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%> 
<% 
 request.setCharacterEncoding("UTF-8"); 
 response.setCharacterEncoding("UTF-8"); 
 response.setContentType("text/html; charset=UTF-8"); 
%>  
<!DOCTYPE html >
<html> 
<head> 
<title>验证用户登录信息</TITLE> 
</head> 
<body>
<% 
String user = request.getParameter("user");
String password=request.getParameter("pwd");
try{
	/** 连接数据库参数 **/ 
	String driverName = "com.mysql.jdbc.Driver"; //驱动名称 
	String DBUser = "root"; //mysql用户名 
	String DBPasswd = "123456"; //mysql密码 
	String DBName = "ehealth"; //数据库名 
	String connUrl = "jdbc:mysql://101.201.40.158/" + DBName + "?user=" + DBUser + "&password=" + DBPasswd; 
	Class.forName(driverName).newInstance(); 
    Connection con=DriverManager.getConnection(connUrl);
    Statement sql=con.createStatement();
    ResultSet rs=sql.executeQuery("select *from user where tel='"+ user +"'and pwd='"+password+"'"); 
     //登录信息判断，判断身份，进行主页选择
    if(rs.next()){ 
     //ResultSet rs1=sql.executeQuery("select *from user where tel='"+ user +"'and pwd='"+password+"'");//括号里是SQL语句，用sql.executeQuery()语法执行SQL语句，从user_info中查询、包含登录时输入的name+password的那行的Qname数据。再用resultset把包含符合条件的所有行提取结果集（通常是一个表）放在rs1中。
     //rs1.next();//result.next是指从当前resultset行中移动到下一行、一般是从上到下开始获取resultSet行。
     //String Q_name= rs1.getString("name");//resultSet数据可以用一套.getXXX方法来获取某一列的值，这里是获取符合上述name+password条件的行的Qname列的值。.getXXX方法可以是getString、或getint等等。。
     //session.setAttribute("QQ_name",Q_name);//把获取的Qname列值存在session容器中并标关键字为QQ_name。 保存的数据可以用session.geiAttribute来获取。
     String d_p=rs.getString("d_p");
     if("d".equals(d_p))
     response.sendRedirect("doctorIndex.jsp");
     if("p".equals(d_p))
     response.sendRedirect("patientIndex.jsp");	 
   }
  else{
    // response.sendRedirect("register.html");
     out.print("<script>alert('密码错误或用户不存在！');window.location.href='login.jsp'</script>");
   }
   con.close();
}
catch(SQLException e1){}
%>
</body>
</html>
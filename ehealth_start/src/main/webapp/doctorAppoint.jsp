<!-- 医生日程管理页面--byliulu -->
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="java.util.*"%>  
<%@ page import="java.text.*"%>
<% 
request.setCharacterEncoding("UTF-8"); 
response.setCharacterEncoding("UTF-8"); 
response.setContentType("text/html; charset=utf-8"); 
%>
<%
	//变量声明
	java.sql.Connection sqlCon; //数据库连接对象
	java.sql.Statement sqlStmt; //SQL语句对象
	java.sql.ResultSet sqlRst; //结果集对象
	java.lang.String strCon;//数据库连接字符串
	java.lang.String strSQL;//SQL语句
	int intPageSize; //一页显示的记录数
	int intRowCount;//记录总数
	int intPageCount;//总页数
	int intPage;//待显示页码
	java.lang.String strPage;
	int i;
	//设置一页显示的记录数
	intPageSize=8;
	//取得待显示页码
	strPage=request.getParameter("page");
	if(strPage==null){//表明在QueryString中没有page这一个参数，此时显示第一页数据
	intPage=1;
	}
	else{//将字符串转换成整型
	intPage=java.lang.Integer.parseInt(strPage);
	if(intPage<1)intPage=1;
	}
	//装载JDBC驱动程序
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	//设置数据库连接字符串
	strCon="jdbc:mysql://101.201.40.158:3306/ehealth";
	//连接数据库
	sqlCon=java.sql.DriverManager.getConnection(strCon,"root","123456");
	//创建一个可以滚动的只读的SQL语句对象
	sqlStmt=sqlCon.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
	String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间 
	//准备SQL语句
	strSQL="SELECT * FROM doctor_appoint where time='"+ datetime +"'";
	//执行SQL语句并获取结果集
	sqlRst=sqlStmt.executeQuery(strSQL);
	//获取记录总数
	sqlRst.last();
	intRowCount=sqlRst.getRow();
	//记算总页数
	intPageCount=(intRowCount+intPageSize-1)/intPageSize;
	//调整待显示的页码
	if(intPage>intPageCount)intPage=intPageCount;
%>
<html>
<head>
<title>日程管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Petsy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />	
<script src="js/jquery.min.js"> </script>
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!--/script-->
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
</script>
<link rel="stylesheet" href="css/documentation.css" type="text/css" />
<link rel="stylesheet" href="css/jalendarDoctor.css" type="text/css" />

<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/jalendarDoctor.js"></script>
<script type="text/javascript">
$(function () {
    $('#myId').jalendar({
        customDay: '2017/12/01',  // Format: Year/Month/Day
        color: '#ed145a', // Unlimited Colors
        lang: 'EN' // Format: English — 'EN', Türkçe — 'TR'
    });
    $('#myId2').jalendar({
        customDay: '2016/02/29',
        color: '#023447',
        lang: 'ES',
            
    });
    
    $('#myId3').jalendar({
    	
    });
    $('#myId3').find("#appointnum").text(<%=intRowCount %>);//显示预约人数
    $('#myId3').find("#person").text("");//显示预约人
    <%
	if(intPageCount>0){
	//将记录指针定位到待显示页的第一条记录上
	sqlRst.absolute((intPage-1)*intPageSize+1);
	//显示数据
	i=0;
	while(i<intPageSize&&!sqlRst.isAfterLast()){
    %>
	    $('#myId3').find("#person").append('<td>'+"<%=sqlRst.getString(2)%>&nbsp"+'</td>');
	    $('#myId3').find("#person").append('<td>'+"<%=sqlRst.getString(5)%>&nbsp"+'</td>');
	    $('#myId3').find("#person").append('<td>'+"<%=sqlRst.getString(4)%>&nbsp"+'</td>'+'<br />');
	    $('#myId3').find("#person").append('<br />');  
	<%
	 sqlRst.next();
	 i++;}
	  } 
	%>	
});

</script>
</head>
<body>
	<!--start-header-->
			<div id="home" class="header two">
					<div class="top-header">
						<div class="container">
							<div class="logo">
							  <a href="doctorIndex.html"><h2>北京大学<span>第一医院</span></h2></a>
						    </div>
					     <div class="top-menu">
							<span class="menu"> </span>
								<ul class="cl-effect-16">
								<li><a href="doctorIndex.jsp" data-hover="主页">主页</a></li>
								<li><a  href="doctorAbout.html" data-hover="关于">关于</a></li>
								<li><a href="doctorHelper.jsp" data-hover="门诊助手">门诊助手</a></li>
								<li><a href="doctorPatient.jsp" data-hover="我的病人">我的病人</a></li>
								<li><a class="active" href="doctorAppoint.jsp" data-hover="日程管理">日程管理</a></li>
								<li><a href="doctorSetting.html" data-hover="设置">设置</a></li>
								<li style="color: white">|</li>
								<li><span class="glyphicon glyphicon-qrcode"  data-toggle="modal" data-target="#scanQRcode" data-backdrop="static" style="cursor: pointer;color: white"></span></li>
								<li class="dropdown" style="text-align: left;">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span></a>
									<ul class="dropdown-menu" role="menu" id="doctor-contents">
										<li><a href="doctorProfile.html"><span class="glyphicon glyphicon-cog"></span> 修改资料</a></li>
										<li><a href="login.html"><span class="glyphicon glyphicon-log-out"></span> 退出</a></li>
									</ul>
			  					</li>		
								  <div class="clearfix"></div>
								</ul>
							</div>
							<!-- script-for-menu -->
								<script>
									$("span.menu").click(function(){
										$(".top-menu ul").slideToggle("slow" , function(){
										});
									});
								</script>
								<!-- script-for-menu -->
							<div class="clearfix"> </div>
					</div>
				</div>
	     </div>
     </div>
		<!--start-about-->
	<div class="about second"  style="padding: 4em 0 1em 0">
		<div class="container" style="margin-top:-40px">
		 <h3 class="tittle wel" style="font-size: 1.9em">日程管理</h3>
				<div class="about-top about-top-right">
						<h4>出诊时间：周一上午 周三上午</h4>
					<div class="clearfix"></div>
				</div>
			</div>	 
	</div>

	<div class="col-md-11 col-md-offset-1">
	 <div id="myId3" class="jalendar">
	 </div>
	 </div>

	  
  <!--footer-->
			<div class="footer text-center" style="padding-bottom: 0; text-align: center;">
				<div class="container">
					<div class="copy">
		              <p style="color: black">Copyright &copy; 2016. School of Electronics Engineering and Computer Science, Peking University.</p>
		            </div>
				</div>
			</div>

				<!--start-smoth-scrolling-->
						<script type="text/javascript">
									$(document).ready(function() {	
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
		<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>

		<div id="scanQRcode" class="modal fade" >
		<div class="modal-dialog" style="margin-top: 10%;width:400px;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">E-Health</h4>
                </div>
                <div class="modal-body">
                	<p>我是一个二维码</p>
                	<p>扫描二维码，关注E-Health微信公众号。</p>
                </div>
                
                <div class="modal-footer">
                <!--
                    <button type="button" class="btn btn-success" onclick="deleteNSgroup()">确定</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    -->
                </div>

             </div>
        </div>
    </div>
<div id="doctorAppointEdit" class="modal fade" >
		<div class="modal-dialog" style="margin-top: 10%;width:600px;height: 100%">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">预约随访调查项目</h4>
                </div>
                <div class="modal-body contact-grid" style="height:30px;">
               <div class="col-md-10" style="text-align: center;">
				<input type="checkbox" name="radio" id="r5" value="">
                <label style="color: #888;">运动习惯</label>
                    &nbsp&nbsp
                    &nbsp&nbsp
				<input type="checkbox" name="radio" id="r5" value="">
                <label style="color: #888;">饮食习惯</label>
                    &nbsp&nbsp
                 	&nbsp&nbsp
                <input type="checkbox" name="radio" id="r5" value="">
                <label style="color: #888;">睡眠情况调查</label>
                    &nbsp&nbsp
                    &nbsp&nbsp
				<input type="checkbox" name="radio" id="r5" value="">
                <label style="color: #888;">病情</label>
            	</div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" onclick="deleteNSgroup()" style="background-color: #20CBBE; border-color: #20CBBE">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>

             </div>
        </div>
    </div>

</body>
</html>
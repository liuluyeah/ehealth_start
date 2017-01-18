<%-- 门诊助手页，显示当日门诊情况。--%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ page import="java.util.*"%>  
<%@ page import="java.text.*"%>

<% 
 request.setCharacterEncoding("UTF-8"); 
 response.setCharacterEncoding("UTF-8"); 
 response.setContentType("text/html; charset=UTF-8"); 
%> 
<!DOCTYPE HTML>
<html>
<head>
<title>门诊助手</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Petsy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

	<link href="css/searchHelper.css" rel="stylesheet" type="text/css">
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
</head>
<body>
	<!--start-header-->
			<div id="home" style="margin-top:-20px" class="header two">
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
								<li><a class="active" href="doctorHelper.jsp" data-hover="门诊助手">门诊助手</a></li>
								<li><a href="doctorPatient.jsp" data-hover="我的病人">我的病人</a></li>
								<li><a href="doctorAppoint.html" data-hover="日程管理">日程管理</a></li>
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
	<div class="about second">
		<div class="container">
		 <h3 class="tittle wel" style="font-size: 1.9em">门诊助手</h3>
				<div class="about-top send about-top-right">
				<input type="button" name="" value="刷新" >
				    <% 
       String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间 
       String title="";
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
    	    ResultSet rs=sql.executeQuery("select *from clinic_assistant where time='"+ datetime +"'"); 
    	     //判断数据库里 是否有今日门诊记录
    	    if(rs.next()){ 
    	     title="今日门诊情况：";
    	   }
    	  else{
    		  title="今日无门诊。";
    	   }
    	   con.close();
    	}
    	catch(SQLException e1){}
    %>
				<h4 style="margin-top: 2%"><%=title %></h4>
				<!-- 连接数据库 -->
				<c:catch var="ex">
                <sql:setDataSource var="dataSour" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://101.201.40.158:3306/ehealth" user="root" password="123456"/>
                </c:catch>
                <c:if test="${ex != null}">
                                                    数据库连接失败，请联系管理员！
                </c:if>
                <!-- 数据读取 -->
                <sql:query var="userlist" dataSource="${dataSour}" sql="SELECT * FROM clinic_assistant order by idmenzhen desc"/>
						<table class="table table-striped table-hover " style="border: 1px solid #ddd; margin-top: 2%">
              			<thead>
			                <tr>
			                  <th>序号</th>
			                  <th>姓名</th>
			                  <th>类型</th>
			                  <th>创建时间</th>
							  <th>主诉</th>
			                  <th>操作</th>
			                </tr>
			              </thead>
			              <tbody>
			               <c:forEach var="row" items="${userlist.rows}" varStatus="status">
							<tr>
							 <td><c:out value="${status.count}"/></td>
							 <td><c:out value="${row.name}"/></td>
							 <td><c:out value="${row.classification}"/></td>
							 <td><c:out value="${row.time}"/></td>
							 <td><c:out value="${row.mainreason}"/></td>
			                 <td><a href="doctorHelperShow.jsp?id=${row.idmenzhen}" value="${row.idmenzhen}"><i class="glyphicon glyphicon-search templatemo-social-icon" title="查看" ></i></a>
			                  <i class="glyphicon glyphicon-pencil templatemo-social-icon" title="维护诊疗计划" data-toggle="modal" data-target="#doctorHelperEdit" data-backdrop="static" ></i>
							  <i class="glyphicon glyphicon-th-list templatemo-social-icon" title="分组" data-toggle="modal" data-target="#${row.idmenzhen}" data-backdrop="static" ></i>
							  <!-- 进行分组 -->
							  <div id="${row.idmenzhen}" class="modal fade" >							            
								<div class="modal-dialog" style="margin-top: 10%;width:450px;height: 100%">								 	
						            <div class="modal-content">
						            <form  method="post" action="clinicGroupAdd.jsp">
						            <input name="groupid" style="display:none" value="${row.idmenzhen}"  >	
						                <div class="modal-header">
						                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						                    <h4 class="modal-title">病人分组</h4>
						                </div>
						                <div class="modal-body contact-grid" style="padding-left: 5%"> 
										<input type="checkbox" name="radio" id="r5" value="月经组" >
						                <label style="color: #888;">月经组</label>
						                    &nbsp&nbsp
						                    &nbsp&nbsp
										<input type="checkbox" name="radio" id="r5" value="卵巢组" >
						                <label style="color: #888;">卵巢组</label>
						                    &nbsp&nbsp
						                 	&nbsp&nbsp
						                <input type="checkbox" name="radio" id="r5" value="更年组" >
						                <label style="color: #888;">更年组</label>
						                    &nbsp&nbsp
						                    &nbsp&nbsp
										<input type="checkbox" name="radio" id="r5" value="乳腺组" >
						                <label style="color: #888;">乳腺组</label>
						                </div>
						                <div class="modal-footer">						                                   
						                    <button type="submit" class="btn btn-success" style="background-color: #20CBBE; border-color: #20CBBE">保存</button>
						                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						                </div>
						               </form>
						             </div>
						        </div>
                               </div>
                               </td>
							</tr>
							</c:forEach>			         			               
			              </tbody>
			            </table>
							<div class="page_nation" style="text-align: center;">
							<nav>
											   <ul class="pagination pagination-sm">
												<li><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
												<li><a href="#">1</a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
												<li><a href="#">4</a></li>
												<li><a href="#">5</a></li>
												<li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
											  </ul>
											 </nav>		
							</div>
					<div class="clearfix"></div>
				</div>
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
                </div>

             </div>
        </div>
    </div>

    <div id="doctorHelperEdit" class="modal fade" >
		<div class="modal-dialog" style="margin-top: 10%;width:600px;height: 100%">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">维护诊疗计划</h4>
                </div>
                <div class="modal-body contact-grid" style="height:470px;">
                	<form>
						<div class="col-md-12">
						<p class="col-md-3 your-para" >用药</p>
							<div class="col-md-9">
								<select name="YYYY" onchange="YYYYDD(this.value)">
    							<option value="">药品名称</option>
    							<option value="">益母草颗粒</option>
    							<option value="">感冒胶囊</option>
    							<option value="">延更丹</option>
  							</select>
  							<select name="MM" onchange="MMDD(this.value)">
    							<option value="">药品用量</option>
    							<option value="">一次1粒</option>
    							<option value="">一次2粒</option>
    							<option value="">一次3粒</option>
  							</select>
 							<select name="DD">
 								<option value="">用药频率</option>
    							<option value="">一日一次</option>
    							<option value="">一日两次</option>
    							<option value="">一日三次</option>
  							</select>
							</div>			
						</div>

						<div class="col-md-12">
								<p class="col-md-3 your-para" style="padding-top: 2%" >备注</p>
								<div class="col-md-9" style="padding-top: 1%" >
								<textarea  value=" "  onfocus="this.value='';" ></textarea>
								</div>
							</div>
						<div class="col-md-12" >
							<p class="col-md-3 your-para" style="padding-top: 2%">下次随访要求</p>
							<div class="col-md-9" style="padding-top: 1%" >
							<textarea  value=" "  onfocus="this.value='';" ></textarea>
							</div>
						</div>

					</form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" onclick="deleteNSgroup()" style="background-color: #20CBBE; border-color: #20CBBE">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>

             </div>
        </div>
    </div>

   <!--   <div id="doctorDivide" class="modal fade" >
		<div class="modal-dialog" style="margin-top: 10%;width:450px;height: 100%">		
            <input name="idgroup" id="idgroup"  style="display:none" value="1"  >		
            <div class="modal-content">
            <form  method="post" action="groupAdd.jsp">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">病人分组</h4>
                </div>
                <div class="modal-body contact-grid" style="padding-left: 5%"> 
				<input type="checkbox" name="radio" id="r5" value="月经组" >
                <label style="color: #888;">月经组</label>
                    &nbsp&nbsp
                    &nbsp&nbsp
				<input type="checkbox" name="radio" id="r5" value="卵巢组" >
                <label style="color: #888;">卵巢组</label>
                    &nbsp&nbsp
                 	&nbsp&nbsp
                <input type="checkbox" name="radio" id="r5" value="更年组" >
                <label style="color: #888;">更年组</label>
                    &nbsp&nbsp
                    &nbsp&nbsp
				<input type="checkbox" name="radio" id="r5" value="乳腺组" >
                <label style="color: #888;">乳腺组</label>
                </div>
                <div class="modal-footer">                    
                    <input type="submit" class="btn btn-success" style="background-color: #20CBBE; border-color: #20CBBE" value="保存">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
               </form>
             </div>
        </div>
    </div>
-->
    <script type="text/javascript">
     $(document).ready(function() {
    	  $('input[type=checkbox]').click(function() {
    	   $("input[name='radio']").attr('disabled', true);
    	   if ($("input[name='radio']:checked").length >= 1) {
    	    $("input[name='radio']:checked").attr('disabled', false);
    	   } else {
    	    $("input[name='radio']").attr('disabled', false);
    	   }
    	  });
    	 })
    </script>
</body>
</html>
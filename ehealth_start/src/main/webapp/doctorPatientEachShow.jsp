<%-- 我的病人子页，显示选中诊疗信息、调查问卷、诊疗计划等详情信息。——by liulu --%>
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
<!DOCTYPE HTML>
<html>
<head>
<title>我的病人</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Petsy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<link href="css/shaixuan2.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />	
<script src="js/jquery.min.js"> </script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
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
								<li><a  href="doctorHelper.jsp" data-hover="门诊助手">门诊助手</a></li>
								<li><a class="active" href="doctorPatient.jsp" data-hover="我的病人">我的病人</a></li>
								<li><a href="doctorAppoint.jsp" data-hover="日程管理">日程管理</a></li>
								<li><a href="doctorSetting.html" data-hover="设置">设置</a></li>
								<li style="color: white">|</li>
								<li><span class="glyphicon glyphicon-qrcode"  data-toggle="modal" data-target="#scanQRcode" data-backdrop="static" style="cursor: pointer;color: white"></span></li>
								<li class="dropdown" style="text-align: left;">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span></a>
									<ul class="dropdown-menu" role="menu" id="doctor-contents">
										<li><a href="doctorProfile.jsp"><span class="glyphicon glyphicon-cog"></span> 修改资料</a></li>
										<li><a href="login.jsp"><span class="glyphicon glyphicon-log-out"></span> 退出</a></li>
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
		 <h3 class="tittle wel" style="font-size: 1.9em;margin-top:-40px">我的病人</h3>
			<div class="about-top about-top-right">
				<h4></h4>
					<div class="panel-group" id="accordion">
					    <!-- 连接数据库 -->
						<c:catch var="ex">
		                <sql:setDataSource var="dataSour" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://101.201.40.158:3306/ehealth" user="root" password="123456"/>
		                </c:catch>
		                <c:if test="${ex != null}">
		                                                    数据库连接失败，请联系管理员！
		                </c:if>
		                <!-- 数据读取 --><c:set var="id" value="${param.id}"/><c:set var="tel" value="${param.tel}" />
		                <sql:query var="userlist" dataSource="${dataSour}" >SELECT * FROM patient_detail where time=? && tel=?;
		                <sql:param value="${id}"/><sql:param value="${tel}"/>
		                </sql:query>
		                <c:forEach var="row" items="${userlist.rows}"  end="0"> 	
			            <div class="panel panel-default">
			              <div class="panel-heading">
			                <h4 class="panel-title" style="font-size: 1.4em;"> <a data-toggle="collapse" class="panel-toggle" data-parent="#accordion" href="#collapseOne" style="text-decoration: none;"> 1. 诊疗信息 </a></h4>
			              </div>
			              <div id="collapseOne" class="panel-collapse collapse">
			                <div class="panel-body"> 			
								
								<form id="${row.idmenzhen}" >
									<div class="col-md-4">
									<p class="col-md-4 your-para" style="padding-top: 3%">身高：</p>
									<p class="col-md-8 your-para" style="padding-top: 3%"><c:out value="${row.height}"/></p>
									</div>
			
									<div class="col-md-4">
									<p class="col-md-4 your-para" style="padding-top: 3%">体重：</p>
									<p class="col-md-8 your-para" style="padding-top: 3%"><c:out value="${row.weigtht}"/></p>
									</div>
			
									<div class="col-md-4">
									<p class="col-md-4 your-para" style="padding-top: 3%">血压：</p>
									<p class="col-md-8 your-para" style="padding-top: 3%"><c:out value="${row.bloodpressure}"/></p>
									</div>
			
									<div class="col-md-4">
									<p class="col-md-4 your-para" style="padding-top: 5%">腰围：</p>
									<p class="col-md-8 your-para" style="padding-top: 5%"><c:out value="${row.waist}"/></p>
									</div>
			
									<div class="col-md-4">
									<p class="col-md-4 your-para" style="padding-top: 5%">臀围：</p>
									<p class="col-md-8 your-para" style="padding-top: 5%"><c:out value="${row.hip}"/></p>
									</div>
								</form>
								
			                </div>
			              </div>
			            </div>
			            <div class="panel panel-default">
			              <div class="panel-heading">
			                <h4 class="panel-title" style="font-size: 1.4em;"><a data-toggle="collapse" class="panel-toggle" data-parent="#accordion" href="#collapseTwo" style="text-decoration: none;"> 2. 调查问卷 </a> </h4>
			              </div>
			              <div id="collapseTwo" class="panel-collapse collapse">
			                <div class="panel-body"> 民族、职业习惯等 			           
			                </div>
			                
			              </div>
			            </div>
			            <div class="panel panel-default">
			              <div class="panel-heading">
			                <h4 class="panel-title" style="font-size: 1.4em; ">  <a data-toggle="collapse" class="panel-toggle" data-parent="#accordion" href="#collapseThree" style="text-decoration: none;"> 3. 超声学检查结果 </a> </h4>
			              </div>
			              <div id="collapseThree" class="panel-collapse collapse">
			                <div class="panel-body"> 
			                <form>
									<div class="col-md-10">
									<p class="col-md-2 your-para" style="padding-top: 1%">妇科：</p>
									<div class="col-md-6" style="padding-top: 2%">
									<img src="images/eg.jpg" style="max-width: 600px">
									</div>
									</div>
									<br /><br />
			
									<div class="col-md-10">
									<p class="col-md-2 your-para" style="padding-top: 1%">乳腺：</p>
									<div class="col-md-6" style="padding-top: 2%">
									<img src="images/eg.jpg" style="max-width: 600px">
									</div>
									</div>
									<br /><br />
			
									<div class="col-md-10">
									<p class="col-md-2 your-para" style="padding-top: 1%">甲状腺：</p>
									<div class="col-md-6" style="padding-top: 2%">
									<img src="images/eg.jpg" style="max-width: 600px">
									</div>
									</div>
								</form>
			                </div>
			                </div>
			              </div>
			           
			            <div class="panel panel-default">
			              <div class="panel-heading">
			                <h4 class="panel-title" style="font-size: 1.4em; ">  <a data-toggle="collapse" class="panel-toggle" data-parent="#accordion" href="#collapseFour" style="text-decoration: none;"> 4. 表格 </a> </h4>
			              </div>
			              <div id="collapseFour" class="panel-collapse collapse">
			                <div class="panel-body"> 
			                表格
			                </div>
			                </div>
			              </div>
			
			            <div class="panel panel-default">
			              	<div class="panel-heading">
			                	<h4 class="panel-title" style="font-size: 1.4em; ">  <a data-toggle="collapse" class="panel-toggle" data-parent="#accordion" href="#collapseFive" style="text-decoration: none;"> 5. 诊疗计划 </a> </h4>
			              	</div>
			              <div id="collapseFive" class="panel-collapse collapse"><!-- 将class in的样式删掉 -->
			                <div class="panel-body contact-grid"> 
			                <div class="col-md-12">
									<p class="col-md-2 your-para" >病历：</p>
									<div class="col-md-8" >
									<img src="images/eg.jpg" style="max-width: 600px">
									</div>
									</div>
									<div class="col-md-12">
									<p class="col-md-2 your-para" >补充说明：</p>
									<div class="col-md-8" >
									<textarea cols="" rows="4" value=" " onfocus="this.value='';"></textarea>
									</div>
									</div>
			                	<div class="col-md-12 " >
									<p class="col-md-2 your-para">用药：</p>
									<div class="col-md-8">										
										<form>
											<select name="YYYY">
			    							<option value=""><c:out value="${row.medicine}"/></option>
			  							    </select>
				  							<select name="MM" onchange="MMDD(this.value)">
				    							<option value=""><c:out value="${row.num}"/></option>
				  							</select>
				 							<select name="DD">
				 								<option value=""><c:out value="${row.fre}"/></option>
				  							</select>
										</form>								
										</div>
									</div>
									<div class="col-md-12">
									<p class="col-md-2 your-para" >备注：</p>
									<div class="col-md-8" >
									<textarea cols="50" rows="4"><c:out value="${row.remark}"/></textarea>
									</div>
									</div>			
									<div class="col-md-12">
									<p class="col-md-2 your-para">下次随访要求：</p>
									<div class="col-md-8" >
									<textarea cols="50" rows="4" ><c:out value="${row.demand}"/></textarea>
									</div>
									</div>
									<br/><br/>
							   <!-- <div class="col-md-12 send" style="margin-left: 2%;">
										<input type="submit" value="保存" >
									</div> 
								--> 
			                </div>
			                </div>
			              </div>
			         </c:forEach>
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
		<div class="modal-dialog" style="width:400px;">
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
</body>
</html>
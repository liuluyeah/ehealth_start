<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%> 
<% 
 request.setCharacterEncoding("UTF-8"); 
 response.setCharacterEncoding("UTF-8"); 
 response.setContentType("text/html; charset=UTF-8"); 
%>  
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>

<link rel="stylesheet" href="css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/loginMy.css"/>

<style>
html,body{width:100%;height: 100%;margin: 0}
</style>

</head>
<body>

<div class="main">
	<div class="title">
		<p style="color: white; ">
			登录E-Health &nbsp;
		</p>

	</div>
	<div class="center" >
		<form action="loginCheck.jsp" id="formOne" method="post"   style="padding-top: 25px;"><!--  onsubmit="return submitB()" -->
			<i class="fa fa-user Cone" style="padding-left: 5px; padding-top: 2px; color: white;">  | </i>
			<input type="phone" name="user" id="user" placeholder="手机号"onblur="checkUser()" style="color: white"/>
			<span id="user_pass"></span>
			<br/>
			<i class="fa fa-key Cone" style="padding-left: 2px; padding-top: 2px; color: white;"> | </i>
			<input type="password" name="pwd" id="pwd" placeholder="密码"onblur="checkUser1()" style="color: white"/>
			<span id="pwd_pass"></span>
			<br/>
			<i class="fa fa-check Cone" style="padding-left: 2px; padding-top: 2px; color: white;">  | </i>
			<input type="text" name="surePwd" id="surePwd" placeholder="手机验证码"onblur="checkUser2()" style="color: white" />
			<input type="submit" value="发送" id="send" name="submit" style="text-align: center;padding: 0">
			<span id="surePwd_pass" ></span><br/>
			<input type="submit" value="登录" id="submit" name="submit" style="text-align: center;padding: 0" > <!-- location.href='doctorIndex.html'onclick="fun_a()" -->
			<br /><br />
			 <span style="color: white; padding-left: 23.5%">没有账号？请点击</span><a href="register.jsp" style="text-decoration: none;"><span style="color:#20CBBE;">注册</span><span style="color: white; ">。</span></a>
			<!--<br/><br/><br/>-->
           <!--<SPAN style="float: right;">-->
			   <!--<A style="background: rgb(0, 142, 173); color: rgb(255, 255, 255);padding: 7px 10px;border-radius: 4px;border: 1px solid-->
               <!--rgb(26, 117, 152);font-weight: bold; margin-right: 50px;" href="reg.html">注册</A>-->
               <!--<A style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px;border: 1px solid-->
               <!--rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;margin-right: 170px" href="#">登录</A>-->
           <!--</SPAN>-->

		</form>
		<!--
		<div class="footerIndex0" style="position: fixed; bottom: 0; margin-right: auto;margin-left: auto;">
				<div class="container">
					<div class="copy">
		              <p style="color: white">Copyright &copy; 2016. School of Electronics Engineering and Computer Science, Peking University.</p>
		            </div>
				</div>
			</div>
			-->
	</div>
	
</div>


<script type="text/javascript" src="js/loginMy.js"></script>
<script type="text/javascript">
//如果用户名不为空，则跳转，为空弹窗提示
function fun_a(){
	if (document.getElementById('user').value=='')
	            {
	                alert('请输入手机号');
	                document.getElementById('user').focus();
	            }else{
		//self.location='doctorIndex.jsp';
	}
	
}
</script>

</body>
</html>
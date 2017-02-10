window.onload=function() {
	$.ajax({
		async:false,
		type: 'POST',
		url: '/ehealth/registerDelete',
	});
}

//第一步注册
function saveOne() {
    var param = {};
    
    $("#next1").attr("href", "#collapseTwo");
    param["tel"] = $("#tel").val();
    param["pwd"] = $("#pwd").val();
    param["pwdCheck"] = $("#pwdCheck").val();
    param["d_p"] = $("input[name='d_p']:checked").val();

    if (param["tel"] == '' || param["pwd"] == '' || param["pwdCheck"] == '') {
        alert("请填写完整注册信息！");
        $("#next1").attr("href", "#collapseOne");
		$("#collapseOne").removeClass();
		$("#collapseOne").addClass("panel-collapse collapse");
        return;
    }
    
    if (param["tel"] != '') {
    	var mobile=param["tel"];
    	if(!(/^1(3|4|5|7|8)\d{9}$/.test(mobile))){ 
    		alert("请填写有效手机号码！");
    		$("#tel").focus();
    		$("#next1").attr("href", "#collapseOne");
    		$("#collapseOne").removeClass();
    		$("#collapseOne").addClass("panel-collapse collapse");
    		$("#tel").val("");
    		$("#pwd").val("");
    		$("#pwdCheck").val("");
    		return;
    	} 
    }
    
    if (param["pwd"] != param["pwdCheck"]) {
        alert("密码不一致，请重新填写！");
        $("#next1").attr("href", "#collapseOne");
		$("#collapseOne").removeClass();
		$("#collapseOne").addClass("panel-collapse collapse");
		$("#pwd").focus();
		$("#pwd").val("");
		$("#pwdCheck").val("");
        return;
    }
    
    $.ajax({
    	async:false,
    	type: 'POST',
    	url: '/ehealth/registerUserOne',
        dataType: 'json',
        data: param,
        success: function (data) {
        	document.getElementById("userId").value = data["result"];
        	document.getElementById("userRole").value = data["role"];
        	if (data["code"] == 2) {
        		alert("注册信息已存在，请直接登录或更换手机号！");
        		$("#next1").attr("href", "#collapseOne");
        		$("#collapseOne").removeClass();
        		$("#collapseOne").addClass("panel-collapse collapse");
        		$("#tel").val("");
        		$("#pwd").val("");
        		$("#pwdCheck").val("");
        	}
        	if (data["role"] == 'd') {
        		document.getElementById('docTimeDiv').style.display = "";
        	}
        	else if (data["role"] == 'p') {
        		document.getElementById('docTimeDiv').style.display = "none";
        	}
        },
        error: function (e) {
        }
    });
}

//第二步注册
function saveTwo() {
    var param = {};
    
    $("#next2").attr("href", "#collapseThree");
    param["id"] = $("#userId").val();
    param["name"] = $("#name").val();
    param["sex"] = $("input[name='sex']:checked").val();
    param["birth"] = $("#birth").val();
    param["age"] = $("#age").val();
    param["identity"] = $("#identity").val();
    param["recordNumber"] = $("#recordNumber").val();
    
    //出诊时间，倒序存储
	var checkArray = document.getElementsByName("docTime");
	var res = 0;
	var tmp = 1;
	for(var i = 0; i < checkArray.length; i ++){
		if(checkArray[i].checked == true)
			res += tmp;
		tmp *= 2;
	}
	var resbi = res.toString(2);
	param["docTime"] = (Array(14).join(0) + resbi).slice(-14);
    
    if (param["name"] == '') {
        alert("请填写姓名！");
        $("#name").focus();
        $("#next2").attr("href", "#collapseTwo");
		$("#collapseTwo").removeClass();
		$("#collapseTwo").addClass("panel-collapse collapse");
        return;
    }
    if (param["age"] == '') {
        alert("请填写年龄！");
        $("#age").focus();
        $("#next2").attr("href", "#collapseTwo");
		$("#collapseTwo").removeClass();
		$("#collapseTwo").addClass("panel-collapse collapse");
        return;
    }
    if (param["birth"] == '') {
        alert("请选择出生日期！");
        $("#birth").focus();
        $("#next2").attr("href", "#collapseTwo");
		$("#collapseTwo").removeClass();
		$("#collapseTwo").addClass("panel-collapse collapse");
        return;
    }
    if (param["identity"] == '') {
        alert("请填写身份证号！");
        $("#identity").focus();
        $("#next2").attr("href", "#collapseTwo");
		$("#collapseTwo").removeClass();
		$("#collapseTwo").addClass("panel-collapse collapse");
        return;
    }
    
    if (param["name"] != '') {
    	var name1=param["name"];
    	if(!((/^[\u4e00-\u9fa5]{1,20}$/.test(name1))||(/^[a-zA-Z\/ ]{2,20}$/.test(name1)))){ 
    		alert("请填写中文或英文姓名！");  
    		$("#name").focus();
    		$("#next2").attr("href", "#collapseTwo");
    		$("#collapseTwo").removeClass();
    		$("#collapseTwo").addClass("panel-collapse collapse");
    		return;
    	} 
    }
    
    if (param["age"] != '') {
    	var age1=param["age"];
    	if(!(/\d+/.test(age1))){ 
    		alert("请填写数字！");  
    		$("#age").focus();
    		$("#next2").attr("href", "#collapseTwo");
    		$("#collapseTwo").removeClass();
    		$("#collapseTwo").addClass("panel-collapse collapse");
    		return;
    	} 
    }
    
    //15或18位身份证号
    if (param["identity"] != '') {
    	var identity1=param["identity"];
    	if(!((/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/.test(identity1))||(/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/.test(identity1)))){ 
    		alert("请填写有效身份证号！");  
    		$("#identity").focus();
    		$("#next2").attr("href", "#collapseTwo");
    		$("#collapseTwo").removeClass();
    		$("#collapseTwo").addClass("panel-collapse collapse");
    		return;
    	} 
    }
    
    
    $.ajax({
    	async:false,
    	type: 'POST',
    	url: '/ehealth/registerUserTwo',
        dataType: 'json',
        data: param,
        success: function (data) {
        	if (data["result"] == "d") {
        		setTimeout("javascript:location.href='doctorIndex.jsp'", 1500); 
        	}
        	else if (data["result"] == "p") {
        		setTimeout("javascript:location.href='patientIndex.jsp'", 1500); 
        	}
        },
        error: function (e) {
        }
    });
    
}
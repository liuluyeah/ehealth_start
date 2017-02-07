//第一步注册
function saveOne() {
    var param = {};
    
    param["tel"] = $("#tel").val();
    param["pwd"] = $("#pwd").val();
    param["pwdCheck"] = $("#pwdCheck").val();
    param["d_p"] = $("input[name='d_p']:checked").val();

    if (param["tel"] == '' || param["pwd"] == '' || param["pwdCheck"] == '') {
        alert("请填写完整注册信息！");
        //$("#tel").val("");
        window.location.href="register.jsp";
        return;
    }
    
    if (param["tel"] != '') {
    	var mobile=param["tel"];
    	if(!(/^1(3|4|5|7|8)\d{9}$/.test(mobile))){ 
    		alert("请填写有效手机号码！");  
    		/*$("#tel").val("");
			$("#collapseTwo").removeClass();
			$("#collapseTwo").addClass("panel-collapse collapse");
			$("#collapseOne").removeClass();
			$("#collapseOne").addClass("panel-collapse collapse in")
			*/
    		window.location.href="register.jsp";
    		return;
    	} 
    }
    
    if (param["pwd"] != param["pwdCheck"]) {
        alert("密码不一致，请重新填写！");
        window.location.href="register.jsp";
        return;
    }
    
    $.ajax({
    	async:false,
    	type: 'POST',
    	url: '/ehealth/registerUserOne',
        dataType: 'json',
        data: param,
        success: function (data) {
        	//alert(data["result"]);
        	document.getElementById("userId").value =data["result"];
        	if (data["code"] == 2) {
        		alert("注册信息已存在，请直接登录或更换手机号！");
        		window.location.href="register.jsp";
        	}
        },
        error: function (e) {
        }
    });
}

//第二步注册
function saveTwo() {
    var param = {};
    
    param["id"] = $("#userId").val();
    param["name"] = $("#name").val();
    param["sex"] = $("input[name='sex']:checked").val();
    param["birth"] = $("#year option:selected").val()+"-"+$("#month option:selected").val()+"-"+$("#day option:selected").val();
    param["age"] = $("#age").val();
    param["identity"] = $("#identity").val();
    param["recordNumber"] = $("#recordNumber").val();
    //出诊时间
    
    /*信息拦截
    if (param["tel"] == '' || param["pwd"] == '') {
        alert("请填写完整注册信息！");
        window.location.href="register.jsp";
    }
    */
    
    $.ajax({
    	async:false,
    	type: 'POST',
    	url: '/ehealth/registerUserTwo',
        dataType: 'json',
        data: param,
        success: function (data) {
        	//alert(data["result"]);
        	if (data["code"] == 2) {
        		alert("注册信息已存在，请直接登录或更换手机号！");
        		window.location.href="register.jsp";
        	}
        	
        },
        error: function (e) {
        }
    });
    
}
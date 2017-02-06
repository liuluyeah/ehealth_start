//第一步注册
function saveOne() {
    var param = {};
    
    param["tel"] = $("#tel").val();
    param["pwd"] = $("#pwd").val();
    param["d_p"] = $("input[name='d_p']:checked").val();

    if (param["tel"] == '' || param["pwd"] == '') {
        alert("请填写完整注册信息！");
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
        	if (data["code"] == 2) {
        		alert("注册信息已存在，请直接登录或更换手机号！");
        		window.location.href="register.jsp";
        	}
        },
        error: function (e) {
        }
    });
}

//第一步注册
function saveTwo() {
    var param = {};
    
    param["name"] = $("#name").val();
    param["sex"] = $("input[name='sex']:checked").val();
    /*
    if (param["tel"] == '' || param["pwd"] == '') {
        alert("请填写完整注册信息！");
        window.location.href="register.jsp";
    }
    
    $.ajax({
    	async:false,
    	type: 'POST',
    	url: '/ehealth/registerUserOne',
        dataType: 'json',
        data: param,
        success: function (data) {
        	if (data["code"] == 2) {
        		alert("注册信息已存在，请直接登录或更换手机号！");
        		window.location.href="register.jsp";
        	}
        },
        error: function (e) {
        }
    });
    */
}
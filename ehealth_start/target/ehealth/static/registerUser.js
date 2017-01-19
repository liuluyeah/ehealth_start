//第一步注册
function saveOne() {
    var param = {};
    
    param["tel"] = $("#tel").val();
    param["pwd"] = $("#pwd").val();
    param["d_p"] = $("input[name='d_p']:checked").val();

    $.ajax({
    	async:false,
    	type: 'POST',
    	url: '/ehealth/registerUserOne',
        dataType: 'json',
        data: param,
        success: function (data) {
        },
        error: function (e) {
        }
    });
}
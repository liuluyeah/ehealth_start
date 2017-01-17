function save() {
    var param = {};
    
    param["tel"] = $("#tel").val();
    param["pwd"] = $("#pwd").val();
    param["d_p"] = $("input[name='d_p']:checked").val();
    //alert( param["pwd"]);

    $.ajax({
        url: '/registerUser123',
        type: 'POST',
        dataType: 'json',
        data: param,
        success: function (data) {
        },
        error: function (e) {
        }
    });
}
//申明用于命名空间注册
my = {};
my.register = function(fname) {
    var nArray = fname.split('.'); // 分置方法
    var tfn = '';
    var feval = '';

    for (var i = 0; i < nArray.length; i++) {
	if (i != 0) {
	    tfn += '.';
	}
	tfn += nArray[i];
	feval += "if (typeof(" + tfn + ") == 'undefined'){" + tfn + "={};}";
    }
    // alert(feval);
    if (feval != '') {
	eval(feval);
    }
};
my.register('my.common');
my.common = {
    // 全局变量
    global : {
	contextPath : '/',
	staticPath : '/static'
    },
    init : function() {
	// 初始化菜单
	my.menuTree.init();
	// 刷新应用
	Mousetrap.bind([ 'f5' ], function(e) {
	    stopEP(e);
	    FrameCall.father("my.desktop.refresh", "");
	});
	// 刷新浏览器页面
	Mousetrap.bind([ 'ctrl+f5' ], function(e) {
	    stopEP(e);
	    location.reload();
	});
	$(window).resize(function() {
	    my.common.initModal();
	});
	my.common.initModal();
    },
    buildAppIconUrl : function(icon) {
	var appIconUrl = my.common.global.staticPath
		+ "/assets/images/icons/apps/" + icon + ".png";
	return appIconUrl;
    },
    ajaxInit : function() {
	jQuery(document).ajaxSend(function(e, XHR, options) {
	    // 开始发送
	}).ajaxError(function(e, XHR, settings, thrownError) {
	    tips('连接服务器时发生错误.请再试一次！', 'error');
	}).ajaxComplete(function(e, XHR, options) {
	    try {
		var str = XHR.getAllResponseHeaders();
		if (str.indexOf("sessionstatus") >= 0) {
		    // 提示消息
		    FrameCall.father("my.desktop.login", "");
		} else if (str.indexOf("authstatus") >= 0) {
		    // 提示消息
		    tips('对不起，您没有操作权限,请联系管理员！', 'warning');
		} else {
		    if (XHR.status == 200) {
			// 成功返回结果
		    }
		}
	    } catch (e) {
		tips('连接服务器时发生错误.请再试一次！', 'error');
	    }
	});
    },
    /**
     * 重新定义弹出框位置
     */
    initModal : function() {
	// 当前可视区域高度
	var screenHeight = $(window).height();
	$(".modal-dialog").each(function(i, o) {
	    var modal = $(o);
	    var modalBody = modal.find(".modal-body");
	    modalBody.css("max-height", (screenHeight * 0.6) + "px");
	    modalBody.css("overflow-y", "auto");
	    var modalHeight = modalBody.height();
	    modal.css("top", (screenHeight - (modalHeight + 120)) * 0.2);
	});
    }
};
/**
 * var table=new my.common.AjaxLoadTable({ id:"divID",// 容器Id hasPage: true,//
 * 是否分页
 * fields:[{title:'用户名',field:'username',width:'100',buildField:null},{title:'姓名',field:'name',buildField:null},{title:'状态',field:'status',buildField:function(value){}}],
 * actions:[{name:'修改',css:'edit',action:function(row, rowData){}}],
 * ajaxUrl:"http://www.baidu.com", // 数据请求路径 pageSize:20// 每页大小 });
 * table.load({pageNo:1});
 */
my.common.AjaxLoadTable = function(cfg) {
    var table = this;

    this.cfg = cfg || {};
    this.id = cfg.id || null;
    this.tableId = table.id + "_table";
    this.hasPage = cfg.hasPage || false;
    this.checkBox = cfg.checkBox || false;
    this.ajaxUrl = cfg.ajaxUrl || null;
    this.pageNo = cfg.pageNo || 1;
    this.pageSize = cfg.pageSize || 20;
    this.fields = cfg.fields || [];
    this.actions = cfg.actions || [];
    this.datas = null;
    this.hasNo = cfg.hasNo || false; // 是否需要显示序号

    this.load = function(param) {
	if (!param['pageNo'] || param['pageNo'] == 0) {
	    param['pageNo'] = table.pageNo;
	}
	param['pageSize'] = table.pageSize;
	this.param = param;
	table.loadData(param, table.buildTable);
    };
    this.loadData = function(param, callback) {
	$.ajax({
	    'url' : table.ajaxUrl,
	    'data' : param,
	    'type' : 'GET',
	    'dataType' : 'json',
	    'async' : true,
	    'beforeSend' : function() {

	    },
	    'success' : function(data) {
		if (table.pageNo != 1 && data['list'].length == 0) {
		    table.pageNo -= 1;
		    param['pageNo'] = table.pageNo;
		    table.loadData(param, callback);
		} else {
		    callback(data, param);
		}
	    },
	    'error' : function(e) {

	    }
	});

    };
    this.buildTable = function(data, param) {
	var html = '<table id="'
		+ table.tableId
		+ '" class="table table-hover"><thead></thead><tbody></tbody><tfoot></tfoot></table>';
	$("#" + table.id).html(html);
	// 编辑表格标题
	var headHtml = '<tr>';
	var fieldsSize = table.fields.length || 0;
	var actionsSize = table.actions.length || 0;
	if (table.checkBox) {
	    headHtml += '<th width="5%"><input type="checkbox"></th>';
	}
	if (table.hasNo) {
	    headHtml += '<th width="6%" style="text-align:center">序号</th>';
	}
	for (var i = 0; i < fieldsSize; i++) {
	    var field = table.fields[i];
	    var width = field["width"];
	    if (width && width > 0) {
		headHtml += '<th width="' + width + '%">' + field["title"]
			+ '</th>';
	    } else {
		headHtml += '<th>' + field["title"] + '</th>';
	    }
	}
	if (actionsSize > 0) {
	    headHtml += '<th>操作</th>';
	}
	headHtml += '</tr>';
	$("#" + table.id + " thead").html(headHtml);
	if (data && data['list'] && data['list'].length > 0) {
	    table.datas = data['list'];
	    // 编辑表格内容
	    var bodyHtml = '';
	    for (var j = 0; j < data['list'].length; j++) {
		var bdata = data['list'][j];
		if (j % 2 == 0) {
		    bodyHtml += "<tr class='grey'>";
		} else {
		    bodyHtml += "<tr>";
		}
		if (table.checkBox) {
		    bodyHtml += '<td width="5%"><input type="checkbox" data_index="'
			    + j + '"></label></div></td>';
		}
		if (table.hasNo) {
		    bodyHtml += '<td width="6%" style="text-align:center">'
			    + (param['pageSize'] * (param['pageNo'] - 1) + j + 1)
			    + '</td>';
		}
		for (var x = 0; x < fieldsSize; x++) {
		    var field = table.fields[x];
		    var buildFunc = field['buildField'];
		    var fieldText = bdata[field['field']];
		    if (buildFunc) {
			fieldText = buildFunc(bdata, fieldText);
		    }
		    bodyHtml += '<td>' + fieldText + '</td>';
		}
		if (actionsSize > 0) {
		    bodyHtml += '<td class="action">';
		    for (var y = 0; y < actionsSize; y++) {
			var action = table.actions[y];
			var actionName, actionType, actionIcon;
			if (action['name']) {
			    actionName = action['name'];
			    actionType = action['type'];
			    actionIcon = action['icon'];
			} else {
			    var buildFunc = action['buildField'];
			    var buildAction = buildFunc(bdata);
			    actionName = buildAction['name'];
			    actionType = buildAction['type'];
			    actionIcon = buildAction['icon'];
			}
			if (actionType == 'view') {
			    bodyHtml += '<a class="btn clickme'
				    + table.id
				    + ' btn-circle-view" data-toggle="tooltip" data-placement="top" title="'
				    + actionName + '" event_index="' + y
				    + '" data_index="' + j + '"><i class="'
				    + actionIcon + '"></i></a>';
			} else if (actionType == 'edit') {
			    bodyHtml += '<a class="btn clickme'
				    + table.id
				    + ' btn-circle-edit" data-toggle="tooltip" data-placement="top" title="'
				    + actionName + '" event_index="' + y
				    + '" data_index="' + j + '"><i class="'
				    + actionIcon + '"></i></a>';
			} else if (actionType == 'delete') {
			    bodyHtml += '<a class="btn clickme'
				    + table.id
				    + ' btn-circle-delete" data-toggle="tooltip" data-placement="top" title="'
				    + actionName + '" event_index="' + y
				    + '" data_index="' + j + '"><i class="'
				    + actionIcon + '"></i></a>';
			} else if (actionType != 'hide') {
			    bodyHtml += '<a class="btn clickme' + table.id
				    + ' blue"  event_index="' + y
				    + '" data_index="' + j + '">' + actionName
				    + '</a>';
			}
		    }
		    bodyHtml += '</td>';
		}
		bodyHtml += "</tr>";
	    }
	    $("#" + table.id + " tbody").html(bodyHtml);
	    // 绑定表格按钮事件
	    table.bindTableAction(table.id);
	    // 绑定checkbox事件
	    if (table.checkBox) {
		table.bindTableCheckBoxAction();
	    }
	    // 编辑表格分页
	    if (table.hasPage) {
		var footfieldSize = fieldsSize;
		if (actionsSize > 0) {
		    footfieldSize = footfieldSize + 1;
		}
		if (table.checkBox) {
		    footfieldSize = footfieldSize + 1;
		}
		if (table.hasNo) {
		    footfieldSize = footfieldSize + 1;
		}
		var footHtml = table.buildPageNav(data['pageNo'],
			data['totalPage'], data['pretPage'], data['nextPage'],
			data['totalCount']);
		$("#" + table.id + " tfoot").html(
			'<tr><td colspan="' + footfieldSize + '">' + footHtml
				+ '</td></tr>');
		// 绑定分页按钮事件
		table.bindPageNavAction(data['pageNo'], data['totalPage'],
			data['pretPage'], data['nextPage'], data['totalCount'],
			param);
	    }
	} else {
	    var bodyHtml = '';
	    $("#" + table.id + " tbody").html(bodyHtml);
	}
	my.plugin.initUniform();
	$('[data-toggle="tooltip"]').tooltip();
    };
    this.bindTableAction = function(table_id) {
	$('.clickme' + table_id).bind('click', function() {
	    var event_index = $(this).attr("event_index");
	    var data_index = $(this).attr("data_index");
	    if (event_index && data_index) {
		var actionFunc = table.actions[event_index]['action'];
		var bdata = table.datas[data_index];
		actionFunc(bdata);
	    }
	});
    };
    this.bindTableCheckBoxAction = function() {
	var thInputStr = "#" + table.tableId + " th input[type=checkbox]";
	var tdInputStr = "#" + table.tableId + " td input[type=checkbox]";
	$(thInputStr).bind('click', function() {
	    if ($(this)[0].checked) {
		var inputs = $(tdInputStr);
		for (var i = 0; i < inputs.length; i++) {
		    inputs.eq(i)[0].checked = true;
		}
	    } else {
		var inputs = $(tdInputStr);
		for (var i = 0; i < inputs.length; i++) {
		    inputs.eq(i)[0].checked = false;
		}
	    }
	    $.uniform.update();
	});
	$(tdInputStr).bind(
		'click',
		function() {
		    var inputs = $("#" + table.tableId + " td").find(
			    'input[type=checkbox]');
		    var selectInputs = $("#" + table.tableId + " td").find(
			    'input[type=checkbox]:checked');
		    if (inputs.length == selectInputs.length) {
			$(thInputStr)[0].checked = true;
		    } else {
			$(thInputStr)[0].checked = false;
		    }
		    $.uniform.update();
		});
    };
    this.getSelectData = function() {
	var dataArray = [];
	var selectInputs = $("#" + table.tableId + " td").find(
		'input[type=checkbox]:checked');
	for (var i = 0; i < selectInputs.length; i++) {
	    var data_index = $(selectInputs[i]).attr("data_index");
	    var bdata = table.datas[data_index];
	    dataArray.push(bdata);
	}
	return dataArray;
    };
    this.buildPageNav = function(pageNo, totalPage, pretPage, nextPage,
	    totalCount) {
	var html = "<ul class='pagination pull-right'>";
	if (pageNo != 1) {
	    html += "<li index='index'><a>首页</a></li>";
	    html += "<li index='prev'><a>上一页</a></li>";
	} else {
	    html += "<li class='disabled'><a>首页</a></li>";
	    html += "<li class='disabled'><a>上一页</a></li>";
	}
	for (var current = 1; current <= totalPage; current++) {
	    if (current - pageNo >= -5 && current - pageNo <= 5) {
		if (current == pageNo) {
		    html += "<li class='active'><a>" + current + "</a></li>";
		} else {
		    html += "<li index='" + current + "' ><a>" + current
			    + "</a></li>";
		}
	    }
	}
	if (pageNo != totalPage) {
	    html += "<li index='next'><a>下一页</a></li>";
	    html += "<li index='last'><a>末页</a></li>";
	} else {
	    html += "<li class='disabled'><a>下一页</a></li>";
	    html += "<li class='disabled'><a>末页</a></li>";
	}
	html += "<li class='disabled'><a>共" + totalPage + "页, 共" + totalCount
		+ "条数据</a></li>";
	html += "</ul>";
	return html;
    };
    this.bindPageNavAction = function(pageNo, totalPage, pretPage, nextPage,
	    totalCount, pageParam) {
	$("#" + table.id + " tfoot").find('.pagination li').click(function() {
	    pageParam["pageNo"] = 0;
	    var index = $(this).attr('index');
	    switch (index) {
	    case 'index':
		table.pageNo = 1;
		table.load(pageParam);
		break;
	    case 'prev':
		table.pageNo = pretPage;
		table.load(pageParam);
		break;
	    case 'next':
		table.pageNo = nextPage;
		table.load(pageParam);
		break;
	    case 'last':
		table.pageNo = totalPage;
		table.load(pageParam);
		break;
	    default:
		if (index > 0) {
		    table.pageNo = index;
		    table.load(pageParam);
		}
		break;
	    }
	});
    }
};

my.common.AjaxLoadTableNew = function(cfg) {
    var table = this;

    this.cfg = cfg || {};
    this.id = cfg.id || null;
    this.tableId = table.id + "_table";
    this.hasPage = cfg.hasPage || false;
    this.checkBox = cfg.checkBox || false;
    this.ajaxUrl = cfg.ajaxUrl || null;
    this.pageNo = cfg.pageNo || 1;
    this.pageSize = cfg.pageSize || 20;
    this.fields = cfg.fields || [];
    this.actions = cfg.actions || [];
    this.datas = null;

    this.load = function(param) {
	if (!param['pageNo'] || param['pageNo'] == 0) {
	    param['pageNo'] = table.pageNo;
	}
	param['pageSize'] = table.pageSize;
	this.param = param;
	table.loadData(param, table.buildTable);
    };
    this.loadData = function(param, callback) {
	$.ajax({
	    'url' : table.ajaxUrl,
	    'data' : param,
	    'type' : 'GET',
	    'dataType' : 'json',
	    'async' : true,
	    'beforeSend' : function() {

	    },
	    'success' : function(data) {
		if (table.pageNo != 1 && data['list'].length == 0) {
		    table.pageNo -= 1;
		    param['pageNo'] = table.pageNo;
		    table.loadData(param, callback);
		} else {
		    callback(data, param);
		}
	    },
	    'error' : function(e) {

	    }
	});

    };
    this.buildTable = function(data, param) {
	var html = '<table id="'
		+ table.tableId
		+ '" class="table table-hover"><thead></thead><tbody></tbody><tfoot></tfoot></table>';
	$("#" + table.id).html(html);
	// 编辑表格标题
	var headHtml = '<tr>';
	var fieldsSize = table.fields.length || 0;
	var actionsSize = table.actions.length || 0;
	if (table.checkBox) {
	    headHtml += '<th width="5%"></th>';
	}
	for (var i = 0; i < fieldsSize; i++) {
	    var field = table.fields[i];
	    var width = field["width"];
	    if (width && width > 0) {
		headHtml += '<th width="' + width + '%">' + field["title"]
			+ '</th>';
	    } else {
		headHtml += '<th>' + field["title"] + '</th>';
	    }
	}
	if (actionsSize > 0) {
	    headHtml += '<th>操作</th>';
	}
	headHtml += '</tr>';
	$("#" + table.id + " thead").html(headHtml);
	if (data && data['list'] && data['list'].length > 0) {
	    table.datas = data['list'];
	    // 编辑表格内容
	    var bodyHtml = '';
	    for (var j = 0; j < data['list'].length; j++) {
		var bdata = data['list'][j];
		if (j % 2 == 1) {
		    bodyHtml += "<tr class='grey'>";
		} else {
		    bodyHtml += "<tr>";
		}
		if (table.checkBox) {
		    bodyHtml += '<td width="5%"><input type="radio" name ="a"  data_index="'
			    + j + '"></label></div></td>';
		}
		for (var x = 0; x < fieldsSize; x++) {
		    var field = table.fields[x];
		    var buildFunc = field['buildField'];
		    var fieldText = bdata[field['field']];
		    if (buildFunc) {
			fieldText = buildFunc(bdata, fieldText);
		    }
		    bodyHtml += '<td>' + fieldText + '</td>';
		}
		if (actionsSize > 0) {
		    bodyHtml += '<td class="action">';
		    for (var y = 0; y < actionsSize; y++) {
			var action = table.actions[y];
			var actionName, actionType, actionIcon;
			if (action['name']) {
			    actionName = action['name'];
			    actionType = action['type'];
			    actionIcon = action['icon'];
			} else {
			    var buildFunc = action['buildField'];
			    var buildAction = buildFunc(bdata);
			    actionName = buildAction['name'];
			    actionType = buildAction['type'];
			    actionIcon = buildAction['icon'];
			}
			if (actionType == 'view') {
			    bodyHtml += '<a class="btn clickme'
				    + table.id
				    + ' btn-circle-view" data-toggle="tooltip" data-placement="top" title="'
				    + actionName + '" event_index="' + y
				    + '" data_index="' + j + '"><i class="'
				    + actionIcon + '"></i></a>';
			} else if (actionType == 'edit') {
			    bodyHtml += '<a class="btn clickme'
				    + table.id
				    + ' btn-circle-edit" data-toggle="tooltip" data-placement="top" title="'
				    + actionName + '" event_index="' + y
				    + '" data_index="' + j + '"><i class="'
				    + actionIcon + '"></i></a>';
			} else if (actionType == 'delete') {
			    bodyHtml += '<a class="btn clickme'
				    + table.id
				    + ' btn-circle-delete" data-toggle="tooltip" data-placement="top" title="'
				    + actionName + '" event_index="' + y
				    + '" data_index="' + j + '"><i class="'
				    + actionIcon + '"></i></a>';
			} else if (actionType != 'hide') {
			    bodyHtml += '<a class="btn clickme' + table.id
				    + ' blue"  event_index="' + y
				    + '" data_index="' + j + '">' + actionName
				    + '</a>';
			}
		    }
		    bodyHtml += '</td>';
		}
		bodyHtml += "</tr>";
	    }
	    $("#" + table.id + " tbody").html(bodyHtml);
	    // 绑定表格按钮事件
	    table.bindTableAction(table.id);
	    // 绑定checkbox事件
	    if (table.checkBox) {
		table.bindTableCheckBoxAction();
	    }
	    // 编辑表格分页
	    if (table.hasPage) {
		var footfieldSize = fieldsSize;
		if (actionsSize > 0) {
		    footfieldSize = footfieldSize + 1;
		}
		if (table.checkBox) {
		    footfieldSize = footfieldSize + 1;
		}
		var footHtml = table.buildPageNav(data['pageNo'],
			data['totalPage'], data['pretPage'], data['nextPage'],
			data['totalCount']);
		$("#" + table.id + " tfoot").html(
			'<tr><td colspan="' + footfieldSize + '">' + footHtml
				+ '</td></tr>');
		// 绑定分页按钮事件
		table.bindPageNavAction(data['pageNo'], data['totalPage'],
			data['pretPage'], data['nextPage'], data['totalCount'],
			param);
	    }
	} else {
	    var bodyHtml = '';
	    $("#" + table.id + " tbody").html(bodyHtml);
	}
	$('[data-toggle="tooltip"]').tooltip();
    };
    this.bindTableAction = function(table_id) {
	$('.clickme' + table_id).bind('click', function() {
	    var event_index = $(this).attr("event_index");
	    var data_index = $(this).attr("data_index");
	    if (event_index && data_index) {
		var actionFunc = table.actions[event_index]['action'];
		var bdata = table.datas[data_index];
		actionFunc(bdata);
	    }
	});
    };
    this.bindTableCheckBoxAction = function() {
	var thInputStr = "#" + table.tableId + " th input[type=radio]";
	var tdInputStr = "#" + table.tableId + " td input[type=radio]";
	$(thInputStr).bind('click', function() {
	    if ($(this)[0].checked) {
		var inputs = $(tdInputStr);
		for (var i = 0; i < inputs.length; i++) {
		    inputs.eq(i)[0].checked = true;
		}
	    } else {
		var inputs = $(tdInputStr);
		for (var i = 0; i < inputs.length; i++) {
		    inputs.eq(i)[0].checked = false;
		}
	    }
	});
	$(tdInputStr).bind(
		'click',
		function() {
		    var inputs = $("#" + table.tableId + " td").find(
			    'input[type=radio]');
		    var selectInputs = $("#" + table.tableId + " td").find(
			    'input[type=radio]:checked');
		    if (inputs.length == selectInputs.length) {
			$(thInputStr)[0].checked = true;
		    } else {
			$(thInputStr)[0].checked = false;
		    }
		});
    };
    this.getSelectData = function() {
	var dataArray = [];
	var selectInputs = $("#" + table.tableId + " td").find(
		'input[type=radio]:checked');
	for (var i = 0; i < selectInputs.length; i++) {
	    var data_index = $(selectInputs[i]).attr("data_index");
	    var bdata = table.datas[data_index];
	    dataArray.push(bdata);
	}
	return dataArray;
    };
    this.buildPageNav = function(pageNo, totalPage, pretPage, nextPage,
	    totalCount) {
	var html = "<ul class='pagination pull-right'>";
	if (pageNo != 1) {
	    html += "<li index='index'><a>首页</a></li>";
	    html += "<li index='prev'><a>上一页</a></li>";
	} else {
	    html += "<li class='disabled'><a>首页</a></li>";
	    html += "<li class='disabled'><a>上一页</a></li>";
	}
	for (var current = 1; current <= totalPage; current++) {
	    if (current - pageNo >= -5 && current - pageNo <= 5) {
		if (current == pageNo) {
		    html += "<li class='active'><a>" + current + "</a></li>";
		} else {
		    html += "<li index='" + current + "' ><a>" + current
			    + "</a></li>";
		}
	    }
	}
	if (pageNo != totalPage) {
	    html += "<li index='next'><a>下一页</a></li>";
	    html += "<li index='last'><a>末页</a></li>";
	} else {
	    html += "<li class='disabled'><a>下一页</a></li>";
	    html += "<li class='disabled'><a>末页</a></li>";
	}
	html += "<li class='disabled'><a>共" + totalPage + "页, 共" + totalCount
		+ "条数据</a></li>";
	html += "</ul>";
	return html;
    };
    this.bindPageNavAction = function(pageNo, totalPage, pretPage, nextPage,
	    totalCount, pageParam) {
	$("#" + table.id + " tfoot").find('.pagination li').click(function() {
	    pageParam["pageNo"] = 0;
	    var index = $(this).attr('index');
	    switch (index) {
	    case 'index':
		table.pageNo = 1;
		table.load(pageParam);
		break;
	    case 'prev':
		table.pageNo = pretPage;
		table.load(pageParam);
		break;
	    case 'next':
		table.pageNo = nextPage;
		table.load(pageParam);
		break;
	    case 'last':
		table.pageNo = totalPage;
		table.load(pageParam);
		break;
	    default:
		if (index > 0) {
		    table.pageNo = index;
		    table.load(pageParam);
		}
		break;
	    }
	});
    }
};

my.common.AjaxLoadList = function(cfg) {
    var list = this;

    this.cfg = cfg || {};
    this.id = cfg.id || null;
    this.listId = list.id + "_list";
    this.hasPage = cfg.hasPage || false;
    this.ajaxUrl = cfg.ajaxUrl || null;
    this.pageNo = cfg.pageNo || 1;
    this.pageSize = cfg.pageSize || 20;
    this.fields = cfg.fields || [];
    this.actions = cfg.actions || [];
    this.datas = null;

    this.load = function(param) {
	if (!param['pageNo'] || param['pageNo'] == 0) {
	    param['pageNo'] = list.pageNo;
	}
	param['pageSize'] = list.pageSize;
	this.param = param;
	list.loadData(param, list.buildTable);
    };
    this.loadData = function(param, callback) {
	$.ajax({
	    'url' : list.ajaxUrl,
	    'data' : param,
	    'type' : 'GET',
	    'dataType' : 'json',
	    'async' : true,
	    'beforeSend' : function() {

	    },
	    'success' : function(data) {
		if (list.pageNo != 1 && data['list'].length == 0) {
		    list.pageNo -= 1;
		    param['pageNo'] = list.pageNo;
		    list.loadData(param, callback);
		} else {
		    callback(data, param);
		}
	    },
	    'error' : function(e) {
	    }
	});

    };
    this.buildTable = function(data, param) {
	var bodyHtml = '<div id="' + list.listId + '" class="container">';
	if (data && data['list'] && data['list'].length > 0) {
	    bodyHtml += "<ul>";
	    list.datas = data['list'];
	    // 编辑表格内容
	    for (var j = 0; j < data['list'].length; j++) {
		var bdata = data['list'][j];
		var fieldsSize = list.fields.length || 0;
		var actionsSize = list.actions.length || 0;
		var actionWidth = 10;
		bodyHtml += "<li style='list-style-type:none;'><div class='row'><div class='col-md-12'>";
		for (var x = 0; x < fieldsSize; x++) {
		    var field = list.fields[x];
		    var buildFunc = field['buildField'];
		    var fieldText = bdata[field['field']];
		    var width = field['width'];
		    if (buildFunc) {
			fieldText = buildFunc(bdata, fieldText);
		    }
		    if (x == 0) {
			bodyHtml += "<div class='col-md-offset-1 col-sm-offset-1 col-md-"
				+ width
				+ " col-sm-"
				+ width
				+ "'><img style='display:inline-block;height:auto;max-width:100%' src='"
				+ fieldText + "'/></div>";
			actionWidth -= width;

		    } else if (x == 1) {
			bodyHtml += "<div class='col-md-" + width + " col-sm-"
				+ width + "'><div class='row'>" + fieldText
				+ '</div>';
			actionWidth -= width;
		    } else if (x == 2) {
			bodyHtml += "<div class='row'>" + fieldText
				+ "</div></div>";
		    }
		}
		if (actionsSize > 0) {
		    bodyHtml += "<div class='col-md-" + actionWidth
			    + " col-sm-" + actionWidth + "'>";
		    for (var y = 0; y < actionsSize; y++) {
			var action = list.actions[y];
			var actionName, actionType, actionIcon;
			if (action['name']) {
			    actionName = action['name'];
			    actionType = action['type'];
			    actionIcon = action['icon'];
			} else {
			    var buildFunc = action['buildField'];
			    var buildAction = buildFunc(bdata);
			    actionName = buildAction['name'];
			    actionType = buildAction['type'];
			    actionIcon = buildAction['icon'];
			}
			if (actionType == 'view') {
			    bodyHtml += '<a class="btn clickme btn-circle-view" data-toggle="tooltip" data-placement="top" title="'
				    + actionName
				    + '" event_index="'
				    + y
				    + '" data_index="'
				    + j
				    + '"><i class="'
				    + actionIcon + '"></i></a>';
			} else if (actionType == 'edit') {
			    bodyHtml += '<a class="btn clickme btn-circle-edit" data-toggle="tooltip" data-placement="top" title="'
				    + actionName
				    + '" event_index="'
				    + y
				    + '" data_index="'
				    + j
				    + '"><i class="'
				    + actionIcon + '"></i></a>';
			} else if (actionType == 'delete') {
			    bodyHtml += '<a class="btn clickme btn-circle-delete" data-toggle="tooltip" data-placement="top" title="'
				    + actionName
				    + '" event_index="'
				    + y
				    + '" data_index="'
				    + j
				    + '"><i class="'
				    + actionIcon + '"></i></a>';
			} else if (actionType != 'hide') {
			    bodyHtml += '<a class="btn clickme' + list.id
				    + ' blue"  event_index="' + y
				    + '" data_index="' + j + '">' + actionName
				    + '</a>';
			}
		    }
		    bodyHtml += "</div>";
		}
		bodyHtml += "</div></div><hr></li>";
	    }
	    bodyHtml += "</ul>";
	    // 编辑表格分页
	    if (list.hasPage) {
		bodyHtml += list.buildPageNav(data['pageNo'],
			data['totalPage'], data['pretPage'], data['nextPage'],
			data['totalCount']);
	    }
	}
	bodyHtml += "</div>";
	$("#" + list.id).html(bodyHtml);
	// 绑定表格按钮事件
	list.bindTableAction();
	if (list.hasPage) {
	    // 绑定分页按钮事件
	    list.bindPageNavAction(data['pageNo'], data['totalPage'],
		    data['pretPage'], data['nextPage'], data['totalCount'],
		    param);
	}
	$('[data-toggle="tooltip"]').tooltip();
    };
    this.bindTableAction = function() {
	$('#' + this.id).find('.clickme').bind('click', function() {
	    var event_index = $(this).attr("event_index");
	    var data_index = $(this).attr("data_index");
	    if (event_index && data_index) {
		var actionFunc = list.actions[event_index]['action'];
		var bdata = list.datas[data_index];
		actionFunc(bdata);
	    }
	});
    };
    this.buildPageNav = function(pageNo, totalPage, pretPage, nextPage,
	    totalCount) {
	var html = "<ul class='pagination pull-right'>";
	if (pageNo != 1) {
	    html += "<li index='index'><a>首页</a></li>";
	    html += "<li index='prev'><a>上一页</a></li>";
	} else {
	    html += "<li class='disabled'><a>首页</a></li>";
	    html += "<li class='disabled'><a>上一页</a></li>";
	}
	for (var current = 1; current <= totalPage; current++) {
	    if (current - pageNo >= -5 && current - pageNo <= 5) {
		if (current == pageNo) {
		    html += "<li class='active'><a>" + current + "</a></li>";
		} else {
		    html += "<li index='" + current + "' ><a>" + current
			    + "</a></li>";
		}
	    }
	}
	if (pageNo != totalPage) {
	    html += "<li index='next'><a>下一页</a></li>";
	    html += "<li index='last'><a>末页</a></li>";
	} else {
	    html += "<li class='disabled'><a>下一页</a></li>";
	    html += "<li class='disabled'><a>末页</a></li>";
	}
	html += "<li class='disabled'><a>共" + totalPage + "页, 共" + totalCount
		+ "条数据</a></li>";
	html += "</ul>";
	return html;
    };
    this.bindPageNavAction = function(pageNo, totalPage, pretPage, nextPage,
	    totalCount, pageParam) {
	$("#" + list.id).find('.pagination li').click(function() {
	    pageParam["pageNo"] = 0;
	    var index = $(this).attr('index');
	    switch (index) {
	    case 'index':
		list.pageNo = 1;
		list.load(pageParam);
		break;
	    case 'prev':
		list.pageNo = pretPage;
		list.load(pageParam);
		break;
	    case 'next':
		list.pageNo = nextPage;
		list.load(pageParam);
		break;
	    case 'last':
		list.pageNo = totalPage;
		list.load(pageParam);
		break;
	    default:
		if (index > 0) {
		    list.pageNo = index;
		    list.load(pageParam);
		}
		break;
	    }
	});
    }
};
my.common.AjaxLoadListNew = function(cfg) {
    var list = this;

    this.cfg = cfg || {};
    this.id = cfg.id || null;
    this.listId = list.id + "_list";
    this.hasPage = cfg.hasPage || false;
    this.ajaxUrl = cfg.ajaxUrl || null;
    this.pageNo = cfg.pageNo || 1;
    this.pageSize = cfg.pageSize || 20;
    this.fields = cfg.fields || [];
    this.actions = cfg.actions || [];
    this.datas = null;

    this.load = function(param) {
	if (!param['pageNo'] || param['pageNo'] == 0) {
	    param['pageNo'] = list.pageNo;
	}
	param['pageSize'] = list.pageSize;
	this.param = param;
	list.loadData(param, list.buildTable);
    };
    this.loadData = function(param, callback) {
	$.ajax({
	    'url' : list.ajaxUrl,
	    'data' : param,
	    'type' : 'GET',
	    'dataType' : 'json',
	    'async' : true,
	    'beforeSend' : function() {

	    },
	    'success' : function(data) {
		if (list.pageNo != 1 && data['list'].length == 0) {
		    list.pageNo -= 1;
		    param['pageNo'] = list.pageNo;
		    list.loadData(param, callback);
		} else {
		    callback(data, param);
		}
	    },
	    'error' : function(e) {
	    }
	});

    };
    this.buildTable = function(data, param) {
	var bodyHtml = '<div id="' + list.listId + '" class="container">';
	if (data && data['list'] && data['list'].length > 0) {
	    bodyHtml += "<ul>";
	    list.datas = data['list'];
	    // 编辑表格内容
	    for (var j = 0; j < data['list'].length; j++) {
		var bdata = data['list'][j];
		var fieldsSize = list.fields.length || 0;
		var actionsSize = list.actions.length || 0;
		var actionWidth = 10;
		bodyHtml += "<li style='list-style-type:none;'><div class='row'><div class='col-md-12'>";
		for (var x = 0; x < fieldsSize; x++) {
		    var field = list.fields[x];
		    var buildFunc = field['buildField'];
		    var fieldText = bdata[field['field']];
		    var width = field['width'];
		    if (buildFunc) {
			fieldText = buildFunc(bdata, fieldText);
		    }
		    if (x == 0) {
			bodyHtml += "<div class='col-md-" + width + " col-sm-"
				+ width + "'>" + fieldText + '</div>';
			actionWidth -= width;
		    } else if (x == 1) {
			bodyHtml += "<div class='col-md-" + width + " col-sm-"
				+ width + "'>" + fieldText + '</div>';
		    }
		}
		if (actionsSize > 0) {
		    bodyHtml += "<div class='col-md-" + actionWidth
			    + " col-sm-" + actionWidth + "'>";
		    for (var y = 0; y < actionsSize; y++) {
			var action = list.actions[y];
			var actionName, actionType, actionIcon;
			if (action['name']) {
			    actionName = action['name'];
			    actionType = action['type'];
			    actionIcon = action['icon'];
			} else {
			    var buildFunc = action['buildField'];
			    var buildAction = buildFunc(bdata);
			    actionName = buildAction['name'];
			    actionType = buildAction['type'];
			    actionIcon = buildAction['icon'];
			}
			if (actionType == 'view') {
			    bodyHtml += '<a class="btn clickme btn-circle-view" data-toggle="tooltip" data-placement="top" title="'
				    + actionName
				    + '" event_index="'
				    + y
				    + '" data_index="'
				    + j
				    + '"><i class="'
				    + actionIcon + '"></i></a>';
			} else if (actionType == 'edit') {
			    bodyHtml += '<a class="btn clickme btn-circle-edit" data-toggle="tooltip" data-placement="top" title="'
				    + actionName
				    + '" event_index="'
				    + y
				    + '" data_index="'
				    + j
				    + '"><i class="'
				    + actionIcon + '"></i></a>';
			} else if (actionType == 'delete') {
			    bodyHtml += '<a class="btn clickme btn-circle-delete" data-toggle="tooltip" data-placement="top" title="'
				    + actionName
				    + '" event_index="'
				    + y
				    + '" data_index="'
				    + j
				    + '"><i class="'
				    + actionIcon + '"></i></a>';
			} else if (actionType != 'hide') {
			    bodyHtml += '<a class="btn clickme' + list.id
				    + ' blue"  event_index="' + y
				    + '" data_index="' + j + '">' + actionName
				    + '</a>';
			}
		    }
		    bodyHtml += "</div>";
		}
		bodyHtml += "</div></div><br/></li>";
	    }
	    bodyHtml += "</ul>";
	    // 编辑表格分页
	    if (list.hasPage) {
		bodyHtml += list.buildPageNav(data['pageNo'],
			data['totalPage'], data['pretPage'], data['nextPage'],
			data['totalCount']);
	    }
	}
	bodyHtml += "</div>";
	$("#" + list.id).html(bodyHtml);
	// 绑定表格按钮事件
	list.bindTableAction();
	if (list.hasPage) {
	    // 绑定分页按钮事件
	    list.bindPageNavAction(data['pageNo'], data['totalPage'],
		    data['pretPage'], data['nextPage'], data['totalCount'],
		    param);
	}
	$('[data-toggle="tooltip"]').tooltip();
    };
    this.bindTableAction = function() {
	$('#' + this.id).find('.clickme').bind('click', function() {
	    var event_index = $(this).attr("event_index");
	    var data_index = $(this).attr("data_index");
	    if (event_index && data_index) {
		var actionFunc = list.actions[event_index]['action'];
		var bdata = list.datas[data_index];
		actionFunc(bdata);
	    }
	});
    };
    this.buildPageNav = function(pageNo, totalPage, pretPage, nextPage,
	    totalCount) {
	var html = "<ul class='pagination pull-right'>";
	if (pageNo != 1) {
	    html += "<li index='index'><a>首页</a></li>";
	    html += "<li index='prev'><a>上一页</a></li>";
	} else {
	    html += "<li class='disabled'><a>首页</a></li>";
	    html += "<li class='disabled'><a>上一页</a></li>";
	}
	for (var current = 1; current <= totalPage; current++) {
	    if (current - pageNo >= -5 && current - pageNo <= 5) {
		if (current == pageNo) {
		    html += "<li class='active'><a>" + current + "</a></li>";
		} else {
		    html += "<li index='" + current + "' ><a>" + current
			    + "</a></li>";
		}
	    }
	}
	if (pageNo != totalPage) {
	    html += "<li index='next'><a>下一页</a></li>";
	    html += "<li index='last'><a>末页</a></li>";
	} else {
	    html += "<li class='disabled'><a>下一页</a></li>";
	    html += "<li class='disabled'><a>末页</a></li>";
	}
	html += "<li class='disabled'><a>共" + totalPage + "页, 共" + totalCount
		+ "条数据</a></li>";
	html += "</ul>";
	return html;
    };
    this.bindPageNavAction = function(pageNo, totalPage, pretPage, nextPage,
	    totalCount, pageParam) {
	$("#" + list.id).find('.pagination li').click(function() {
	    pageParam["pageNo"] = 0;
	    var index = $(this).attr('index');
	    switch (index) {
	    case 'index':
		list.pageNo = 1;
		list.load(pageParam);
		break;
	    case 'prev':
		list.pageNo = pretPage;
		list.load(pageParam);
		break;
	    case 'next':
		list.pageNo = nextPage;
		list.load(pageParam);
		break;
	    case 'last':
		list.pageNo = totalPage;
		list.load(pageParam);
		break;
	    default:
		if (index > 0) {
		    list.pageNo = index;
		    list.load(pageParam);
		}
		break;
	    }
	});
    }
};

// 各种第三方插件方法
my.register('my.plugin');
my.plugin = {
    initUniform : function(els) {
	if (els) {
	    $(els).each(function() {
		if ($(this).parents(".checker").size() === 0) {
		    $(this).show();
		    $(this).uniform();
		}
	    });
	} else {
	    my.plugin.handleUniform();
	}
    },

    // wrMetronicer function to update/sync jquery uniform checkbox & radios
    updateUniform : function(els) {
	$.uniform.update(els); // update the uniform checkbox & radios UI after
	// the actual input control state changed
    },
    handleUniform : function() {
	if (!$().uniform) {
	    return;
	}
	var test = $("input[type=checkbox], input[type=radio]");
	if (test.size() > 0) {
	    test.each(function() {
		if ($(this).parents(".checker").size() === 0) {
		    $(this).show();
		    $(this).uniform();
		}
	    });
	}
    },
    initDatePickers : function() {
	// 日期选择
	if (jQuery().datepicker) {
	    $('.date-picker').datepicker({
		rtl : false,
		orientation : "left",
		autoclose : true,
		language : "zh-CN"
	    });
	}
    }
}
my.register('my.menuTree');
my.menuTree = {
    init : function() {
	$(".menuTree").on(
		"click",
		"a",
		function() {
		    var targetAction = $(this).attr("target-action");
		    // 判断是否有targetAction
		    if (targetAction == 'menu') {
			if ($(this).parent().hasClass("open")) {
			    $(this).parent().removeClass("open");
			} else {
			    $(this).parent().addClass("open");
			}
		    } else if (targetAction == 'link') {
			var targetUrl = $(this).attr("target-url");
			if (targetUrl && targetUrl.length > 0) {
			    // location.href实现客户端页面的跳转
			    location.href = targetUrl;
			} else {
			    tips("菜单缺少URL地址", 'error');
			}
		    } else if (targetAction == 'tab') {
			var id = $(this).attr('id');
			var name = $(this).text();
			var url = $(this).attr('target-url');
			FrameCall.father("my.desktop.openMenu", "'" + id
				+ "','" + name + "','" + url + "'");
		    }
		});
    }
}

// 判断字符串是否为空
function isNotEmpty(str) {
    if (str != null && str.length > 0) {
	return true;
    }
    return false;
}

function isEmpty(str) {
    return !isNotEmpty(str);
}
// 日期格式化
function dateFormat(time, format) {
    if (!time)
	return null;
    var date = new Date(time);
    var o = {
	"M+" : date.getMonth() + 1, // month
	"d+" : date.getDate(), // day
	"h+" : date.getHours(), // hour
	"m+" : date.getMinutes(), // minute
	"s+" : date.getSeconds(), // second
	"q+" : Math.floor((date.getMonth() + 3) / 3), // quarter
	"S" : date.getMilliseconds()
    // millisecond
    };
    if (/(y+)/.test(format)) {
	format = format.replace(RegExp.$1, (date.getFullYear() + "")
		.substr(4 - RegExp.$1.length));
    }
    for ( var k in o) {
	if (new RegExp("(" + k + ")").test(format)) {
	    format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
		    : ("00" + o[k]).substr(("" + o[k]).length));
	}
    }
    return format;
};
// 防止事件冒泡
function stopEP(e) {
    e = e || window.event;
    if (e.stopPropagation) {
	e.stopPropagation();
    }
    if (e.preventDefault) {
	e.preventDefault();
    }
    e.cancelBubble = true;
    e.keyCode = 0;
    e.returnValue = false;
}

// 添加startWith原生方法
String.prototype.startWith = function(s) {
    if (s == null || s == "" || this.length == 0 || s.length > this.length) {
	return false;
    }
    if (this.substr(0, s.length) == s) {
	return true;
    } else {
	return false;
    }
    return true;
}

/*
 * iframe之间函数调用
 * 
 * main frame中每个frame需要name和id，以便兼容多浏览器 如果需要提供给其他frame调用，则需要在body中加入 <input
 * id="FrameCall" type='hidden' action='' value='' onclick='FrameCall.api()'/>
 * 调用例子：Frame.doFunction('main','goUrl','"'+url+'"');该frame调用id为main的兄弟frame的goUrl方法，参数为后面的
 * 参数为字符串时需要加引号，否则传过去会被理解成一个未定义变量
 */
var FrameCall = (function() {
    var idName = "FrameCall";
    var idNameAll = "#" + idName;
    var ie = !-[ 1, ]; // 是否ie
    return {
	apiOpen : function() {
	    var html = '<input id="FrameCall" type="hidden" action="1" value="1" onclick="FrameCall.api()" />';
	    $(html).prependTo('body');
	},
	// 其他窗口调用该窗口函数，调用另一个frame的方法
	api : function() {
	    var action = $(idNameAll).attr('action');
	    var value = $(idNameAll).attr('value');
	    var fun = action + '(' + value + ');'; // 拼装执行语句，字符串转换到代码
	    try {
		eval(fun);
	    } catch (e) {
		console.log(e);
	    }
	    ;
	},
	// 该窗口调用顶层窗口的子窗口api,调用iframe框架的js函数.封装控制器。
	top : function(iframe, action, value) {
	    if (!window.parent.frames[iframe])
		return;
	    // var obj = window.top.frames[iframe].document;
	    var obj = window.parent.frames[iframe].document;
	    obj = obj.getElementById(idName);
	    $(obj).attr("action", action);
	    $(obj).attr("value", value);
	    obj.click();
	},
	// 该窗口调用父窗口的api
	father : function(action, value) {
	    if (ie) { // 获取兄弟frame的dom树
		var obj = window.parent.document; // IE
	    } else {
		var obj = window.parent.document; // chrome safari firefox...
	    }
	    obj = obj.getElementById(idName);
	    if ($(obj).length > 0) {
		$(obj).attr("action", action);
		$(obj).attr("value", value);
		obj.click();
	    } else {
		tips("调用父类窗口api失败", 'error');
	    }
	},
	// ___自定义通用方法，可在页面定义更多提供给接口使用的api。
	goUrl : function(url) {
	    window.location.href = url;
	},
	goRefresh : function() {
	    window.location.reload();
	}
    }
})();

// 通用提示信息框success/info/warning/error
var tips = function(msg, code) {
    Tips.tips(msg, code, 0);
};
var Tips = (function() {
    var in_time = 600;
    var delay = 5000;
    var opacity = 0.7;
    var _init = function(msg, code) {
	var tipsIDname = "messageTips";
	var tipsID = "#" + tipsIDname;
	if ($(tipsID).length == 0) {
	    var html = '<div id="'
		    + tipsIDname
		    + '" style="z-index:20000;min-width:60px;position:fixed;padding:2px 2em;text-align:center;line-height:30px;border-bottom-right-radius:0px;border-bottom-left-radius:0px;"><i style="padding: 0 6px;font-size: 15px;"></i><span></span></div>'
	    $('body').append(html);
	    $(window).bind('resize', function() {
		if ($(tipsID).css('display') == "none")
		    return;
		self.stop(true, true)
		$(tipsID).css({
		    'left' : ($(window).width() - $(tipsID).width()) / 2
		});
	    });
	}
	var self = $(tipsID), icon, color;
	switch (code) {
	case 100: // 加长时间 5s
	case true:
	case undefined:
	case 'success':
	    color = '#5cb85c';
	    icon = 'iconfont icon-roundcheck';
	    break;
	case 'info':
	    color = '#519AF6';
	    icon = 'iconfont icon-information';
	    break;
	case 'warning':
	    color = '#ed9c28';
	    icon = 'iconfont icon-question';
	    break;
	case false:
	case 'error':
	    color = '#d9534f';
	    icon = 'iconfont icon-roundclose';
	    break;
	default:
	    color = '';
	    icon = '';
	    break;
	}

	if (color != '') {
	    self.css({
		'background' : color,
		'color' : '#fff'
	    });
	    self.find('i').removeClass().addClass(icon);
	}
	if (msg != undefined)
	    self.find('span').html(msg);
	return self;
    };
    var tips = function(msg, code, offset_top) {
	if (typeof (msg) == 'object') {
	    code = msg.code;
	    msg = msg.data;
	}
	if (offset_top == undefined)
	    offset_top = 0;
	var self = _init(msg, code);
	if (code == 100) {
	    delay = 3500;
	}
	self.stop(true, true).css({
	    'display' : 'block',
	    'opacity' : '0',
	    'top' : offset_top - self.height(),
	    'left' : ($(window).width() - self.width()) / 2
	}).animate({
	    opacity : opacity,
	    top : offset_top
	}, in_time, 0).delay(delay).animate({
	    opacity : 0,
	    top : '-=' + (offset_top + self.height())
	}, in_time, 0, function() {
	    $(this).css('display', 'none');
	});
    };
    var loading = function(msg, code, offset_top) {
	if (typeof (msg) == 'object') {
	    code = msg.code;
	    msg = msg.data;
	}
	if (offset_top == undefined)
	    offset_top = 0;
	if (msg == undefined)
	    msg = 'loading...';

	var self = _init(msg, code);
	self.stop(true, true).css({
	    'display' : 'block',
	    'opacity' : '0',
	    'top' : offset_top - self.height(),
	    'left' : ($(window).width() - self.width()) / 2
	}).animate({
	    opacity : opacity,
	    top : offset_top
	}, in_time, 0);
    };
    var close = function(msg, code, offset_top) {
	if (typeof (msg) == 'object') {
	    code = msg.code;
	    msg = msg.data;
	}
	if (offset_top == undefined)
	    offset_top = 0;
	var self = _init(msg, code);

	self.delay(delay).animate({
	    opacity : 0,
	    top : '-=' + (offset_top + self.height())
	}, in_time, 0, function() {
	    $(this).css('display', 'none');
	});
    };
    return {
	tips : tips,
	loading : loading,
	close : close
    }
})();
/** 显示bootstrap的tooltip* */
$(function() {
    $('[data-toggle="tooltip"]').tooltip();
});

Ext.ns("App");
Ext.ns("AppUtil");
function strToDom(a) {
	if (window.ActiveXObject) {
		var b = new ActiveXObject("Microsoft.XMLDOM");
		b.async = "false";
		b.loadXML(a);
		return b;
	} else {
		if (document.implementation && document.implementation.createDocument) {
			var c = new DOMParser();
			var b = c.parseFromString(a, "text/xml");
			return b;
		}
	}
}
function newView(viewName, params) {
	var str = "new " + viewName;
	if (params != null) {
		str += "(params);";
	} else {
		str += "();";
	}
	return eval(str);
}

function usingJs(viewName, callback, params) {
	using(viewName,function(){
		var view = newView(viewName, params);
		callback.call(this, view);
	});
}


function $ImportJs(viewName, callback, params) {
	var b = document.getElementById(viewName + "-hiden");
	if (b != null) {
		var view = newView(viewName, params);
		callback.call(this, view);
	} else {
		var jsArr = eval("App.importJs." + viewName);
		if (jsArr == undefined || jsArr.length == 0) {
			var view = newView(viewName, params);
			callback.call(this, view);
			return;
		}
		ScriptMgr.load( {
			scripts : jsArr,
			callback : function() {
				Ext.DomHelper.append(document.body, "<div id='" + viewName
						+ "-hiden' style='display:none'></div>");
				var view = newView(viewName, params);
				callback.call(this, view);
			}
		});
	}
}
function $ImportSimpleJs(a, b) {
	ScriptMgr.load( {
		scripts : a,
		callback : function() {
			if (b) {
				b.call(this);
			}
		}
	});
}
App.getContentPanel = function() {
	var a = Ext.getCmp("centerTabPanel");
	return a;
};
App.createUploadDialog = function(b) {
	var a = {
		file_cat : "others",
		url : __ctxPath + "/file-upload",
		reset_on_hide : false,
		upload_autostart : false,
		modal : true
	};
	Ext.apply(a, b);
	var c = new Ext.ux.UploadDialog.Dialog(a);
	return c;
};
function uniqueArray(e) {
	e = e || [];
	var b = {};
	for ( var d = 0; d < e.length; d++) {
		var c = e[d];
		if (typeof (b[c]) == "undefined") {
			b[c] = 1;
		}
	}
	e.length = 0;
	for ( var d in b) {
		e[e.length] = d;
	}
	return e;
}
function setCookie(b, d, a, f, c, e) {
	document.cookie = b + "=" + escape(d)
			+ ((a) ? "; expires=" + a.toGMTString() : "")
			+ ((f) ? "; path=" + f : "") + ((c) ? "; domain=" + c : "")
			+ ((e) ? "; secure" : "");
}
function getCookie(b) {
	var d = b + "=";
	var e = document.cookie.indexOf(d);
	if (e == -1) {
		return null;
	}
	var a = document.cookie.indexOf(";", e + d.length);
	if (a == -1) {
		a = document.cookie.length;
	}
	var c = document.cookie.substring(e + d.length, a);
	return unescape(c);
}
function deleteCookie(a, c, b) {
	if (getCookie(a)) {
		document.cookie = a + "=" + ((c) ? "; path=" + c : "")
				+ ((b) ? "; domain=" + b : "")
				+ "; expires=Thu, 01-Jan-70 00:00:01 GMT";
	}
}
String.prototype.trim = function() {
	return (this.replace(/^[\s\xA0]+/, "").replace(/[\s\xA0]+$/, ""));
};
function $request(a) {
	Ext.Ajax.request( {
		url : a.url,
		params : a.params,
		method : a.method == null ? "POST" : a.method,
		success : function(b, c) {
			if (a.success != null) {
				a.success.call(this, b, c);
			}
		},
		failure : function(b, c) {
			Ext.ux.Toast.msg("操作信息", "操作出错，请联系管理员！");
			if (a.success != null) {
				a.failure.call(this, b, c);
			}
		}
	});
}
AppUtil.addPrintExport = function(a) {
	var b = new Ext.ux.Exporter.Button( {
		component : a,
		iconCls : "btn-excel",
		text : "导出"
	});
	a.getTopToolbar().add("->");
	a.getTopToolbar().add(b);
	a.getTopToolbar().add(new Ext.Button( {
		text : "打印",
		iconCls : "btn-print",
		handler : function() {
			Ext.ux.Printer.print(a);
		}
	}));
};
AppUtil.removeTab = function(a) {
	var b = App.getContentPanel();
	var c = b.getItem(a);
	if (c != null) {
		b.remove(c, true);
	}
};
AppUtil.activateTab = function(a) {
	var b = App.getContentPanel();
	b.activate(a);
};
Ext.ns("App");
var UserInfo = function(c, a, b, e, d) {
	this.userId = c;
	this.fullname = a;
	this.depId = b;
	this.depName = e;
	this.rights = d;
};
var curUserInfo = null;
function isGranted(a) {
	if (curUserInfo.rights.indexOf("__ALL") != -1) {
		return true;
	}
	if (curUserInfo.rights.indexOf(a) != -1) {
		return true;
	}
	return false;
}
App.init = function() {
	Ext.QuickTips.init();
	Ext.BLANK_IMAGE_URL = __ctxPath + "/ext3/resources/images/default/s.gif";
	setTimeout(function() {
		Ext.get("loading").remove();
		Ext.get("loading-mask").fadeOut( {
			remove : true
		});
	}, 1000);
	Ext.util.Observable.observeClass(Ext.data.Connection);
	Ext.data.Connection.on("requestcomplete", function(c, d, b) {
		if (d && d.getResponseHeader) {
			if (d.getResponseHeader("__timeout")) {
				Ext.ux.Toast.msg("操作提示：", "操作已经超时，请重新登录!");
				window.location.href = __ctxPath + "/index.jsp?randId="
						+ parseInt(1000 * Math.random());
			}
			if (d.getResponseHeader("__forbidden")) {
				Ext.ux.Toast.msg("系统访问权限提示：", "你目前没有权限访问：{0}", b.url);
			}
		}
	});
	Ext.Ajax.request( {
		url : __ctxPath + "/Authentication/CurrentAppUser.do?random="
				+ Math.random(),
		method : "Get",
		success : function(c, e) {
			var d = Ext.util.JSON.decode(c.responseText);
			var b = d.user;
			curUserInfo = new UserInfo(b.userId, b.fullname, b.depId,
					b.depName, b.rights);
		}
	});
	var a = new IndexPage();
};
/*
App.clickTopTab = function(f, c, a, e) {
	if (a != null) {
		a.call(this);
	}
	var b = Ext.getCmp("centerTabPanel");
	var d = b.getItem(f);
	if (d == null) {
		$ImportJs(f, function(g) {
			d = b.add(g);
			b.activate(d);
		}, c);
	} else {
		if (e != null) {
			e.call(this);
		}
		b.activate(d);
	}
};*/
App.clickTopTab = function(f, c, a, e) {
	if (a != null) {
		a.call(this);
	}
	var b = Ext.getCmp("centerTabPanel");
	var d = b.getItem(f);
	if (d == null) {
		usingJs(f, function(g) {
			d = b.add(g);
			b.activate(d);
		}, c);
	}else{
		b.activate(d);
	}
};
	
App.clickNode = function(a) {
	if (a.id == null || a.id == "" || a.id.indexOf("xnode") != -1) {
		return;
	}
	App.clickTopTab(a.id);
};
App.MyDesktopClick = function() {
	var a = Ext.getCmp("MyDesktop");
	a.expand(true);
	App.clickTopTab("HomeView");
};
App.Logout = function() {
	Ext.Ajax.request( {
		url : __ctxPath + "/j_logout.do",
		success : function() {
			window.location.href = __ctxPath + "/login.jsp";
		}
	});
};
Ext.onReady(App.init);
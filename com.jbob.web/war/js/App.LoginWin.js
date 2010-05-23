Ext.ns("App");
App.LoginWin = function() {
	var a = new Ext.form.FormPanel(
			{
				bodyStyle : "padding-top:6px",
				defaultType : "textfield",
				columnWidth : 0.75,
				labelAlign : "right",
				labelWidth : 55,
				labelPad : 0,
				border : false,
				layout : "form",
				defaults : {
					allowBlank : false,
					anchor : "90%,120%",
					selectOnFocus : true
				},
				items : [
						{
							name : "username",
							fieldLabel : "账      号",
							cls : "text-user",
							blankText : "账号不能为空"
						},
						{
							name : "password",
							fieldLabel : "密      码",
							blankText : "密码不能为空",
							cls : "text-lock",
							inputType : "password"
						},/*
						{
							name : "checkCode",
							fieldLabel : "验证码",
							cls : "text-code",
							blankText : "验证码不能为空"
						},
						{
							xtype : "container",
							layout : "table",
							defaultType : "textfield",
							hideLabel : false,
							layoutConfig : {
								columns : 3
							},
							items : [
									{
										width : 55,
										xtype : "label",
										text : "　　　　"
									},
									{
										width : 150,
										id : "loginCode",
										xtype : "panel",
										border : false,
										html : '<img border="0" height="30" width="150" src="' + __ctxPath + '/CaptchaImg"/>'
									},
									{
										width : 55,
										xtype : "panel",
										border : false,
										bodyStyle : "font-size:12px;padding-left:12px",
										html : '<a href="javascript:refeshCode()">看不清</a>'
									} ]
						},*/ {
							xtype : "checkbox",
							name : "_spring_security_remember_me",
							boxLabel : "让系统记住我 "
						} ]
			});
	var c = function() {
		if (a.form.isValid()) {
			a.form.submit( {
				waitTitle : "请稍候",
				waitMsg : "正在登录......",
				url : __ctxPath + "/Authentication/Login.do",
				success : function(d, e) {
					handleLoginResult(e.result);
				},
				failure : function(d, e) {
					handleLoginResult(e.result);
					d.findField("password").setRawValue("");
					d.findField("username").focus(true);
				}
			});
		}
	};
	var b = new Ext.Window(
			{
				id : "LoginWin",
				title : "用户登录",
				iconCls : "login-icon",
				border : true,
				closable : false,
				resizable : false,
				buttonAlign : "center",
				height : 230,
				width : 400,
				layout : {
					type : "vbox",
					align : "stretch"
				},
				keys : {
					key : Ext.EventObject.ENTER,
					fn : c,
					scope : this
				},
				items : [
						{
							xtype : "panel",
							border : false,
							html : '<div style="height:55px;"><img src="'
									+ __loginImage
									+ '" style="height:55px;max-width:247px;"/><!--<img src="'
									+ __ctxPath
									+ '/images/ht-login.jpg" style="height:55px;"/>--></div>',
							height : 60
						},
						{
							xtype : "panel",
							border : false,
							layout : "column",
							items : [
									a,
									{
										xtype : "panel",
										border : false,
										columnWidth : 0.25,
										html : '<img src="' + __ctxPath + '/images/login-user.jpg"/>'
									} ]
						} ],
				buttons : [ {
					text : "登录",
					iconCls : "btn-login",
					handler : c.createDelegate(this)
				}, {
					text : "重置",
					iconCls : "btn-login-reset",
					handler : function() {
						a.getForm().reset();
					}
				} ]
			});
	return b;
};
function handleLoginResult(a) {
	if (a.success) {
		Ext.getCmp("LoginWin").hide();
		var b = new Ext.ProgressBar( {
			text : "正在登录..."
		});
		b.show();
		window.location.href = __ctxPath + "/index.jsp";
	} else {
		Ext.MessageBox.show( {
			title : "操作信息",
			msg : a.msg,
			buttons : Ext.MessageBox.OK,
			icon : Ext.MessageBox.ERROR
		});
	}
}
function refeshCode() {
	var a = Ext.getCmp("loginCode");
	a.body.update('<img border="0" height="30" width="150" src="' + __ctxPath
			+ "/CaptchaImg?rand=" + Math.random() + '"/>');
}
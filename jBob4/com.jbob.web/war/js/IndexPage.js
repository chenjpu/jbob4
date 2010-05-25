var megBtn = new Ext.Button( {
	id : "messageTip",
	hidden : true,
	width : 50,
	height : 20,
	handler : function() {
		var a = Ext.getCmp("messageTip");
		var b = Ext.getCmp("win");
		if (b == null) {
			//new MessageWin();
		}
		a.hide();
	}
});
var addBtn = function(c) {
	var a = Ext.getCmp("messageTip");
	var d = Ext.getCmp("win");
	var b = Ext.getCmp("wind");
	if (c > 0 && d == null && b == null) {
		a.setText('<div style="height:25px;"><img src="'
						+ __ctxPath
						+ '/images/newpm.gif" style="height:12px;"/>你有<strong style="color: red;">'
						+ c + "</strong>信息</div>");
		//soundManager.play("msgSound");
		a.show();
	} else {
		a.hide();
	}
};
var addBtnFunction = function() {
	Ext.Ajax.request( {
		url : __ctxPath + "/info/countInMessage.do",
		method : "POST",
		success : function(b, c) {
			var a = Ext.util.JSON.decode(b.responseText);
			count = a.count;
			addBtn(count);
		},
		failure : function(a, b) {
		},
		scope : this
	});
};
var IndexPage = Ext.extend(	Ext.Viewport,
				{
					top : new Ext.Panel( {
						region : "north",
						id : "__nortPanel",
						contentEl : "app-header",
						height : 85
					}),
					center : null,
					west : new Ext.Panel( {
						region : "west",
						id : "west-panel",
						title : "导航",
						iconCls : "menu-navigation",
						split : true,
						width : 200,
						autoScroll : true,
						layout : "accordion",
						collapsible : true,
						margins : "0 0 0 2",
						items : [],
						bbar : new Ext.Toolbar( {
							width : "100%",
							height : 25,
							items : [ {
								text : "退出系统",
								iconCls : "btn-logout",
								handler : function() {
									App.Logout();
								}
							}, "->", {
								text : "在线用户",
								iconCls : "btn-onlineUser",
								handler : function() {
									//OnlineUserSelector.getView().show();
								}
							} ]
						})
					}),
					south : new Ext.Panel(
							{
								region : "south",
								height : 28,
								border : false,
								bbar : [
										megBtn,
										"->",
										{
											xtype : "tbfill"
										},
										{
											xtype : "tbtext",
											text : __companyName + "--企业信息化管理系统",
											id : "toolbarCompanyName"
										},
										{
											xtype : "tbseparator"
										},
										new Ext.Toolbar.TextItem(
												'技术支持 <a href=http://www.jbob.cn target="_blank">J.Bob Inc.</a>'),
										{
											xtype : "tbseparator"
										},
										{
											pressed : false,
											text : "与我们联系",
											handler : function() {
												Ext.ux.Toast
														.msg("联系我们",
																"电话：13316099072 <br/>网址：http://www.jbob.cn");
											}
										},
										"-",
										{
											text : "收展",
											iconCls : "btn-expand",
											handler : function() {
												var a = Ext
														.getCmp("__nortPanel");
												if (a.collapsed) {
													a.expand(true);
												} else {
													a.collapse(true);
												}
											}
										},
										"-",
										{
											xtype : "combo",
											mode : "local",
											editable : false,
											value : "切换皮肤",
											width : 100,
											triggerAction : "all",
											store : [
													[ "ext-all", "缺省浅蓝" ],
													[ "xtheme-tp", "灰色主题" ],
													[ "xtheme-default2", "灰蓝主题" ],
													[ "xtheme-default16",
															"绿色主题" ],
													[ "xtheme-access",
															"Access风格" ] ],
											listeners : {
												scope : this,
												"select" : function(d, b, c) {
													if (d.value != "") {
														var a = new Date();
														a
																.setDate(a
																		.getDate() + 300);
														setCookie("theme",
																d.value, a,
																__ctxPath);
														Ext.util.CSS
																.swapStyleSheet(
																		"theme",
																		__ctxPath
																				+ "/ext3/resources/css/"
																				+ d.value
																				+ ".css");
													}
												}
											}
										} ]
							}),
					constructor : function() {
						this.center = new Ext.TabPanel( {
							id : "centerTabPanel",
							region : "center",
							deferredRender : true,
							enableTabScroll : true,
							plugins: new Ext.ux.TabCloseMenu(),
							activeTab : 0,
							defaults : {
								autoScroll : true,
								closable : true,
								bodyStyle : "padding-bottom: 12px;"
							},
							items : []
						});
						IndexPage.superclass.constructor.call(this, {
							layout : "border",
							items : [ this.top, this.west, this.center,
									this.south ]
						});
						this.afterPropertySet();
						this.loadWestMenu();
					},
					afterPropertySet : function() {
						var b = this.center;
						/*setTimeout(function() {
							//setInterval("CalConv()", 1000);
							var c = b.add(new AppHome().initAllPortal());
							setTimeout(function() {
								b.activate(c);
							}, 2000);
							//soundManager = new SoundManager();
							//soundManager.url = __ctxPath + "/js/sound/swf/";
							//soundManager.beginDelayedInit();
							//soundManager.debugMode = false;
							//soundManager.consoleOnly = false;
							//soundManager.onload = function() {
							//	soundManager.createSound( {
							////		id : "msgSound",
							//		url : __ctxPath + "/js/sound/mp3/msg.mp3"
							//	});
							//	addBtnFunction();
							//};
						}, 100);*/
						//Ext.getCmp("SearchForm").render("searchFormDisplay");
						var a = new Ext.TabPanel(
								{
									id : "appNavTabPanel",
									deferredRender : true,
									enableTabScroll : false,
									frame : false,
									border : false,
									plain : true,
									height : 0,
									renderTo : "navHeader",
									tabMargin : 20,
									defaults : {
										autoScroll : false,
										closable : false,
										bodyStyle : "padding-bottom: 12px;"
									},
									listeners : {
										scope : this,
										"tabchange" : function(d, c) {
											var e = c.iconCls;
											if (e == "menu-desktop") {
												App.MyDesktopClick();
											} else {
												if (e == "menu-mail_box") {
													App.clickTopTab("PersonalMailBoxView");
												} else {
													if (e == "menu-task") {
														App.clickTopTab("CalendarPlanView");
													} else {
														if (e == "menu-workPlan") {
															App.clickTopTab("WorkPlanView");
														} else {
															if (e == "menu-document") {
																App.clickTopTab("PersonalDocumentView");
															}
														}
													}
												}
											}
										}
									},
									items : [ {
										title : "我的桌面",
										iconCls : "menu-desktop"
									}, {
										title : " 邮  件 ",
										iconCls : "menu-mail_box"
									}, {
										title : " 任  务 ",
										iconCls : "menu-task"
									}, {
										title : " 计  划 ",
										iconCls : "menu-workPlan"
									}, {
										title : " 文  档 ",
										iconCls : "menu-document"
									} ]
								});
					},
					loadWestMenu : function() {
						var westPanel = Ext.getCmp("west-panel");
						Ext.Ajax.request( {
									url : __ctxPath + "/Menu/Left.do",
									success : function(response, options) {
										var arr = eval(response.responseText);
										var __activedPanelId = getCookie("__activedPanelId");
										for ( var i = 0; i < arr.length; i++) {
											var doc = strToDom(arr[i].subXml);
											var root = doc.documentElement
													|| doc;
											var panel = new Ext.tree.TreePanel(
													{
														id : arr[i].id,
														title : arr[i].text,
														iconCls : arr[i].iconCls,
														animate : true,
														border : false,
														autoScroll : true,
														loader : new htsoft.ux.TreeXmlLoader(
																{
																	preloadChildren : true
																}),
														root : new Ext.tree.AsyncTreeNode(
																{
																	text : root.tagName,
																	xmlNode : root
																}),
														listeners : {
															"click" : App.clickNode
														},
														rootVisible : false
													});
											westPanel.add(panel);
											panel.on("expand", function(p) {
												var expires = new Date();
												expires.setDate(expires
														.getDate() + 30);
												setCookie("__activedPanelId",
														p.id, expires,
														__ctxPath);
											});
											if (arr[i].id == __activedPanelId) {
												westPanel.layout.activeItem = panel;
											}
										}
										westPanel.doLayout();
									}
								});
					}
				});
var AppHome = function() {
	var l = new Ext.grid.ColumnModel( {
		columns : [
				{
					header : "noticeId",
					dataIndex : "noticeId",
					hidden : true
				},
				{
					header : "公告标题",
					dataIndex : "noticeTitle",
					width : 160,
					renderer : function(o) {
						return '<img src="' + __ctxPath
								+ '/images/menus/info/notice_menu.png"/>' + o;
					}
				}, {
					header : "生效日期",
					dataIndex : "effectiveDate",
					width : 100,
					renderer : function(o) {
						return o.substring(0, 10);
					}
				} ],
		defaults : {
			sortable : true,
			menuDisabled : false
		}
	});
	var f = new Ext.data.Store( {
		proxy : new Ext.data.HttpProxy( {
			url : __ctxPath + "/info/listNotice.do"
		}),
		baseParams : {
			"Q_state_SN_EQ" : 1
		},
		reader : new Ext.data.JsonReader( {
			root : "result",
			totalProperty : "totalCounts",
			id : "id",
			fields : [ {
				name : "noticeId",
				type : "int"
			}, "noticeTitle", "effectiveDate" ]
		}),
		remoteSort : true
	});
	f.setDefaultSort("noticeId", "desc");
	var j = new Ext.grid.ColumnModel(
			{
				columns : [
						{
							header : "newsId",
							dataIndex : "newsId",
							hidden : true
						},
						{
							header : "新闻标题",
							width : 160,
							dataIndex : "subject",
							renderer : function(r, p, o) {
								var q = o.data.subjectIcon;
								var s = null;
								if (q != "") {
									s = '<img style="border:0;" width="16" height="16" src="'
											+ __ctxPath
											+ "/attachFiles/"
											+ q
											+ '" border="0"/>';
								} else {
									s = '<img style="border:0;" width="16" height="16" src="' + __ctxPath + '/images/default_newsIcon.jpg" border="0"/>';
								}
								return s + r;
							}
						}, {
							header : "创建时间",
							width : 100,
							dataIndex : "createtime",
							renderer : function(o) {
								return o.substring(0, 10);
							}
						} ],
				defaults : {
					sortable : true,
					menuDisabled : false
				}
			});
	var n = new Ext.data.Store( {
		proxy : new Ext.data.HttpProxy( {
			url : __ctxPath + "/info/listNews.do"
		}),
		reader : new Ext.data.JsonReader( {
			root : "result",
			totalProperty : "totalCounts",
			id : "id",
			fields : [ {
				name : "newsId",
				type : "int"
			}, "typeId", "subjectIcon", "subject", "createtime" ]
		}),
		remoteSort : true
	});
	n.setDefaultSort("newsId", "desc");
	var e = new Ext.grid.ColumnModel(
			{
				columns : [
						{
							header : "内容",
							dataIndex : "content",
							width : 150,
							renderer : function(q, p, o) {
								var r = "";
								if (o.data.readFlag == "1") {
									r += '<img src="' + __ctxPath + '/images/btn/info/email_open.png" title="已读"/>';
								} else {
									r += '<img src="' + __ctxPath + '/images/btn/info/email.png" title="未读"/>';
								}
								return r + q;
							}
						}, {
							header : "发送时间",
							dataIndex : "sendTime",
							width : 100,
							renderer : function(o) {
								return o.substring(0, 10);
							}
						} ],
				defaults : {
					sortable : true,
					menuDisabled : true
				}
			});
	var b = new Ext.data.Store( {
		proxy : new Ext.data.HttpProxy( {
			url : __ctxPath + "/info/listShortMessage.do"
		}),
		reader : new Ext.data.JsonReader( {
			root : "result",
			totalProperty : "totalCounts",
			id : "id",
			fields : [ {
				name : "receiveId",
				type : "int"
			}, {
				name : "content",
				mapping : "shortMessage.content"
			}, {
				name : "sendTime",
				mapping : "shortMessage.sendTime"
			}, {
				name : "readFlag"
			} ]
		}),
		remoteSort : true
	});
	b.setDefaultSort("id", "desc");
	var h = new Ext.grid.ColumnModel(
			{
				columns : [
						{
							header : "planId",
							dataIndex : "planId",
							hidden : true
						},
						{
							width : 150,
							header : "内容",
							dataIndex : "content",
							renderer : function(r, q, p) {
								var o = p.data.status;
								if (o == 1) {
									return '<img src="'
											+ __ctxPath
											+ '/images/flag/task/finish.png" title="完成"/>'
											+ '<font style="text-decoration:line-through;color:red;">'
											+ r + "</font>";
								} else {
									return '<img src="'
											+ __ctxPath
											+ '/images/flag/task/go.png" title="未完成"/>'
											+ r;
								}
							}
						}, {
							header : "结束时间",
							width : 100,
							dataIndex : "endTime",
							renderer : function(o) {
								return o.substring(0, 10);
							}
						} ],
				defaults : {
					sortable : true,
					menuDisabled : false,
					width : 100
				}
			});
	var k = new Ext.data.Store( {
		proxy : new Ext.data.HttpProxy( {
			url : __ctxPath + "/task/listCalendarPlan.do"
		}),
		reader : new Ext.data.JsonReader( {
			root : "result",
			totalProperty : "totalCounts",
			id : "id",
			fields : [ {
				name : "planId",
				type : "int"
			}, "endTime", "content", "status" ]
		}),
		remoteSort : true
	});
	k.setDefaultSort("planId", "desc");
	var m = new Ext.grid.ColumnModel( {
		columns : [
				{
					header : "appointId",
					dataIndex : "appointId",
					hidden : true
				},
				{
					header : "主题",
					dataIndex : "subject",
					renderer : function(o) {
						return '<img src="' + __ctxPath
								+ '/images/flag/task/appointment.png"/>' + o;
					}
				}, {
					header : "开始时间",
					dataIndex : "startTime",
					renderer : function(o) {
						return o.substring(0, 10);
					}
				} ],
		defaults : {
			sortable : true,
			menuDisabled : false,
			width : 100
		}
	});
	var a = new Ext.data.Store( {
		proxy : new Ext.data.HttpProxy( {
			url : __ctxPath + "/task/listAppointment.do"
		}),
		reader : new Ext.data.JsonReader( {
			root : "result",
			totalProperty : "totalCounts",
			id : "id",
			fields : [ {
				name : "appointId",
				type : "int"
			}, "subject", "startTime" ]
		}),
		remoteSort : true
	});
	a.setDefaultSort("appointId", "desc");
	var d = new Ext.grid.ColumnModel( {
		columns : [
				{
					header : "userId",
					dataIndex : "userId",
					width : 20,
					hidden : true,
					sortable : true
				},
				{
					header : "事项名称",
					dataIndex : "taskName",
					width : 120,
					renderer : function(o) {
						return '<img src="' + __ctxPath
								+ '/images/menus/flow/task.png"/>' + o;
					}
				}, {
					header : "到期时间",
					dataIndex : "dueDate",
					width : 100,
					renderer : function(o) {
						if (o == "") {
							return "无限制";
						} else {
							return o.substring(0, 10);
						}
					}
				} ],
		defaults : {
			sortable : true,
			menuDisabled : true,
			width : 100
		}
	});
	var i = new Ext.data.Store( {
		proxy : new Ext.data.HttpProxy( {
			url : __ctxPath + "/flow/listTask.do"
		}),
		reader : new Ext.data.JsonReader( {
			root : "result",
			totalProperty : "totalCounts",
			fields : [ "taskId", "taskName", "executionId", "activityName",
					"dueDate" ]
		}),
		remoteSort : true
	});
	i.setDefaultSort("dbId", "desc");
	var g = [ {
		id : "close",
		handler : function(q, p, o) {
			o.ownerCt.remove(o, true);
		}
	} ];
	var c = function(s, r, t) {
		var o = s;
		var p = t;
		p.load( {
			params : {
				start : 0,
				limit : 8
			}
		});
		var q = new Ext.grid.GridPanel( {
			id : r,
			store : t,
			trackMouseOver : true,
			disableSelection : false,
			loadMask : true,
			border : false,
			cm : o,
			viewConfig : {
				forceFit : true,
				enableRowBody : false,
				showPreview : false
			},
			bbar : new Ext.PagingToolbar( {
				pageSize : 8,
				store : p
			})
		});
		return q;
	};
	return {
		initAllPortal : function() {
			var u = new c(l, "appHomeNoticeGrid", f);
			var t = new c(j, "appHomeNewsGrid", n);
			var s = new c(e, "appHomeMessageGrid", b);
			var r = new c(h, "appHomePlanGrid", k);
			var q = new c(m, "appHomeAppointmentGrid", a);
			var p = new c(d, "appHomeTaskGrid", i);
			u.addListener("rowdblclick", function(w, v, x) {
				w.getSelectionModel().each(
						function(y) {
							App.clickTopTab("NoticeDetail", y.data.noticeId,
									function() {
										AppUtil.removeTab("NoticeDetail");
									});
						});
			});
			t.addListener("rowdblclick", function(w, v, x) {
				w.getSelectionModel().each(function(y) {
					App.clickTopTab("NewsDetail", y.data.newsId, function() {
						AppUtil.removeTab("NewsDetail");
					});
				});
			});
			r
					.addListener(
							"rowdblclick",
							function(w, v, x) {
								w
										.getSelectionModel()
										.each(
												function(y) {
													App
															.clickTopTab(
																	"CalendarPlanDetail",
																	y.data.planId,
																	function() {
																		AppUtil
																				.removeTab("CalendarPlanDetail");
																	});
												});
							});
			q.addListener("rowdblclick", function(w, v, x) {
				w.getSelectionModel().each(
						function(y) {
							App.clickTopTab("AppointmentDetail",
									y.data.appointId, function() {
										AppUtil.removeTab("AppointmentDetail");
									});
						});
			});
			p.addListener("rowdblclick", function(w, v, x) {
				w.getSelectionModel().each(function(B) {
					var z = B.data.taskId;
					var C = B.data.activityName;
					var A = App.getContentPanel();
					var y = A.getItem("ProcessNextForm" + z);
					if (y == null) {
						y = new ProcessNextForm( {
							taskId : z,
							activityName : C
						});
						A.add(y);
					}
					A.activate(y);
				});
			});
			s.addListener("rowdblclick", function(w, v, x) {
				w.getSelectionModel().each(function(z) {
					var y = Ext.getCmp("HomeMessageWindow");
					if (y != null) {
						y.close();
						new MessageDetail(z.data.receiveId);
					} else {
						new MessageDetail(z.data.receiveId);
					}
				});
			});
			var o = {
				title : "首       页",
				id : "HomeView",
				iconCls : "menu-company",
				style : "padding:4px 4px 4px 4px;",
				closable : false,
				xtype : "portal",
				region : "center",
				margins : "5 5 5 0",
				items : [ {
					columnWidth : 0.33,
					style : "padding:0 10 10px 0",
					defaults : {
						layout : "fit",
						height : 300,
						autoScroll : true,
						tools : g
					},
					items : [ {
						title : "最新公告",
						iconCls : "menu-notice",
						items : [ u ]
					}, {
						title : "日程管理",
						iconCls : "menu-cal-plan-view",
						items : [ r ]
					} ]
				}, {
					columnWidth : 0.33,
					style : "padding:0 10 10px 0px",
					defaults : {
						layout : "fit",
						height : 300,
						autoScroll : true,
						tools : g
					},
					items : [ {
						title : "新闻中心",
						iconCls : "menu-news",
						items : [ t ]
					}, {
						title : "我的约会",
						iconCls : "menu-appointment",
						items : [ q ]
					} ]
				}, {
					columnWidth : 0.33,
					style : "padding:0 0px 10px 0px",
					defaults : {
						layout : "fit",
						height : 300,
						autoScroll : true,
						tools : g
					},
					items : [ {
						title : "个人短信",
						iconCls : "menu-message",
						items : [ s ]
					}, {
						title : "待办事项",
						iconCls : "menu-flowWait",
						items : [ p ]
					} ]
				} ]
			};
			return o;
		}
	};
};
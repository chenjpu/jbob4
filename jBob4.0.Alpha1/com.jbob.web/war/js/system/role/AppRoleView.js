Ext.ns("AppRoleView");
var AppRoleView = function() {
	return new Ext.Panel(
			{
				id : "AppRoleView",
				title : "角色列表",
				iconCls : "menu-role",
				autoScroll : true,
				items : [
						new Ext.FormPanel(
								{
									height : 35,
									frame : true,
									id : "AppRoleSearchForm",
									layout : "column",
									defaults : {
										xtype : "label"
									},
									items : [
											{
												text : "角色名称"
											},
											{
												xtype : "textfield",
												name : "Q_roleName_S_LK"
											},
											{
												text : "角色描述"
											},
											{
												xtype : "textfield",
												name : "Q_roleDesc_S_LK"
											},
											{
												xtype : "button",
												text : "查询",
												iconCls : "search",
												handler : function() {
													var a = Ext.getCmp("AppRoleSearchForm");
													var b = Ext.getCmp("AppRoleGrid");
													if (a.getForm().isValid()) {
														b.getStore().load( {
															params : Ext.apply({
															start : 0,
															limit : 4
															},a.getForm().getFieldValues())
														});
														/*a.getForm().submit(
																		{
																			waitMsg : "正在提交查询",
																			url : __ctxPath
																					+ "/Role/List.do",
																			success : function(
																					d,
																					e) {
																				var c = Ext.util.JSON.decode(e.response.responseText);
																				b.getStore().loadData(c);
																			}
																		});*/
													}
												}
											} ]
								}), this.setup() ]
			});
};
AppRoleView.prototype.setup = function() {
	return this.grid();
};
AppRoleView.prototype.grid = function() {
	var d = new Ext.grid.CheckboxSelectionModel();
	var a = new Ext.grid.ColumnModel(
			{
				columns : [
						d,
						new Ext.grid.RowNumberer(),
						/*
						{
							header : "roleId",
							dataIndex : "id",
							hidden : true,
							sortable:false,
							menuDisabled:true
						},*/
						{
							header : "状态",
							dataIndex : "status",
							width : 30,
							hideable: false,
						    menuDisabled:true,
							renderer : function(e) {
								var f = "";
								if (e == "1") {
									f += '<img title="激活" src="' + __ctxPath + '/images/flag/customer/effective.png"/>';
								} else {
									f += '<img title="禁用" src="' + __ctxPath + '/images/flag/customer/invalid.png"/>';
								}
								return f;
							}
						},
						{
							header : "角色名称",
							dataIndex : "name",
							hideable: false,
						    menuDisabled:true,
							width : 200
						},
						{
							header : "角色描述",
							dataIndex : "description",
							width : 400
						},
						{
							header : "管理",
							dataIndex : "id",
							width : 50,
							renderer : function(l, k, g, i, m) {
								var e = g.data.roleId;
								var f = g.data.roleName;
								var j = g.data.isDefaultIn;
								var h = "";
								if (e != -1) {
									if (j == "0") {
										if (isGranted("_AppRoleDel")) {
											h = '<button title="删除" value=" " class="btn-del" onclick="AppRoleView.remove(' + e + ')"></button>';
										}
										if (isGranted("_AppRoleEdit")) {
											h += '&nbsp;<button title="编辑" value=" " class="btn-edit" onclick="AppRoleView.edit(' + e + ')"></button>';
										}
										if (isGranted("_AppRoleGrant")) {
											h += '&nbsp;<button title="授权" value=" " class="btn-grant" onclick="AppRoleView.grant('
													+ e
													+ ",'"
													+ f
													+ "')\">&nbsp;</button>";
										}
									} else {
										h = '<button title="复制" value=" " class="btn-copyrole" onclick="AppRoleView.copy(' + e + ')"></button>';
									}
								}
								return h;
							}
						} ],
				defaults : {
					sortable : true,
					menuDisabled : false,
					width : 100
				}
			});
	var b = this.store();
	b.load( {
		params : {
			start : 0,
			limit : 4
		}
	});
	var c = new Ext.grid.GridPanel( {
		id : "AppRoleGrid",
		tbar : this.topbar(),
		store : b,
		trackMouseOver : true,
		disableSelection : false,
		loadMask : true,
		autoHeight : true,
		cm : a,
		sm : d,
		viewConfig : {
			forceFit : true,
			enableRowBody : false,
			showPreview : false
		},
		bbar : new Ext.PagingToolbar( {
			pageSize : 4,
			store : b,
			displayInfo : true,
			displayMsg : "当前显示从{0}至{1}， 共{2}条记录",
			emptyMsg : "当前没有记录"
		})
	});
	c.addListener("rowdblclick", function(g, f, h) {
		g.getSelectionModel().each(function(e) {
			if (e.data.isDefaultIn == "0" && e.data.id != -1) {
				AppRoleView.edit(e.data.id);
			}
		});
	});
	return c;
};
AppRoleView.prototype.store = function() {
	var a = new Ext.data.Store( {
		proxy : new Ext.data.HttpProxy( {
			url : __ctxPath + "/Role/List.do"
		}),
		reader : new Ext.data.JsonReader( {
			root : "result",
			totalProperty : "totalCounts",
			id : "id",
			fields : [ {
				name : "id",
				type : "int"
			}, "name", "description", {
				name : "status",
				type : "int"
			}, "isDefaultIn" ]
		}),
		remoteSort : true
	});
	a.setDefaultSort("id", "desc");
	return a;
};
AppRoleView.prototype.topbar = function() {
	var a = new Ext.Toolbar( {
		id : "AppRoleFootBar",
		height : 30,
		bodyStyle : "text-align:left",
		items : []
	});
	if (isGranted("_AppRoleAdd")) {
		a.add(new Ext.Button( {
			iconCls : "btn-add",
			text : "添加角色",
			handler : function() {
				new AppRoleForm();
			}
		}));
	}
	if (isGranted("_AppRoleDel")) {
		a.add(new Ext.Button(
				{
					iconCls : "btn-del",
					text : "删除角色",
					handler : function() {
						var d = Ext.getCmp("AppRoleGrid");
						var b = d.getSelectionModel().getSelections();
						if (b.length == 0) {
							Ext.ux.Toast.msg("信息", "请选择要删除的记录！");
							return;
						}
						var e = Array();
						var f = "";
						for ( var c = 0; c < b.length; c++) {
							if (b[c].data.isDefaultIn == "0"
									&& b[c].data.id != -1) {
								e.push(b[c].data.id);
							} else {
								f += b[c].data.name + ",";
							}
						}
						if (f == "") {
							AppRoleView.remove(e);
						} else {
							Ext.ux.Toast.msg("信息", f + "不能被删除！");
						}
					}
				}));
	}
	return a;
};
AppRoleView.remove = function(b) {
	var a = Ext.getCmp("AppRoleGrid");
	Ext.Msg.confirm("信息确认", "您确认要删除该记录吗？", function(c) {
		if (c == "yes") {
			Ext.Ajax.request( {
				url : __ctxPath + "/Role/Del.do",
				params : {
					ids : b
				},
				method : "post",
				success : function() {
					Ext.ux.Toast.msg("信息", "成功删除所选记录！");
					a.getStore().reload( {
						params : {
							start : 0,
							limit : 25
						}
					});
				}
			});
		}
	});
};
AppRoleView.edit = function(a) {
	new AppRoleForm(a, 0);
};
AppRoleView.grant = function(b, a) {
	new RoleGrantRightView(b, a);
};
AppRoleView.copy = function(a) {
	new AppRoleForm(a, 1);
};
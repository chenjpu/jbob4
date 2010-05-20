Ext.ns("AppRolePanel");

//角色管理的主界面
AppRolePanel = function() {
	AppRolePanel.superclass.constructor.call(this, {
		id : "AppRolePanel",
		title : "角色设置",
		iconCls : "menu-role",
		autoScroll : true
	});
};

Ext.extend(AppRolePanel, Ext.Panel,{
	initComponent : function(){
    	Ext.apply(this, {
	       tbar:this.createTbar(),
	       items:[this.createQueryForm(),this.createGrid()]
    	});
    	AppRolePanel.superclass.initComponent.call(this);
	},
	//创建查询表单
	createQueryForm : function() {
		return new Ext.FormPanel({
					height : 35,
					frame : true,
					id : "AppRoleSearchForm",
					layout : "column",
					defaults : {
						xtype : "label"
					},
					items : [{
								text : "角色名称"
							},
							{
								xtype : "textfield",
								name : "Q_name_S_LK"
							},
							{
								text : "角色描述"
							},
							{
								xtype : "textfield",
								name : "Q_desc_S_LK"
							},
							{
								xtype : "button",
								text : "查询",
								iconCls : "search",
								handler : function() {
									var searchForm = Ext.getCmp("AppRoleSearchForm").getForm();
									var grid = Ext.getCmp("AppRoleGrid");
									if (searchForm.isValid()) {
										grid.load( {
											params : {
											start : 0,
											limit : 4
										}
									});
										
										/*searchForm.submit(
												{
													waitMsg : "正在提交查询",
													url : __ctxPath	+ "/Role/List.do",
													success : function(d,e) {
														grid.getStore().loadData(Ext.util.JSON.decode(e.response.responseText));
													}
												});*/
									}
								}
							} ]
				});
		
	},
	//创建表格
	createGrid : function() {
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
								menuDisabled:false
							},*/
							{
								header : "状态",
								dataIndex : "status",
								width : 30,
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
									var e = g.data.id;
									var f = g.data.name;
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
		var b = this.createStore();
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
	},
	
	createTbar : function() {
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
	},
	
	createStore :function() {
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
	}
});

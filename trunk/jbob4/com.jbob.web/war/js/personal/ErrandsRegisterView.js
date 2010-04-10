Ext.ns('ErrandsRegisterView');
/**
 * [ErrandsRegister]列表
 */
var ErrandsRegisterView = function() {
	return new Ext.Panel({
		id : 'ErrandsRegisterView',
		title : '请假单列表',
		iconCls:'menu-holiday',
		autoScroll : true,
		items : [new Ext.FormPanel({
			height : 35,
			frame : true,
			id : 'ErrandsRegisterSearchForm',
			layout : 'column',
			defaults : {
				xtype : 'label'
			},
			items : [{
						text : '查询条件:'
					},{
					    xtype:'hidden',
					    name:'Q_flag_SN_EQ',
					    value:1
					}, {
						text : '开始时间:从'
					}, {
						xtype : 'datetimefield',
						format:'Y-m-d H:i:s',
						name : 'Q_startTime_D_GE',
						width:200,
						readOnly:true
					}, {
						text : '到'
					}, {
						xtype : 'datetimefield',
						format:'Y-m-d H:i:s',
						name : 'Q_endTime_D_LE',
						width:200,
						readOnly:true
					}, {
						text : '审批状态'
					 }, {
						xtype : 'combo',
						hiddenName : 'Q_status_SN_EQ',
						mode : 'local',
						width:80,
						editable : false,
						readOnly : true,
						triggerAction : 'all',
						store : [['0','未审批'],['1','通过审批'],['2','未通过审批']]
					}, {
						xtype : 'button',
						text : '查询',
						iconCls : 'search',
						handler : function() {
							var searchPanel = Ext
									.getCmp('ErrandsRegisterSearchForm');
							var grid = Ext.getCmp('ErrandsRegisterGrid');
							if (searchPanel.getForm().isValid()) {
								searchPanel.getForm().submit({
									waitMsg : '正在提交查询',
									url : __ctxPath
											+ '/personal/listErrandsRegister.do',
									success : function(formPanel, action) {
										var result = Ext.util.JSON
												.decode(action.response.responseText);
										grid.getStore().loadData(result);
									}
								});
							}

						}
					},{
					  xtype:'button',
					  text:'重置',
					  iconCls:'btn-reseted',
					  handler:function(){
					    var searchPanel = Ext
									.getCmp('ErrandsRegisterSearchForm');
						searchPanel.getForm().reset();
					  }
					}]
		}), this.setup()]
	});
};
/**
 * 建立视图
 */
ErrandsRegisterView.prototype.setup = function() {
	return this.grid();
};
/**
 * 建立DataGrid
 */
ErrandsRegisterView.prototype.grid = function() {
	var sm = new Ext.grid.CheckboxSelectionModel();
	var cm = new Ext.grid.ColumnModel({
		columns : [sm, new Ext.grid.RowNumberer(), {
					header : 'dateId',
					dataIndex : 'dateId',
					hidden : true
				}, {
					header : '描述',
					dataIndex : 'descp'
				}, {
					header : '开始日期',
					dataIndex : 'startTime'
				}, {
					header : '结束日期',
					dataIndex : 'endTime'
				}, {
					header : '审批状态',
					dataIndex : 'status',
					renderer:function(value){
						if(value=='0'){
						  return '未审批';
						}
						if(value=='1'){
						  return '<font color="green">通过审批</font>';
						}
						if(value=='2'){
							return '<font color="red">未通过审批</font>';
						}
					}
				}, {
					header : '审批意见',
					dataIndex : 'approvalOption'
				}, {
					header : '审批人',
					dataIndex : 'approvalName'
				}, {
					header : '管理',
					dataIndex : 'dateId',
					width : 50,
					sortable : false,
					renderer : function(value, metadata, record, rowIndex,
							colIndex) {
						var editId = record.data.dateId;
						var str = '<button title="删除" value=" " class="btn-del" onclick="ErrandsRegisterView.remove('
								+ editId + ')">&nbsp;&nbsp;</button>';
						str += '&nbsp;<button title="详细" value=" " class="btn-showDetail" onclick="ErrandsRegisterView.detail('
								+ editId + ')">&nbsp;&nbsp;</button>';
						
						return str;
					}
				}],
		defaults : {
			sortable : true,
			menuDisabled : false,
			width : 100
		}
	});

	var store = this.store();
	store.load({
				params : {
					start : 0,
					limit : 25
				}
			});
	var grid = new Ext.grid.GridPanel({
				id : 'ErrandsRegisterGrid',
				tbar : this.topbar(),
				store : store,
				trackMouseOver : true,
				disableSelection : false,
				loadMask : true,
				autoHeight : true,
				cm : cm,
				sm : sm,
				viewConfig : {
					forceFit : true,
					enableRowBody : false,
					showPreview : false
				},
				bbar : new Ext.PagingToolbar({
							pageSize : 25,
							store : store,
							displayInfo : true,
							displayMsg : '当前显示从{0}至{1}， 共{2}条记录',
							emptyMsg : "当前没有记录"
						})
			});
		grid.addListener('rowdblclick', function(grid, rowindex, e) {
				grid.getSelectionModel().each(function(rec) {
							ErrandsRegisterView.detail(rec.data.dateId);
				});
		});
	return grid;

};

/**
 * 初始化数据
 */
ErrandsRegisterView.prototype.store = function() {
	var store = new Ext.data.Store({
				proxy : new Ext.data.HttpProxy({
							url : __ctxPath
									+ '/personal/listErrandsRegister.do'
						}),
				baseParams:{'Q_flag_SN_EQ':1},
				reader : new Ext.data.JsonReader({
							root : 'result',
							totalProperty : 'totalCounts',
							id : 'id',
							fields : [{
										name : 'dateId',
										type : 'int'
									}

									, {
										name : 'userName',
										mapping : 'appUser.fullname'
									}, 'descp', 'startTime', 'endTime',
									'approvalId', 'status', 'approvalOption',
									'approvalName', 'flag']
						}),
				remoteSort : true
			});
	store.setDefaultSort('dateId', 'desc');
	return store;
};

/**
 * 建立操作的Toolbar
 */
ErrandsRegisterView.prototype.topbar = function() {
	var toolbar = new Ext.Toolbar({
				id : 'ErrandsRegisterFootBar',
				height : 30,
				bodyStyle : 'text-align:left',
				items : [{
							iconCls : 'btn-add',
							text : '添加请假单',
							xtype : 'button',
							handler : function() {
								new ErrandsRegisterForm();
							}
						}, {
							iconCls : 'btn-del',
							text : '删除请假单',
							xtype : 'button',
							handler : function() {

								var grid = Ext.getCmp("ErrandsRegisterGrid");
								var selectRecords = grid.getSelectionModel().getSelections();
								if (selectRecords.length == 0) {
									Ext.ux.Toast.msg("信息", "请选择要删除的记录！");
									return;
								}
								var ids = Array();
								for (var i = 0; i < selectRecords.length; i++) {
									ids.push(selectRecords[i].data.dateId);
								}

								ErrandsRegisterView.remove(ids);
							}
						}]
			});
	return toolbar;
};

/**
 * 删除单个记录
 */
ErrandsRegisterView.remove = function(id) {
	var grid = Ext.getCmp("ErrandsRegisterGrid");
	Ext.Msg.confirm('信息确认', '您确认要删除该记录吗？', function(btn) {
				if (btn == 'yes') {
					Ext.Ajax.request({
								url : __ctxPath
										+ '/personal/multiDelErrandsRegister.do',
								params : {
									ids : id
								},
								method : 'post',
								success : function() {
									Ext.ux.Toast.msg("信息提示", "成功删除所选记录！");
									grid.getStore().reload({
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

ErrandsRegisterView.detail=function(id){
	new ErrandsRegisterDetail(id);
};
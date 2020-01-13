layui.use([ 'form','layer','jquery','table','laydate'], function() {
	var layer = layui.layer, $ = layui.jquery, form = layui.form,table=layui.table,laydate = layui.laydate;
	var nowTime = new Date().valueOf();
	var max = null;
	active = {
			search : function(){
				var status = $('#status option:selected');
				var createTimeStart = $('#createTimeStart');
				var createTimeEnd = $('#createTimeEnd');
				
				table.reload('userList',{
					page : {
						curr : 1
					},
					where : {
						status : status.val(),
						createTimeStart : createTimeStart.val(),
						createTimeEnd : createTimeEnd.val()
					}
				});
			}
	};
	
	var createTimeS = laydate.render({
		elem : '#createTimeStart',
		type : 'datetime',
		max : nowTime,
		done : function(value, date) {
			endMax = createTimeE.config.max;
			createTimeE.config.min = date;
			createTimeE.config.min.month = date.month - 1;
		}
	});
	
	var createTimeE = laydate.render({
		elem : '#createTimeEnd',
		type : 'datetime',
		max : nowTime,
		done : function(value, date) {
			if ($.trim(value) == '') {
				var curDate = new Date();
				date = {
					'date' : curDate.getDate(),
					'month' : curDate.getMonth() + 1,
					'year' : curDate.getFullYear()
				};
			}
			createTimeE.config.max = date;
			createTimeE.config.max.month = date.month - 1;
		}
	});

	table.render({
		id:'repairList'
	    ,elem: '#repairList'
	    ,url: ctx+'/repair/getAllRepairList'// 数据接口
	    ,limit:10// 每页默认数
	    ,limits:[10,20,30,40]
	    ,cols: [[ // 表头
	      {field:'repairId', title: '报修单号', align: 'center',width:110}
          ,{field:'createPerId', title: '创建人' , align: 'center',width:110}
          ,{field:'repairManId', title: '修理人' , align: 'center',width:110}
          ,{field:'repairStatus', title: '报修单状态', align: 'center' ,width:110}
          ,{field:'roomNum', title: '宿舍号' , align: 'center',width:80}
          ,{field:'createTime', title: '创建时间', templet : '<div>{{ formatTime(d.createTime,"yyyy-MM-dd hh:mm:ss")}}</div>',width:160, align: 'center'}
          ,{field:'reviewName', title: '审核人姓名' , align: 'center',width:110}
          ,{field:'description', title: '描述', align: 'center' }
	    ]]
			,page: true // 开启分页
			,loading:true
			,where: {timestamp: (new Date()).valueOf()}
	  });
	table.render({
		id:'waitRepairList'
		,elem: '#waitRepairList'
		,url: ctx+'/repair/getWaitRepairList'// 数据接口
		,limit:10// 每页默认数
		,limits:[10,20,30,40]
		,cols: [[ // 表头
			{field:'repairId', title: '报修单号', align: 'center',width:110}
			,{field:'createPerId', title: '创建人' , align: 'center',width:110}
			,{field:'repairManId', title: '修理人' , align: 'center',width:110}
			,{field:'repairStatus', title: '报修单状态', align: 'center' ,width:110}
			,{field:'roomNum', title: '宿舍号' , align: 'center',width:80}
			,{field:'reviewName', title: '审核人姓名' , align: 'center',width:110}
			,{field:'createTime', title: '创建时间', templet : '<div>{{ formatTime(d.createTime,"yyyy-MM-dd hh:mm:ss")}}</div>',width:160, align: 'center'}
			,{field:'description', title: '描述', align: 'center' }
			, {field: 'right', title: '操作', align: 'center', toolbar: "#barDemo",width:150}
		]]
		,page: true // 开启分页
		,loading:true
		,where: {timestamp: (new Date()).valueOf()}
	});
	table.render({
		id:'waitRepairListTwo'
		,elem: '#waitRepairListTwo'
		,url: ctx+'/repair/getWaitRepairListTwo'// 数据接口
		,limit:10// 每页默认数
		,limits:[10,20,30,40]
		,cols: [[ // 表头
			{field:'repairId', title: '报修单号', align: 'center',width:110}
			,{field:'createPerId', title: '创建人' , align: 'center',width:110}
			,{field:'repairManId', title: '修理人' , align: 'center',width:110}
			,{field:'repairStatus', title: '报修单状态', align: 'center' ,width:110}
			,{field:'roomNum', title: '宿舍号' , align: 'center',width:80}
			,{field:'reviewName', title: '审核人姓名' , align: 'center',width:110}
			,{field:'createTime', title: '创建时间', templet : '<div>{{ formatTime(d.createTime,"yyyy-MM-dd hh:mm:ss")}}</div>',width:160, align: 'center'}
			,{field:'description', title: '描述', align: 'center' }
			, {field: 'right', title: '操作', align: 'center', toolbar: "#barDemo",width:150}
		]]
		,page: true // 开启分页
		,loading:true
		,where: {timestamp: (new Date()).valueOf()}
	});

																																																																																																								
	table.on('tool(waitRepairList)', function (obj) {
	    var data = obj.data;
	    if (obj.event === 'review') {
			layer.confirm('确定要审核报修单号为 '+data.repairId+' 么？', function (index) {
				$.ajax({
					url : ctx + '/repair/reviewByTea',
					type : "POST",
					data: {"repairId": data.repairId},
					success : function(d) {
						if (d.code == 0) {
							layer.msg("审核成功！",{icon: 1});
							location.reload();
						} else {
							layer.msg("权限不足，删除失败！", {
								icon : 5
							});
						}
					},
					error:function(){
						layer.msg("删除失败！网络错误！",{icon: 5});
					}
				})
				layer.close(index);
			});
	    }	
	});

	table.on('tool(waitRepairListTwo)', function (obj) {
		var data = obj.data;
		if (obj.event === 'reviewTwo') {
			layer.confirm('确定要审核报修单号为 '+data.repairId+' 么？', function (index) {
				$.ajax({
					url : ctx + '/repair/reviewByDean',
					type : "POST",
					data: {"repairId": data.repairId},
					success : function(d) {
						if (d.code == 0) {
							layer.msg("审核成功！",{icon: 1});
							location.reload();
						} else {
							layer.msg("权限不足，删除失败！", {
								icon : 5
							});
						}
					},
					error:function(){
						layer.msg("删除失败！网络错误！",{icon: 5});
					}
				})
				layer.close(index);
			});
		}
	});

	$(".search_btn").click(function() {
		var type = $(this).data('type');
		active[type] ? active[type].call(this) : '';
	})
	
	$(".userAdd_btn").click(function() {
		var addIndex = layer.open({
			title : "添加报修单",
			type : 2,
			area : [ '800px', '550px' ],
			content : ctx + "/repair/addRepair",
			success : function(layero, index) {

			}
		})
	})
});


// 格式化时间
function formatTime(datetime, fmt) {
	if (datetime == null || datetime == 0) {
		return "";
	}
	if (parseInt(datetime) == datetime) {
		if (datetime.length == 10) {
			datetime = parseInt(datetime) * 1000;
		} else if (datetime.length == 13) {
			datetime = parseInt(datetime);
		}
	}
	datetime = new Date(datetime);
	var o = {
		"M+" : datetime.getMonth() + 1, // 月份
		"d+" : datetime.getDate(), // 日
		"h+" : datetime.getHours(), // 小时
		"m+" : datetime.getMinutes(), // 分
		"s+" : datetime.getSeconds(), // 秒
		"q+" : Math.floor((datetime.getMonth() + 3) / 3), // 季度
		"S" : datetime.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1,
					(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
							.substr(("" + o[k]).length)));
	return fmt;
}

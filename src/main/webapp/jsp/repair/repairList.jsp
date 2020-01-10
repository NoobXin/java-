<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ctx}/layui/css/layui.css">
<link rel="stylesheet" href="${ctx }/css/list.css" media="all" />
<link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css"
	media="all" />
<script>
	var ctx = "${ctx}";
</script>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote news_search">
		<form class="layui-form">
			<div style="margin-top: 1%">
				<div class="layui-input-inline" style="margin-left: 10px">
					<select name="status" class="" id="status">
						<option value="-1">请选择报修状态</option>
						<option value="1">待审批</option>
						<option value="2">待处理</option>
						<option value="3">处理中</option>
						<option value="4">已处理</option>
					</select>
				</div>
				<div class="layui-inline">
					<input type="text" id="createTimeStart" class="layui-input"
						name="createTimeStart" placeholder="申请时间(开始)" value="">
				</div>
				-
				<div class="layui-inline">
					<input type="text" id="createTimeEnd" class="layui-input"
						name="createTimeEnd" placeholder="申请时间(结束)" value="">
				</div>
				<a style="margin-left: 10px" class="layui-btn search_btn" lay-submit="" data-type="search"
					lay-filter="search">查询</a>
				<div class="layui-inline" style="margin-left: 10px">
					<a class="layui-btn layui-btn-normal userAdd_btn">申请报修</a>
				</div>
			</div>
		</form>
	</blockquote>
	<div class="layui-form">
		<table id="repairList" lay-filter="repairList"></table>
	</div>
	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-sm" lay-event="edit">
            <i class="layui-icon">&#xe642;</i>
        </a>
        <a class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delete">
            <i class="layui-icon">&#xe640;</i>
        </a>
    </script>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/repair/repairList.js"></script>
</body>

</html>

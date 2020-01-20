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
		<a class="layui-btn layui-btn-sm" lay-event="assess">
			<i class="layui-icon">&#xe606;</i>
		</a>
    </script>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/repair/repairList.js"></script>
</body>

</html>

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
	<div class="layui-form">
		<table id="assList" lay-filter="assList"></table>
	</div>
	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-sm" lay-event="delete">
            <i class="layui-icon">&#xe642;</i>
        </a>
    </script>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/ass/assList.js"></script>
</body>

</html>

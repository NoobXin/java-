<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ctx }/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${ctx }/css/font_eolqem241z66flxr.css"
	media="all" />
<link rel="stylesheet" href="${ctx }/css/list.css" media="all" />
<script>
	var ctx = "${ctx}";
</script>
</head>
<body class="childrenBody">
	<input type="hidden" id="adminId"
		value="${admin.id }" />
<%--	<blockquote class="layui-elem-quote list_search">--%>
<%--		<div class="layui-inline">--%>
<%--			<a class="layui-btn layui-btn-normal adminAdd_btn"><i--%>
<%--				class="layui-icon">&#xe608;</i> 添加管理员</a>--%>
<%--		</div>--%>
<%--	</blockquote>--%>
	<div class="layui-row bd-border ">
		<div class="layui-input-inline">
			<label class="layui-form-label">选择文件：&nbsp;</label>
			<div class="layui-input-inline" style="width: 150px;">
				<button type="button" class="layui-btn" id="test1">
					<i class="layui-icon">&#xe67c;</i>选择
				</button>
			</div>
			<div class="layui-input-inline">
				&nbsp;&nbsp;
				<button class="layui-btn bd-btn-radius layui-btn-normal" id="submit">确定</button>
			</div>
		</div>
	</div>

	<table id="adminList" lay-filter="test"></table>
	<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
	<script type="text/javascript" src="${ctx }/js/admin/adminList.js"></script>
	<script type="text/html" id="barEdit">
		<a class="layui-btn layui-btn-sm" lay-event="edit">
            <i class="layui-icon">&#xe642;</i>
        </a>
        <a class="layui-btn layui-btn-sm layui-btn-danger" lay-event="del">
            <i class="layui-icon">&#xe640;</i>
        </a>
	</script>
	<script type="text/html" id="sexTpl">
 		 {{#  if(d.sex == 0){ }}
   			 <span style="color: #F581B1;">女</span>
  		{{#  } else if(d.sex == 1){ }}
   		 	<span style="color: #1e9fff;">男</span>
		{{#  } else{ }}
   		 	<span style="color: #08f55f;">保密</span>
  		{{#  } }}
	</script>
</body>
</html>
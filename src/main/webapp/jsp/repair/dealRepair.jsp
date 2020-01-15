<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <script>
        var ctx = "${ctx}";
    </script>
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;" id="arf">
    <input type="hidden" id="repairId" name="repairId" value="${info.repairId }"/>
    <input type="hidden" id="repairStatus" name="repairId" value="${info.repairStatus }"/>
    <div class="layui-form-item">
        <label class="layui-form-label">修理人姓名</label>
        <div class="layui-input-block">
            <input type="text" id="repairManId" class="layui-input userName" lay-verify="required" placeholder="请输入修理人姓名" name="repairManId" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">描述</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入角色描述" class="layui-textarea linksDesc" lay-verify="required" name="description" >${info.description}</textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="dealMan">立即提交</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/repair/repairList.js"></script>
</body>
</html>

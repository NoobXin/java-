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
    <br><br>
    <div class="layui-form-item">
        <label class="layui-form-label">评价</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入评价" class="layui-textarea linksDesc" lay-verify="required" name="assess" ></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="dealAss">立即提交</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx }/layui/layui.js"></script>
<script type="text/javascript" src="${ctx }/js/repair/repairList.js"></script>
</body>
</html>

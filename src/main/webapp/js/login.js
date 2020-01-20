layui.use([ 'element', 'layer'], function(exports) {
	var $ = layui.jquery;
	var element = layui.element;
	var layer = layui.layer;

	$(function() {
		var show_num=[];


		$('#loginBt').on('click', function() {
			var username = $('#username').val();
			var password = $('#password').val();
			var num = show_num.join("");
			
			if ("" == username) {
				layer.alert("请输入用户名！");
				$("#code").val('');
				return false;
			} else if ("" == password) {
				layer.alert("请输入密码！");
				$("#code").val('');
				return false;
			}
				var i;
				$.ajax({
					type:"post",
					url:ctx+"/admin/login",
					data:{
						username:username,
						password:password
					},
					beforeSend:function(){
						i=show_wait();
					},
					success:function(result){
						if(result.code == 0){
							parent.location.href = ctx+'/admin/index';
							close_wait(i);
						}else if(result.code != 0){
							layer.msg('用户名或密码错误', {icon:5, shade:[0.5, '#000000'], shadeClose:true});
							//draw(show_num);
							close_wait(i);
						}	
					},
					error:function(){
						layer.alert("获取数据失败！");
						//draw(show_num);
						close_wait(i);
					}
				});
				$("#code").val('');
				$("#username").val('');
				$("#password").val('');
				return false;
		});

	});
	
	function show_wait(){
		return layer.load(1, {shade: [0.5,'#000']});
	};
	
	function close_wait(index){
		layer.close(index);
	}
	$(".userAdd_btn").click(function() {
		var index = layui.layer.open({
			title : "添加用户",
			type : 2,
			content : ctx+"/admin/addAdmin",
			area: ['450px', '570px']
		})
	})
	
});

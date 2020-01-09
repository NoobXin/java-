layui.use([ 'form','layer','jquery','laydate'], function() {
	var layer = parent.layer === undefined ? layui.layer : parent.layer,
			laypage = layui.laypage,laydate = layui.laydate,
			$ = layui.jquery,
			form = layui.form;
			
			form.verify({ 
				pass: [/(.+){6,16}$/, '密码必须6到16位']
				,repass: function(value){
					var repassvalue = $('#password').val();
					if(value != repassvalue){
						return '两次输入的密码不一致!';
					}
				}
			});
	

	
	form.on("submit(addUser)",function(data){
		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.2});
		var index1 = parent.layer.getFrameIndex(window.name);
		var msg,flag=false;
 		$.ajax({
    		type: "post",
            url: ctx+"/admin/insAdmin",
            async:false,
            data:data.field,
			dataType:"json",
			success:function(d){
				if(d.code==0){  
					msg="用户添加成功！";
		        	flag=true;
		        	$("#auf")[0].reset();
				}else{
					msg=d.msg;
				}
			}

        });
 		setTimeout(function () {
 			parent.layer.close(index1);
 			top.layer.close(index);
 			if(flag){
 				top.layer.msg(msg,{icon: 1});
 			}else{
 				top.layer.msg(msg,{icon: 5});
 			}
 			//parent.location.reload();
 	},2000);
 		return false;
})
});
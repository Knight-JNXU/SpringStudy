/**
 * @author knightjxnu
 * @returns
 */
$(function() {

	var registerUrl = base+"/account/register";
	
	$('#registerBt').on('click tap', function() {
		userName = $('#userName').val();
		userPwd = $('#userPwd').val();
		if(true == checkOut(userName, userPwd)){
			userPwd = md5(userPwd);
			$.ajax({
				url : registerUrl,
				type : "post",
				data : {"userName":userName, "userPwd":userPwd},
				async : false,
				success : function(data) {
					alert(data.data);
//					if(true == data.success){
//						alert(data.data);
//					}else{
//						alert(data.error);
//					}
				},
				error:function(a,b,c){  
			        alert("注册失败："+b);  
			    }
			});
		}else{
			alert("账号密码非法！");
		}
	})
	
	/**
	 * 检测账号、密码是否合法
	 * 合法，返回 true
	 * 非法，返回 false
	 */
	function checkOut(userName, userPwd){
		tempName = $.trim(userName);
		tempPwd = $.trim(userPwd);
		if(0==tempName.length || 0==tempPwd.length){
			return false;
		}
		return true;
	}
});

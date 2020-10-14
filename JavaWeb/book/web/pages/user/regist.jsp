<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<!--静态包含-->
	<%@include file="/pages/common/head.jsp"%>
	<script>
		$(function () {
			$("#sub_btn").click(function () {
				//验证用户名：必须是由字母数字下划线组成，长度5-12
				//1.获取用户名框里的内容
				var usernameText = $("#username").val();
				//2.创建正则表达式
				var usernamePatt = /^\w{5,12}$/;
				if(!usernamePatt.test(usernameText)){
					$(".errorMsg").text("用户名不合法");
					return false;
				}

				//验证密码：
				var passwordText = $("#password").val();
				//2.创建正则表达式
				var passwordPatt = /^\w{5,12}$/;
				if(!passwordPatt.test(passwordText)){
					$(".errorMsg").text("密码不合法");
					return false;
				}
				//3.验正确认密码：与上面的密码要相同
				var repwd = $("#repwd").val();
				if (repwd!=passwordText){
					$(".errorMsg").text("确认密码和密码不一致");
					return false;
				}
				//4.邮箱验证
				var emailText = $("#email").val();
				var emailPatt = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
				if (!emailPatt.test(emailText)){
					$(".errorMsg").text("邮箱格式不对，请检查");
					return false;
				}
				//5.验证验证码 目前只要不为空就行

				var codeText = $("#code").val();
				codeText = $.trim(codeText);
				if (codeText == null || codeText == ""){
					$(".errorMsg").text("验证码不能为空");
					return false;
				}

			$(".errorMsg").text(" ");
		});
		})
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									<%=request.getAttribute("msg")==null?" ":request.getAttribute("msg")%>
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
										   tabindex="1" name="username" id="username" value="<%=request.getAttribute("username")==null?
										   " ":request.getAttribute("username")%>"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off"
										   tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off"
										   tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off"
										   tabindex="1" name="email" id="email" value="<%=request.getAttribute("email")==null?
										   " ":request.getAttribute("email")%>"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 150px;" id="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<!--页脚公共部分，静态包含-->
		<%@include file="/pages/common/foot.jsp"%>
</body>
</html>
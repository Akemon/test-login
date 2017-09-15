<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>  
<script>
	function change(imgObj) {
		imgObj.src = "IdentifyAction.action?date=" + new Date().getTime();
	}
</script>
<body>
	<h2>login page!</h2>
	<H1 style="color:red"><s:property value="message" /></H1>
	<br>
	<s:form action="Login_login" method="post">
		<s:textfield name="name" label="用户名"></s:textfield>
		<s:textfield name="pass" label="密码"></s:textfield>
		<s:textfield name="code" label="验证码"></s:textfield>
		<img src="IdentifyAction.action" title="点击更换" onclick="change(this);" />
		<s:submit value="登录"></s:submit>
	</s:form>

</body>
</html>

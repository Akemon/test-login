<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional //EN"
"http://www.w3.org/TR/html4/loosse.dtd">
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>  
<body>
姓名:<s:property value="user.name"/><br>
用户名：<s:property value="user.loginName"/><br>
密码：<s:property value="user.loginPwd"/><br>
年龄：<s:property value="user.age"/><br>
性别：<s:property value="user.sex"/><br>
邮箱：<s:property value="user.email"/><br>
</body>

</html>

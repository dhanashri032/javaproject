<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link href="mycss.css" rel="stylesheet" style=""text/css"">
</head>
<body>
	<spr:form action="login.htm" method="post" commandName="admin" >
	
	<div style="padding-top: 200px;">
	
	<table align="center" style="background: lightblue; border: 2px solid blue; border-radius: 8px;">
		<tr>
			<td>
				User Name:
			</td>
			<td>
				<spr:input path="uname"/>
				<font color="red" ><spr:errors path="uname"></spr:errors></font>
			</td>
		</tr>
		<tr>
			<td>
				PassWord:
			</td>
			<td>
				<spr:password path="passWord"/>
				<font color="red" ><spr:errors path="passWord"></spr:errors></font>
			</td>
		</tr>
		<tr>
			<td>
				<a href="index.jsp" style="color: blue;text-decoration: none;" >Back</a>
			</td>
			<td>
				<input type="submit"  value="Login" >
			</td>
		</tr>
		<tr>
			<td>
				<a href="forgot_password.jsp" style="color: blue;text-decoration: none;" >Forgot Password</a>
			</td>
		</tr>
	</table>
	
	</div>
	
	</spr:form>
</body>
</html>
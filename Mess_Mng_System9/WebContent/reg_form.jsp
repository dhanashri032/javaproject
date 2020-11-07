<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link href="mycss.css" rel="stylesheet" style=""text/css">
</head>
<body>

<spr:form action="reg.htm" method="post" commandName="admin"> 



<h1><div style="padding-top: 90px;padding-left: 550px;padding-bottom: 20px; ">Sign Up</div></h1>

<div style="padding-top: 90x;">



<table align="center" style="background-color: lightblue; border: 2px solid blue; border-radius: 8px;">
	<tr>
		<td>
			Name:
		 </td>
		 <td>
			<spr:input path="sname" />
		 </td>
	</tr>
	
	<tr>
		<td>
			Roll No:
		 </td>
		 <td>
			<spr:input path="rollno" />
		 </td>
	</tr>
	<tr>
		<td>
			UserName:
		 </td>
		 <td>
			<spr:input path="uname" />
		 </td>
	</tr>
	<tr>
		<td>
			Password:
		 </td>
		 <td>
			<spr:password path="passWord" />
		 </td>
	</tr>
	<tr>
		<td>
			Payment:
		 </td>
		 <td>
			<spr:input path="payment" />
		 </td>
	</tr>
	<tr>
		<td>
			Mobile No:
		 </td>
		 <td>
			<spr:input path="MobileNo" />
		 </td>
	</tr>
	
	<tr>
		<td>
			<a href="index.jsp" style="color: blue;text-decoration: none;">Back</a>
		 </td>
		 <td>
			<input type="submit" value="Register">
		 </td>
	</tr>
	
	
</table>

</div>

</spr:form>
</body>
</html>
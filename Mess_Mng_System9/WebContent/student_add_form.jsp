<%@page import="com.cdac.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    

 <%@ include file="cache_control.jsp" %>
    
    <% 
	Admin user1 =(Admin)session.getAttribute("admin");
	if(user1 !=null  && user1.getRollno() != 0){
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student Form</title>
<link href="mycss.css" rel="stylesheet" style="text/css">
</head>
<body>
	<spr:form action="student_add.htm" method="post" commandName="student" >
	
	<h1><div style="padding-top: 100px;padding-left: 520px;padding-bottom: 20px; ">Add Student</div></h1>
	
	<div>
	
	<table align="center" style="background-color: lightblue;border: 2px solid blue; border-radius: 8px;" >
		<tr>
			<td>
				Date:
			</td>
			<td>
				<spr:input path="date"/>
			</td>
		</tr>
		<tr>
			<td>
				Breakfast:
			</td>
			<td>
				<spr:input path="breakfast"/>
			</td>
		</tr>
		<tr>
			<td>
				Lunch:
			</td>
			<td>
				<spr:input path="lunch"/>
			</td>
		</tr>
		<tr>
			<td>
				Dinner:
			</td>
			<td>
				<spr:input path="dinner"/>
			</td>
		</tr>
		<tr>
			<td>
				<a href="home.jsp"  style="color: blue;text-decoration: none;">Back</a>
			</td>
			<td>
				<input type="submit"  value="Add" >
			</td>
		</tr>
		
	</table>
	
	</div>
	
	</spr:form>
</body>
</html>

<%
	}else
		response.sendRedirect("index.jsp");
%>
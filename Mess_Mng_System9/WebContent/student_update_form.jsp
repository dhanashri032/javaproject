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
<title>Update Student Form</title>
<link href="mycss.css" rel="stylesheet" style="text/css">
</head>
<body>
	<spr:form action="student_update.htm" method="post" commandName="student" >
	<table align="center" >
		
		<tr>
			<td>
			
			</td>
			<td>
				<spr:hidden path="sid"/>
			</td>
		</tr>
		
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
				<a href="student_list.htm" >Back</a>
			</td>
			<td>
				<input type="submit"  value="Update" >
			</td>
		</tr>
		
	</table>
	</spr:form>
</body>
</html>
<%
	}else
		response.sendRedirect("index.jsp");
%>
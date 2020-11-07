<%@page import="com.cdac.dto.Admin"%>
<%@page import="com.cdac.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri ="http://www.springframework.org/tags/form" prefix="spr"%>
    <%@ include file="cache_control.jsp" %>
   
   <% 
	Admin user1 =(Admin)session.getAttribute("admin");
	if(user1 !=null  && user1.getRollno() != 0){
%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
<link href="mycss.css" rel="stylesheet" style="text/css">
<style>
table {
  border-collapse: collapse;
  width: 80%;
}

td{
  border: 1px solid black;
  text-align: left;
  padding: 8px;
}
</style>
</head>
<body>
	<div style="margin-left: 440px; display: flex;">
		<h4><p style="padding-right: 30px">Breakfast</p></h4>
		<h4><p>lunch</p></h4>
		<h4><p style="padding-left: 40px">dinner</p></h4>
	</div>
	<table align="center" >
	
		<% 
		List<Student> elist = (List<Student>)request.getAttribute("stuList");
		for(Student stu : elist){
		%>
		
		<tr>
			<td>
				<%=stu.getDate()%>
			</td>
		
			<td>
				<%=stu.getBreakfast()%>
			</td>
		
			<td>
				<%=stu.getLunch()%>
			</td>
		
			<td>
				<%=stu.getDinner()%>
			</td>
			<td>
				<a href="student_delete.htm?sid=<%=stu.getSid()%>" style="color: black;text-decoration: none;">Delete</a>
			</td>
			<td>
				<a href="student_update_form.htm?sid=<%=stu.getSid()%>" style="color: black;text-decoration: none;">Update</a>
			</td>
		</tr>
		<% } %>
	</table>
	<p style="margin-left: 600px;"><a href="home.jsp" style="color: black;text-decoration: none;">Back</a></p>
	
</body>
</html>

<%
	}else
		response.sendRedirect("index.jsp");
%>


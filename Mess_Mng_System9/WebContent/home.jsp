<%@page import="com.cdac.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="cache_control.jsp" %>
    
    <% 
	Admin user1 =(Admin)session.getAttribute("admin");
	if(user1 !=null  && user1.getRollno() != 0){
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link href="mycss.css" rel="stylesheet" style="text/css">
</head>
<body>
	<div style="background-color: Gold ;height: 50px; display: flex;align-items: center;">
	
	 	<div><a href="home.jsp" style="margin-left: 20px; color: black;font-size: 20px; text-decoration: none;" >Home</a></div>
	
		<div> <a href="prep_student_add_form.htm" style="margin-left: 30px; color: black;font-size: 20px; text-decoration: none;">Add Student</a> </div>
		
		<div><a href="student_list.htm" style="margin-left: 30px; color: black;font-size: 20px; text-decoration: none;">Student List</a> </div>
		
		<div> <a href="logout.htm" style="margin-left: 810px; color: black;font-size: 20px; text-decoration: none;">Log Out</a> </div>
	</div>
	
	<div style="display: flex;justify-content: center;color: black; font-size: 40px;margin-top: 90px;font-weight: bold;">Welcome To Mess</div>
	
	<img id="image-1" alt="" src="thali.jpg"/ style="height: 50vh;width: 70vh;padding-left: 425px;padding-top: 20px;">
	
</body>
</html>

<%
	}else
		response.sendRedirect("index.jsp");
%>


<%
session.removeAttribute("admin");
session.invalidate();
response.sendRedirect("index.jsp");
%>
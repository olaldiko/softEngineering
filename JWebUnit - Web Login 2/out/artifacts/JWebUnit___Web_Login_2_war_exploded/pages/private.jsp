<%@ page language="java" 
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
         import="model.User"
   %>

   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">

   <html>
<%
		HttpSession sesion = request.getSession(true);
		if (sesion.getAttribute("isLogin") == null ){
		%>	
		<a href="<%= request.getContextPath()%>/index.jsp">Login</a>	
		<jsp:include page="/pages/crossSiteError.jsp" />
		<%	}else{ %>
			<a href="logout">Logout</a>	
			 <jsp:include page="<%=(String)request.getAttribute(\"content\")%>" /> 
		<% 	} %>
   </html>
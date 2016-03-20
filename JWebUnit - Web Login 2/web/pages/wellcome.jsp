<%@ page import="model.User" %>
<head>
         <meta http-equiv="Content-Type" 
            content="text/html; charset=windows-1256">
         <title>User Logged Successfully</title>
      </head>

      <body>

	<center>
    	<% User currentUser = (User) (session.getAttribute("currentSessionUser"));%>
		Welcome <%= currentUser.getFirstName() + " " + currentUser.getLastName() %>
	</center>
</body>


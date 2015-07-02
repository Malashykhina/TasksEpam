<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body>

    <h4>
        Hello,
        <%=session.getAttribute("name")%></h4>
    <h3>Would you like some coffee?</h3>
	<a href="/Test3/order"> Order it now </a> 
</body>
</html>
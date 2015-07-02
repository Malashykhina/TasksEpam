<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <h3>Please, choose your coffee</h3>

	<form>
	<c:forEach items="${coffee}" var="item">
    ${item} <br>
	</c:forEach>

		<c:forEach var="i" begin="1" end="5">
  		 <input type="radio" name="coffeeType" value="<c:out value="${i}"/>" checked><c:out value="${i}"/>
			<br>
		</c:forEach>
	
		<c:forEach var="i" begin="1" end="5">
  		 <input type="radio" name="coffeeType1" value="${coffee.value}" checked>${coffee}
		 <br>
		</c:forEach>
	</form> 
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<c:url value="/test" var="test"></c:url>
	
		<form action='<c:out value="${test}"></c:out>' method="post">
			Name: <input type="text" name="name"><br>
			<input type="submit" value="Add Session">
		</form>


</body>
<body>
		  <%-- Room List Logic --%>
                <c:if test="${not empty requestScope.Data}">
               <table style="width:100%">
               			<tr>
               				<th>Room Name</th>
               				<th>Capacity</th>
               			</tr>
               			
               			<c:forEach items="${requestScope.Data}" var="data">
               				<td><c:out value="${data.name}"></c:out></td>		
               				<td><c:out value="${data.capacity}"></c:out></td>		
               			</c:forEach>
               			 
               </table>
              </c:if> 

</body>
</html>
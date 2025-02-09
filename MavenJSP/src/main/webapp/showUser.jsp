<%@ page import="com.web.model.User" language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>
<style>
    body {
      margin: 0;
      padding: 0;
      width: 100vw;
      height: 100vh;
      box-sizing: border-box;
      background-color: rgb(229, 229, 242);
      /* align-content: center; */
      display: grid;
      place-items: center;
    }

    table,
    th,
    td {
      padding: 20px 40px;
      border: 1px solid black;
      border-collapse: collapse;
    }
  </style>
</head>
<body>
	<h1>User Details:</h1>
        <table>
            <tr>
                <th>UID</th>
                <th>Name</th>
                <th>Tech</th>
            </tr>
            	<!-- Case 1: Show single user if available -->
			    <c:if test="${not empty user}">
				    <tr>
				    	<td>${user.uid}</td>
				    	<td>${user.uname}</td>
				    	<td>${user.tech}</td>    
				    </tr>
			    </c:if>
			    <!-- Case 2: Show all users if userList is available -->
			    <c:if test="${not empty userList}">
			    	<c:forEach var="u" items="${userList}">
			    		<tr>
			    			<td>${u.uid}</td>
			    			<td>${u.uname}</td>
			    			<td>${u.tech}</td>
			    		</tr>
			    	</c:forEach>
			    </c:if>
			    <!-- If neither single user nor user list is found -->
			    <c:if test="${empty user and empty userList}">
			    	<tr>
			    		<td colspan="3">No User Found</td>
			    	</tr>
			    </c:if>
        </table>
</body>
</html>
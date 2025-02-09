<%@ page import="com.web.model.User" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<h1>Message :</h1>
<h2>${message}</h2>
<a href="showUsers.jsp">Show All Users</a>
</body>
</html>
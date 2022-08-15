<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<head>

<meta charset="ISO-8859-1">
<title>admin page</title>
</head>
<body>


<div class="container">

    <div class="starter-template">
        <h1>Admin page (Spring Security protected)</h1>

        <h1 th:inline="text">Hello [[${#httpServletRequest.remoteUser}]]!</h1>
      	<span sec:authorize="isAuthenticated()">
	                | Logged user: <span sec:authentication="name"></span> |
	                Roles: <span sec:authentication="principal.authorities"></span> |
	                <a th:href="@{/dashboard}">Back</a>
	     </span>
		 One Time Password : <a th:href="@{/generateOtp}">OTP</a>

    </div>

</div> 


</body>
</html>
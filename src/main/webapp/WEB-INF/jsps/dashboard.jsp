<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">

		<div class="starter-template">
			<h1>Dashboard</h1>

			<h1 th:inline="text">Hello :
				[[${#httpServletRequest.remoteUser}]]!</h1>

		</div>

		<div sec:authorize="hasRole('ROLE_ADMIN')">
			<a th:href="@{/admin}">Admin Screen</a>
		</div>
		<div sec:authorize="hasRole('ROLE_USER')">
			<a th:href="@{/user}">User Screen</a>
		</div>
	</div>

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
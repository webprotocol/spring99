<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerForm.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>

<form:form action="/country/register" method="post" modelAttribute="countryForm">
	<form:errors cssClass="animated bounce"/>
	<div class="form-group">
		<label for="code">code : </label>
		<form:input path="code" cssClass="form-control"/>
		<form:errors path="code" cssClass="animated bounce"/>
	</div>
	<div class="form-group">
		<label for="name">name : </label>
		<form:input path="name" cssClass="form-control"/>
		<form:errors path="name" cssClass="animated bounce"/>
	</div>
	
	<button type="submit" class="btn btn-success">submit</button>
</form:form>
</body>
</html>
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

<form:form action="/city/register" method="post" modelAttribute="cityForm">
	<form:errors cssClass="animated bounce"/>
	<div class="form-group">
		<label for="name">Name : </label>
		<form:input path="name" cssClass="form-control"/>
		<form:errors path="name" cssClass="animated bounce"/> <br>
	</div>
	<div class="form-group">
		<label for="countryCode">countryCode : </label>
		<form:input path="countryCode" cssClass="form-control" onfocus="xxx(event)"/>
		<form:errors path="countryCode" cssClass="animated bounce"/>
		<form:errors path="countryCodeInvalid" cssClass="animated bounce"/>
	</div>
	<div class="form-group ">
		<label for="district">district : </label>
		<form:input path="district" cssClass="form-control"/>
		<form:errors path="district" cssClass="animated bounce"/> <br>
	</div>
	<div class="form-group">
		<label for="population">population : </label>
		<form:input path="population" cssClass="form-control"/>
		<form:errors path="population" cssClass="animated bounce"/> <br>
	</div>
	
	<button type="submit" class="btn btn-success">submit</button>
	<a href="/city/register" class="btn btn-primary">reset</a>
</form:form>
<script type="text/javascript">
	$('input').on('focus', function(event) {
		$(this).next().remove();
	});
	
</script>
</body>
</html>
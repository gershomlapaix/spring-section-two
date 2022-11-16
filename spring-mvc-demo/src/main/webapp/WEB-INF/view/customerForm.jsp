<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
  .error{
    color:red
  }
</style>
</head>
<body>

<form:form action="processForm" modelAttribute="customer">
  First name: <form:input path="firstName"/>
  <form:errors path="firstName" cssClass="error" />
  <br></br>
  
   Last name: <form:input path="lastName"/>
   <form:errors path="lastName" cssClass="error" />
  <br></br>
  
   Course code: <form:input path="courseCode"/>
   <form:errors path="courseCode" cssClass="error" />
  <br></br>
  
  <input type="submit"/>
  
</form:form>

</body>
</html>
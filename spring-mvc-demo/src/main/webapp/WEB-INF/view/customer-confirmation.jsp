<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student confirmation</title>
</head>
<body>
 Our good customer is : ${customer.firstName} ${customer.lastName }
 <br></br>
  
  Free passes: ${customer.freePasses }
  
   <br></br>
  
  Postal code: ${customer.postalCode }
</body>
</html>
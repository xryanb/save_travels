<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="d-flex justify-content-around align-items-center container">
<h1>Expense Details</h1>
<a href="/expenses">Go back</a>
</div>
<div class="container">
	<p>Expense Name: ${travel.name}</p>
	<p>Expense Description:${travel.description}</p>
	<p>Vendor: ${travel.vendor}</p>
	<p>Amount Spend: ${travel.amount}</p>
</div>
</body>
</html>
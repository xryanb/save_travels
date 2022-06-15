<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit my Task</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

<div class="d-flex justify-content-between align-items-center container">
<h1 style="color: green;">Edit Expense</h1>
<a href="/expenses">Go back</a>
</div>
<div class='container'>
<form:form action="/expenses/${travel.id}" method="post" modelAttribute="travel">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="name">Expense Name:</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="description">Expense Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="vendor">Vendor:</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount Spent:</form:label>
        <form:errors path="amount"/>     
        <form:input type="number" path="amount" min="20"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
</div>
</body>
</html>
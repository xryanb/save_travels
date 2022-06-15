<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<style>
body {
  background-color: linen;
}

h1 {
  color: maroon;
}


</style>
</head>
<body>
<div class='container'>
<h1>Save Travels</h1>
<table class="table table-dark table-striped">
	<tr>
	 <th scope="col">Expense</th>
      <th scope="col">Vendor</th>
       <th scope="col">Amount</th>
        <th scope="col">Actions</th>
        <th scope="col"></th>
        </tr>
      <tbody>
      
        <c:forEach var="travel" items="${travels}">
        <tr>
        <td><a href="/expenses/${travel.id}/show"><c:out value="${travel.name}"></c:out></a></td>
        <td><c:out value="${travel.vendor}"></c:out></td>
        <td><c:out value="${travel.amount}"></c:out></td>
        <td><a href="/expenses/${travel.id}/edit">Edit</a></td>
        <td><form action="/expenses/${travel.id}/delete" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete" class="btn btn-danger">
</form>
</td>
        </tr>
    </c:forEach>

</tbody>
</table>
</div>
<div class='container'>
<h1>Add an expense:</h1>

<form:form action="/expenses/create" method='POST' modelAttribute="travel">

 <div class="d-flex justify-content-around align-items-center">
<form:label path="name">Expense Name: </form:label>
<form:input type="text" path="name"/>
<form:errors path="name" class="text-danger"/>
</div> 

<div class="d-flex justify-content-around align-items-center mt-2">
<form:label path="vendor">Vendor: </form:label>
<form:input type="text" path="vendor"/>
<form:errors path="vendor" class="text-danger"/>
</div>

<div class="d-flex justify-content-around align-items-center mt-2">
<form:label path="amount">Amount: </form:label>
<form:input type="number" path="amount" min="20"/>
<form:errors path="amount" class="text-danger"/>
</div>

<div class="d-flex justify-content-around align-items-center mt-2">
<form:label path="description">Description: </form:label>
<form:textarea path="description" rows="4" cols="50"/>
<form:errors path="description" class="text-danger"/>
</div>

<button class="btn btn-primary">Submit</button>
</form:form>

</div>
</body>
</html>
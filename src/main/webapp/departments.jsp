<%@ page import="models.Department"%>
<%@ page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>

<html>
<head>
    <link href="css/table.css" rel="stylesheet" type="text/css">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<body>

<div class="form-header">
<div class="left-column">
<h2>List of all departments</h2>

<table class="simple-little-table" cellspacing='0' align="center">
        <th>
            <td>Name</td>
            <td>ID</td>
        </th>
<% int counter=0; %>
    <c:forEach items="${requestScope.departments}" var="emp">
    <tr>
            <td><%= ++counter %></td>
            <td><c:out value="${emp.name}"></c:out></td>
            <td><c:out value="${emp.id}"></c:out></td>
    </tr>
    </c:forEach>
    </table>

</div>
<div class="right-column">
<div class="createObject">
<label>Adding new department</label>

    <form method="post">
            <input type="text" placeholder="Name of department" name="name"><br />
        <button type="submit">Submit</button>
    </form>
</div>

<div class="deleteObject">
<label>Deleting department</label>
    <form method="post" >
            <label>Name:
                <input class="input" type="hidden" name="action" value="delete"/>
                <input type="text" placeholder="Name of department" name="deleteName" ><br />
            </label>

            <button type="submit">Delete</button>
        </form>
</div>

<div class="showEmployees">
<label>To show employees by department id</label>
    <form method="post" >
            <label>Department:
                <input class="input" type="hidden" name="action" value="delete"/>
                <input type="text" placeholder="Name of department" name="deleteName" ><br />
            </label>

            <button type="submit">To show</button>
        </form>
</div>

</div>
</div>



</body>
</html>
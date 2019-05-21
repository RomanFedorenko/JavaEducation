<%@ page import="models.Employee"%>
<%@ page import="java.util.LinkedList"%>


<html>
<head>
    <link href="css/table.css" rel="stylesheet" type="text/css">
</head>
<body>
<section class="main_content">
<h2>List of all employees</h2>

<table class="simple-little-table" cellspacing='0' align="center">
        <th>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Email</td>
            <td>Birth date</td>
            <td>Phone number</td>
            <td>Salary</td>
            <td>Department</td>

        </th>
        <%
            LinkedList<Employee> emps = (LinkedList<Employee>)request.getAttribute("employees");
            int counter=0;
            for(Employee emp : emps) {
        %>
        <tr>
            <td><%= ++counter %></td>
            <td><%= emp.getFirstName() %></td>
            <td><%= emp.getLastName() %></td>
            <td><%= emp.getEmail() %></td>
            <td><%= emp.getBirthDate() %></td>
            <td><%= emp.getPhoneNumber() %></td>
            <td><%= emp.getSalary() %></td>
            <td><%= emp.getDepId() %></td>

        </tr>
        <%
            }
        %>
    </table>
</section>


</body>
</html>
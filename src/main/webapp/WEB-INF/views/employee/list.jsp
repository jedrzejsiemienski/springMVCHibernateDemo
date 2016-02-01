<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Employee Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>

<h1>Employees List</h1>
<c:if test="${!empty listEmployees}">
    <table class="tg">
    <tr>
        <th width="80">Employee ID</th>
        <th width="120">Employee Name</th>
        <th width="120">Employee Last Name</th>
        <th width="140">Manage possessions</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listEmployees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.lastName}</td>
            <td><a href="<c:url value='/employee/edit/${employee.id}' />" >Manage possessions</a></td>
            <td><a href="<c:url value='/employee/remove/${employee.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>

<a href="<c:url value='/employee/add' />" >Add an employee</a>
<br>
<a href="<c:url value='/items' />" >Manage items</a>

</body>
</html>
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

<a href="<c:url value='/employees' />" >Back to employees list</a>

<h1>
    Employee
</h1>
<c:if test="${!empty employee}">
    <table class="tg">
    <tr>
        <th width="80">Employee ID</th>
        <th width="120">Employee Name</th>
        <th width="120">Employee Last Name</th>
    </tr>
         <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.lastName}</td>
        </tr>
     </table>
</c:if>

<h3>Possessions list</h3>
<c:if test="${!empty employee}">
    <table class="tg">
    <tr>
        <th width="80">Possession ID</th>
        <th width="80">Item ID</th>
        <th width="120">Item Name</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${possessions}" var="possession">
        <tr>
            <td>${possession.id}</td>
            <td>${possession.item.id}</td>
            <td>${possession.item.name}</td>
            <td><a href="<c:url value='/employee/removePossession/${possession.id}/${employee.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>


	<form:form method="POST" modelAttribute="possessionData" action="addPossesion">
		<table>
			<tr>
				<td>Please select:</td>
				<td>
					<form:select path="itemId">
						<form:options items="${items}" />
					</form:select>
					<input id="possessionData" name="employeeId" type="hidden" value="${employee.id}"/> 
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
		</table>
	</form:form>

</body>
</html>
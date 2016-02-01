<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Items Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>

<a href="<c:url value='/employees' />" >Back to employees list</a>

<h1>Items List</h1>
<c:if test="${!empty listItems}">
    <table class="tg">
    <tr>
        <th width="80">Item ID</th>
        <th width="120">Item Name</th>
        <th width="120">Item Quantity</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listItems}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.quantity}</td>
            <td><a href="<c:url value='/item/edit/${item.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/item/remove/${item.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>

<a href="<c:url value='/item/add' />" >Add a item</a>

</body>
</html>
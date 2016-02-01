<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Item Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>

<a href="<c:url value='/items' />" >Back to items list</a>

<h1>
    Add an Item
</h1>
 
<c:url var="addAction" value="/item/add" ></c:url>
 
<form:form action="${addAction}" commandName="item">
<table>

    <tr>
        <td>
            <form:label path="name">
                <spring:message text="Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="name" />
        </td>
    </tr>
    
    <tr>
        <td>
            <form:label path="quantity">
                <spring:message text="Quantity"/>
            </form:label>
        </td>
        <td>
            <form:input path="quantity" />
        </td>
    </tr>

    <tr>
        <td colspan="2">
			<input type="submit" value="<spring:message text="Add Item"/>" />
        </td>
    </tr>
</table> 
</form:form>

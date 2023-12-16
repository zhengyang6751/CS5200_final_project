<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory</title>
</head>
<body>
	<h1>Matching inventories</h1>
        <table border="1">        
             <tr>
                <th>firstName</th>
                <th>lastName</th>
                <th>itemName</th>
                <th>number</th>
            </tr>
            <c:forEach items="${inventorys}" var="inventory" >
                <tr>
                    <td><c:out value="${inventory.getFirstName()}" /></td>
                    <td><c:out value="${inventory.getLastName()}" /></td>
                    <td><c:out value="${inventory.getItemName()}" /></td>
                    <td><c:out value="${inventory.getNumber()}" /></td>
                    
<%--                     <td><a href="accountdelete?accountId=<c:out value="${account.getAccountId()}"/>">Delete</a></td>
                    <td><a href="accountupdate?accountId=<c:out value="${account.getAccountId()}"/>">Update</a></td>
                    <td><a href="characters?accountId=<c:out value="${account.getAccountId()}"/>">Characters</a></td> --%>
                </tr>
            </c:forEach>
       </table>
</body>
</html>
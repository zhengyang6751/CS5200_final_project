<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find a User</title>
</head>
<body>
	<form action="findaccount" method="post">
		<h1>Search for an account by name</h1>
		<p>
			<label for="name">name</label>
			<input id="name" name="name" value="${fn:escapeXml(param.name)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<div id="AccountCreate"><a href="accountcreate">Create Account</a></div>
	<br/>
	<h1>Matching Accounts</h1>
        <table border="1">
            <tr>
                <th>accountID</th>
                <th>name</th>
                <th>emailAddress</th>
                <th>Delete Account</th>
                <th>Update Account</th>
                <th>Characters</th>
                
             
            </tr>
            <c:forEach items="${accounts}" var="account" >
                <tr>
                    <td><c:out value="${account.getAccountId()}" /></td>
                    <td><c:out value="${account.getName()}" /></td>
                    <td><c:out value="${account.getEmailAddress()}" /></td>
                    <td><a href="accountdelete?accountId=<c:out value="${account.getAccountId()}"/>">Delete</a></td>
                    <td><a href="accountupdate?accountId=<c:out value="${account.getAccountId()}"/>">Update</a></td>
                    <td><a href="characters?accountId=<c:out value="${account.getAccountId()}"/>">Characters</a></td>
					
					
   				 </tr>
                
            </c:forEach>
       </table>
</body>
</html>

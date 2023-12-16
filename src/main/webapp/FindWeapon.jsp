<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find a gear</title>
</head>
<body>
	<form action="findweapon" method="post">
		<h1>Search for a gear by name</h1>
		<p>
			<label for="itemName"></label>
			<input id="itemName" name="itemName" value="${fn:escapeXml(param.itemName)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<div id="GearCreate"><a href="weaponcreate">Create Gear</a></div>
	<br/>
	<h1>Matching Gears</h1>
        <table border="1">
            <tr>
                <th>Gear Name</th>
                <th>Gear Level</th>
                <th>Slot</th>
                <th>Required Level</th>
                <th>Required Job</th>
                <th>Defense Rating</th>
                <th>Magic Defense Rating
            </tr>
            <c:forEach items="${gears}" var="gear" >
                <tr>
                    <td><c:out value="${gear.getItemName()}" /></td>
                    <td><c:out value="${gear.getItemLevel()}" /></td>
                    <td><c:out value="${gear.getSlotName()}" /></td>
                    <td><c:out value="${gear.getRequiredLevel()}" /></td>
                    <td><c:out value="${gear.getRequiredJob()}" /></td>
                    <td><c:out value="${gear.getDefenseRating()}" /></td>
                    <td><c:out value="${gear.getMagicDefenseRating()}" /></td>
                    <td><a href="accountdelete?accountId=<c:out value="${account.getAccountId()}"/>">Delete</a></td>
                    <td><a href="accountupdate?accountId=<c:out value="${account.getAccountId()}"/>">Update</a></td>
                    <td><a href="characters?accountId=<c:out value="${account.getAccountId()}"/>">Characters</a></td>
                </tr>
            </c:forEach>
       </table>
</body>
</html>
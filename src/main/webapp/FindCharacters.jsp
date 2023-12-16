<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <%@ page language="java"
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Relative Characters</title>
  </head>
  <body>
    <h1>Matching Characters</h1>
    <table border="1">
      <tr>
        <th>accountID</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>strength</th>
        <th>intelligence</th>
        <th>dexterity</th>
        <th>vitality</th>
        <th>job</th>
        <th>currency</th>
        <th>inventory</th>
      </tr>
      <c:forEach items="${characters}" var="character">
        <tr>
          <td><c:out value="${character.getAccountId()}" /></td>
          <td><c:out value="${character.getFirstName()}" /></td>
          <td><c:out value="${character.getLastName()}" /></td>
          <td><c:out value="${character.getStrength()}" /></td>
          <td><c:out value="${character.getIntelligence()}" /></td>
          <td><c:out value="${character.getDexterity()}" /></td>
          <td><c:out value="${character.getVitality()}" /></td>
          <td><a href="jobs?firstName=<c:out value="${character.getFirstName()}"/>&lastName=<c:out value="${character.getLastName()}"/>">Jobs</a></td>
          <td><a href="currency?firstName=<c:out value="${character.getFirstName()}"/>&lastName=<c:out value="${character.getLastName()}"/>">Currency</a></td>
          <td><a href="inventory?firstName=<c:out value="${character.getFirstName()}"/>&lastName=<c:out value="${character.getLastName()}"/>">Inventory</a></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>

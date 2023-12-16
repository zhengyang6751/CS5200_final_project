<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <%@ page language="java"
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Currency List</title>
  </head>
  <body>
    <h1>Currency List</h1>
    <table border="1">
      <tr>
        <th>Currency Name</th>
        <th>Weekly Caps</th>
        <th>Total Caps</th>
      </tr>
      <c:forEach var="currency" items="${currencies}">
        <tr>
          <td><c:out value="${currency.currencyName}" /></td>
          <td><c:out value="${currency.amountWeek}" /></td>
          <td><c:out value="${currency.amountTotal}" /></td>
        </tr>
      </c:forEach>
    </table>

    <br /><br />

    <p>
      <span id="successMessage"><b>${messages.success}</b></span>
    </p>
  </body>
</html>

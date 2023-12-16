<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <%@ page language="java"
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Relative Jobs</title>
  </head>
  <body>
    <h1>Matching Jobs</h1>
    <table border="1">
      <tr>
        <th>firstName</th>
        <th>lastName</th>
        <th>jobName</th>
        <th>currentEXP</th>
        <th>jobLevel</th>
        <th>requiredEXP</th>
        <th>isCurrentJob</th>
      </tr>
      <c:forEach items="${characterJobs}" var="characterJob">
        <tr>
          <td><c:out value="${characterJob.getFirstName()}" /></td>
          <td><c:out value="${characterJob.getLastName()}" /></td>
          <td><c:out value="${characterJob.getJobName()}" /></td>
          <td><c:out value="${characterJob.getCurrentExp()}" /></td>
          <td><c:out value="${characterJob.getJobLevel()}" /></td>
		  <td><c:out value="${characterJob.getRequiredExp()}" /></td>
          <td><c:out value="${characterJob.isCurrentJob()}" /></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>

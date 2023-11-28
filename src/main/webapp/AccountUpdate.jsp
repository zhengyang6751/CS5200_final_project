<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <%@ page language="java"
contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Update an Account</title>
  </head>
  <body>
    <h1>Update Account</h1>
    <form action="accountupdate" method="post">
      <p>
        <label for="accountId">accountId</label>
        <input
          id="accountId"
          name="accountId"
          value="${fn:escapeXml(param.accountId)}"
        />
      </p>
      <p>
        <label for="newName">New name</label>
        <input id="newName" name="newName" value="" />
      </p>
      <p>
        <label for="newEmail">New Email</label>
        <input id="newEmail" name="newEmail" value="" />
      </p>
      <p>
        <input type="submit" />
      </p>
    </form>
    <br /><br />
    <p>
      <span id="successMessage"><b>${messages.success}</b></span>
    </p>
  </body>
</html>

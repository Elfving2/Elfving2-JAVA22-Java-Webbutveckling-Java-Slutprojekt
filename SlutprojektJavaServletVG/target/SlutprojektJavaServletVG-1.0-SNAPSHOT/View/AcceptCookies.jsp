<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accept Cookies</title>
</head>
<body>
<%-- By clicking on accept cookies the value of the button "accept" will be sent to /AllowCookiesServlet --%>
<form action="/AllowCookiesServlet">
  <div  id="removeButton" class="cookie-banner">
    <button class="cookie-button" name="accept" value="accept"> accept cookies</button>
    <%-- <button name = "deny" value="deny"> Deny cookies</button> --%>
  </div>
</form>
</body>
</html>

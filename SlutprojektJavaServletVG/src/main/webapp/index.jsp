<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="Css/style.css">
</head>
<body>
    <form action="/OWservlet" class="form" method="GET">
        <div class="container">
            <h1>Input a city and its country</h1>

            <div class="city">
                <label for="city">City</label>
                <input type="text" id="city" class="input" name="city" placeholder="city"/>
            </div>

            <div class="country">
                <label for="country">Country</label>
                <input type="text" id="country" class="input" name="country" placeholder="country"/>
            </div>

            <input type="submit" value="go" class="submit"/>
        </div>
    </form>

    <jsp:include page="View/AcceptCookies.jsp" />
</html>
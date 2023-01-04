<%@ page import="Model.WeatherBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- print out bean clouds, bean temperature and bean last update -->
<jsp:include page="../index.jsp"/>
<%
    WeatherBean wBean = (WeatherBean) request.getAttribute("wBean");
    String getClouds = wBean.getCloudsStr();
    String temperature = wBean.getTemperatureStr() + " Degrees ";
    String lastUpdated = wBean.getLastUpdateStr();
%>
        <p> Clouds: <%= getClouds %></p>
        <p> Temperature: <%= temperature %></p>
        <p>last updated: <%= lastUpdated %></p>
<hr>
        <h2> previous search </h2>

    <!--if you accept cookies-->
    <% if(wBean.getSaveCookies() != null) {
        for(String cookies : wBean.getSaveCookies()) { %>
            <p> <%=cookies%></p>
    <% }
        //if you deny cookies -->
    } else if(wBean.getDeniedCookies() != null){ %>
        <p><%=wBean.getDeniedCookies()%></p>
<%}%>

</body>
</html>

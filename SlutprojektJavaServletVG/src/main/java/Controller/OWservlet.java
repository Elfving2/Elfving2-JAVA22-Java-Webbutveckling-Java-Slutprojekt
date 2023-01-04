package Controller;

import Model.GettheWeather;
import Model.WeatherBean;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OWservlet", value = "/OWservlet")
public class OWservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //grabs the city and country parameter and puts them into two new strings
        String cityStr = request.getParameter("city");
        String countryStr = request.getParameter("country");

        WeatherBean wBean = new WeatherBean(cityStr, countryStr);
        GettheWeather.getWeather(wBean);
        
        //fetching session from AllowCookieServlet
        HttpSession session = request.getSession(false);

        String acceptCookies = (String) session.getAttribute("acceptCookies");

        /*
            if session attribute "acceptCookies" != null, get all cookies, if cookie name is not = "Cookie"
            create a new cookie with the name "Cookie", and save it inside an array called setSaveCookies (wBean).
            if there already is a cookie named "Cookie" assign a new value to it and put it inside setSaveCookies

            if session attribute "acceptCookies" == null, create a cookie that holds the city and the country that
            the user entered. Cookie is sent to wBean
        */

        if(acceptCookies != null){
            for (Cookie cookie : request.getCookies()) {
                if (!(cookie.getName().equals("Cookie"))) {
                    Cookie ck = new Cookie("Cookie", cityStr + "/" + countryStr);
                    String[] temp = ck.getValue().split("@");
                    wBean.setSaveCookies(temp);
                    response.addCookie(ck);
                } else {
                    cookie.setValue(cookie.getValue() + "@" + cityStr + "/" + countryStr);
                    String newCookie = cookie.getValue();
                    String[] allTheCookies = newCookie.split("@");
                    wBean.setSaveCookies(allTheCookies);
                    response.addCookie(cookie);
                }
            }
        } else {
            Cookie deniedCookie = new Cookie("deniedCookie", cityStr + "/" + countryStr);
            String denied = deniedCookie.getValue();
            wBean.setDeniedCookies(denied);
            response.addCookie(deniedCookie);
        }

        request.setAttribute("wBean", wBean);
        RequestDispatcher rd = request.getRequestDispatcher("View/ShowWeather.jsp");
        rd.forward(request, response);
    }
}

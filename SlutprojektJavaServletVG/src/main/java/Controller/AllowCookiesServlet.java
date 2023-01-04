package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AllowCookiesServlet", value = "/AllowCookiesServlet")
public class AllowCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            grabs the value from the button and puts it inside allowCookies
            if button is not == null setAttribute to allowCookies
        */

        String allowCookies = request.getParameter("accept");
        //String denyCookies = request.getParameter("deny");

            HttpSession session = request.getSession();
            if(!(allowCookies == null)) {
                session.setAttribute("acceptCookies", allowCookies);
                System.out.println("hello");
            } /*else if(!(denyCookies == null)) {
                session.setAttribute("denyCookies", denyCookies);
                System.out.println(":)))))))))");
            }*/

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
}

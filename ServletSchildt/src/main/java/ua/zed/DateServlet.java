package ua.zed;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class DateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = req.getSession(true);
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.print("<b>");
        Date date = (Date) hs.getAttribute("date");
        if (date != null)
            pw.print("Last access: " + date + "<br>");
        date = new Date();
        hs.setAttribute("date", date);
        pw.println("Current date: " + date);
    }
}

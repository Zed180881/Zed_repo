package ua.zed;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class PostParametersServlet extends GenericServlet {
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        PrintWriter printWriter = servletResponse.getWriter();
        Enumeration e = servletRequest.getParameterNames();
        while (e.hasMoreElements()) {
            String pname = (String) e.nextElement();
            printWriter.print(pname + " = ");
            String pvalue = servletRequest.getParameter(pname);
            printWriter.println(pvalue);
        }
        printWriter.close();
    }
}

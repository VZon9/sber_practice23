package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@WebServlet(urlPatterns = "/time")
public class TimeServlet extends HttpServlet {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<html>\n" +
                "<body>\n" +
                "    <h2>Current time: " + dtf.format(LocalTime.now()) + "<h2>\n" +
                "</body>\n" +
                "</html>");
    }
}

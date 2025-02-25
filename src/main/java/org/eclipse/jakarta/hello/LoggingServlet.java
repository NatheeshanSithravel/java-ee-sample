package org.eclipse.jakarta.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/logtest")
public class LoggingServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(LoggingServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("Processing request in LoggingServlet");
        logger.debug("Debug message from LoggingServlet");
        logger.error("Error log example in LoggingServlet");

        resp.getWriter().write("Check the logs!");
    }
}

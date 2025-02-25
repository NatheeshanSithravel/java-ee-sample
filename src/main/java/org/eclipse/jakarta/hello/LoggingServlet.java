package org.eclipse.jakarta.hello;
package org.eclipse.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


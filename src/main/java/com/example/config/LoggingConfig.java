package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Configures logging at application startup
 */
@WebListener
public class LoggingConfig implements ServletContextListener {
    
    private static final Logger logger = LoggerFactory.getLogger(LoggingConfig.class);
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Remove existing handlers attached to the JUL root logger
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        
        // Install the SLF4J bridge handler
        SLF4JBridgeHandler.install();
        
        logger.info("Jakarta EE Logback Demo application starting");
        logger.info("SLF4J-JUL bridge has been configured");
        logger.info("Java version: {}", System.getProperty("java.version"));
        logger.info("Server: {}", sce.getServletContext().getServerInfo());
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Jakarta EE Logback Demo application stopping");
    }
}
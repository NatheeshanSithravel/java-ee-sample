package com.example.services;

import com.example.util.LoggerUtil;
import jakarta.ejb.Stateless;
import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Service that demonstrates different logging levels
 */
@Stateless
public class MessageService {
    
    private static final Logger logger = LoggerUtil.getLogger(MessageService.class);
    
    /**
     * Log a debug message
     */
    public void logDebug() {
        String messageId = generateMessageId();
        logger.debug("Debug message with ID: {}", messageId);
        logger.debug("Debug messages contain detailed information for troubleshooting. Current time: {}", LocalDateTime.now());
        
        // Use isDebugEnabled to avoid expensive operations when debug is disabled
        if (logger.isDebugEnabled()) {
            logger.debug("Additional debug details: {}", generateDetailedMessage());
        }
    }
    
    /**
     * Log an info message
     */
    public void logInfo() {
        String messageId = generateMessageId();
        logger.info("Info message with ID: {}", messageId);
        logger.info("Info messages provide general information about application progress. Current time: {}", LocalDateTime.now());
        logger.info("Application is running normally with message ID: {}", messageId);
    }
    
    /**
     * Log a warning message
     */
    public void logWarning() {
        String messageId = generateMessageId();
        logger.warn("Warning message with ID: {}", messageId);
        logger.warn("Warning indicates a potential issue that doesn't prevent the application from working. Current time: {}", LocalDateTime.now());
        
        try {
            // Simulate a potential issue
            simulatePotentialIssue();
        } catch (Exception e) {
            logger.warn("Caught a potential issue: {}", e.getMessage());
        }
    }
    
    /**
     * Log an error message
     */
    public void logError() {
        String messageId = generateMessageId();
        logger.error("Error message with ID: {}", messageId);
        logger.error("Error messages indicate serious issues that need attention. Current time: {}", LocalDateTime.now());
        
        try {
            // Simulate an error condition
            simulateErrorCondition();
        } catch (Exception e) {
            logger.error("An error occurred during processing: {}", e.getMessage(), e);
        }
    }
    
    /**
     * Generate a random message ID
     */
    private String generateMessageId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
    
    /**
     * Generate a detailed debug message (simulating an expensive operation)
     */
    private String generateDetailedMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("System properties: ");
        System.getProperties().forEach((key, value) -> {
            if (key.toString().startsWith("java.")) {
                sb.append(key).append("=").append(value).append("; ");
            }
        });
        return sb.toString();
    }
    
    /**
     * Simulate a potential issue that causes a warning
     */
    private void simulatePotentialIssue() throws Exception {
        if (Math.random() > 0.5) {
            throw new Exception("Potential issue detected, but operation can continue");
        }
    }
    
    /**
     * Simulate an error condition
     */
    private void simulateErrorCondition() throws Exception {
        throw new Exception("Simulated error condition occurred");
    }
}
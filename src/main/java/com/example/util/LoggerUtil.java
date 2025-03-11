package com.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for getting logger instances
 */
public class LoggerUtil {
    
    /**
     * Get a logger for the specified class
     * 
     * @param <T> the class type
     * @param clazz the class to get logger for
     * @return the logger instance
     */
    public static <T> Logger getLogger(Class<T> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
    
    /**
     * Get a logger for the specified name
     * 
     * @param name the logger name
     * @return the logger instance
     */
    public static Logger getLogger(String name) {
        return LoggerFactory.getLogger(name);
    }
}
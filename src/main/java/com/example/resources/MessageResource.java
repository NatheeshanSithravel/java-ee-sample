package com.example.resources;

import org.slf4j.Logger;

import com.example.services.MessageService;
import com.example.util.LoggerUtil;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * REST endpoint that generates log messages at different levels
 */
@Path("/messages")
public class MessageResource {
    
    private static final Logger logger = LoggerUtil.getLogger(MessageResource.class);
    
    @EJB
    private MessageService messageService;
    
    /**
     * Generate a log message of the specified level
     * 
     * @param level the log level to generate (debug, info, warn, error)
     * @return response with confirmation
     */
    @GET
    @Path("/{level}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateLog(@PathParam("level") String level) {
        logger.info("Received request to generate {} level log", level);
        
        switch (level.toLowerCase()) {
            case "debug":
                messageService.logDebug();
                break;
            case "info":
                messageService.logInfo();
                break;
            case "warn":
                messageService.logWarning();
                break;
            case "error":
                messageService.logError();
                break;
            default:
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"error\": \"Invalid log level. Use: debug, info, warn, error\"}")
                        .build();
        }
        
        return Response.ok()
                .entity("{\"message\": \"Generated " + level + " level log\"}")
                .build();
    }
    
    /**
     * Health check endpoint
     * 
     * @return simple response for health checking
     */
    @GET
    @Path("/health")
    @Produces(MediaType.APPLICATION_JSON)
    public Response healthCheck() {
        logger.debug("Health check requested");
        return Response.ok()
                .entity("{\"status\": \"UP\", \"message\": \"Logback demo is running\"}")
                .build();
    }
}
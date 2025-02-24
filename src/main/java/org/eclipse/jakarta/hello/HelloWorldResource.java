import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldResource {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldResource.class);

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		logger.info("HelloWorldResource accessed!");
		return "Hello, Jakarta EE with Logback!";
	}
}

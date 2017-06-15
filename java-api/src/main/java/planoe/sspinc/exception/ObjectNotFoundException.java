package planoe.sspinc.exception;

import com.google.common.collect.ImmutableMap;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Used to return custom 404 messages
 */
public class ObjectNotFoundException extends WebApplicationException {

    public ObjectNotFoundException(String message) {
        super(Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(ImmutableMap.of("error", ImmutableMap.of("message", message)))
                .build());
    }
}
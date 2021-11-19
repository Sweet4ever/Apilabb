package se.iths;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CustomException extends WebApplicationException {
    public Response CustomException(String message)  {
        return (Response.status(Response.Status.NOT_FOUND)
                .entity(message)
                .type(MediaType.APPLICATION_JSON).build());
    }
}


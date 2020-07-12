package JWTHelper;

import com.sun.jersey.spi.container.*;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import javax.ws.rs.ext.Provider;
import javax.annotation.Priority;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class JsonWebTokenFilterNeeded implements ContainerRequestFilter {
    private static final String AUTHORIZATION_SERVICE_PATH = "login";
    private static final String PRIVATE_KEY = "privateKey";
    private JsonWebTokenHelper jwTokenHelper = JsonWebTokenHelper.getInstance();

    @Override
    public ContainerRequest filter(ContainerRequest request) {
        String path = request.getPath();

        System.err.println("Path is: " + path);

        if (path.equals(AUTHORIZATION_SERVICE_PATH))
            return request;

        String privateKeyHeaderValue = request.getHeaderValue(PRIVATE_KEY);
        if (privateKeyHeaderValue == null || privateKeyHeaderValue.isEmpty())
            throw new WebApplicationException(getUnAuthorizeResponse(PRIVATE_KEY + " is missing in header"));

        try {
            jwTokenHelper.claimKey(privateKeyHeaderValue);
        } catch (Exception e) {
            if (e instanceof ExpiredJwtException) {
                throw new WebApplicationException(getUnAuthorizeResponse(PRIVATE_KEY + " is expired"));
            } else if (e instanceof MalformedJwtException) {
                throw new WebApplicationException(getUnAuthorizeResponse(PRIVATE_KEY + " is not correct"));
            } else {
                e.printStackTrace();
                System.exit(11);    // ???
            }
        }

        return request;
    }

    private Response getUnAuthorizeResponse(String message) {
        return Response.ok(message)
                .status(Response.Status.UNAUTHORIZED)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
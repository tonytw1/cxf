package uk.co.eelpieconsulting.spike.cxf;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component("jsonExceptionMapper")
public class JsonExceptionMapper implements ExceptionMapper<WebApplicationException> {

	@Override
	public Response toResponse(WebApplicationException webApplicationException) {
		try {
			final Response originalResponse = webApplicationException.getResponse();		
			final String jsonEncodedEntity = new ObjectMapper().writeValueAsString(originalResponse.getEntity());
			
			System.out.println("Exception response entity remapped to JSON: " + jsonEncodedEntity);			
			return Response.status(originalResponse.getStatus()).entity(jsonEncodedEntity).type(MediaType.APPLICATION_JSON_TYPE).build();
		
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}

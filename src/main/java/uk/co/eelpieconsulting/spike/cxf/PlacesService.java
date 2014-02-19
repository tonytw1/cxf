package uk.co.eelpieconsulting.spike.cxf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("test")
public class PlacesService {
	
	@GET
	@Path("ok")
	@Produces(MediaType.APPLICATION_JSON)
	public Place getPlace() {
		return new Place(123, "N", null, "Somewhere", null, "place");
	}
	
	@GET
	@Path("fail")
	@Produces(MediaType.APPLICATION_JSON)
	public Place getFail() {
		throw new WebApplicationException(Response.status(422).entity("Something went wrong").build());
	}
	
}

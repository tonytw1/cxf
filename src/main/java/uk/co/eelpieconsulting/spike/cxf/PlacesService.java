package uk.co.eelpieconsulting.spike.cxf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;


@Component("placesService")
public class PlacesService {

	@GET
	@Path("/place")
	@Produces("application/json")
	public Place getPlace() {
		return new Place(123, "N", null, "Somewhere", null, "place");
	}
	
	@GET
	@Path("/fail")
	@Produces("application/json")
	public Place getFail() {
		throw new WebApplicationException(Response.status(422).entity("Something went wrong").build());
	}
	
}

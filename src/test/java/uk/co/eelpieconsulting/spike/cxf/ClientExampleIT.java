package uk.co.eelpieconsulting.spike.cxf;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.junit.Test;

import com.google.common.collect.Lists;

public class ClientExampleIT {

	@Test
	public void canFetchDomainObjectFromJsonService() throws Exception {
		List<JacksonJsonProvider> providers = Lists.newArrayList(new org.codehaus.jackson.jaxrs.JacksonJsonProvider());

		WebClient client = WebClient.create("http://localhost:9050", providers);
		client = client.accept("application/json").type("application/json").path("/place");
		
		Place place = client.get(Place.class);
		System.out.println(place);
		
		assertEquals("Somewhere", place.getAddress());
	}

}

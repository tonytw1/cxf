package uk.co.eelpieconsulting.spike.cxf;

import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {

	public MyApplication() {
		System.out.println("Registering jersey components");
		register(PlacesService.class);
	}
	
}

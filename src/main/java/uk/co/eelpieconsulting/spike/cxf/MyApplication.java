package uk.co.eelpieconsulting.spike.cxf;

import com.sun.jersey.api.core.PackagesResourceConfig;

public class MyApplication extends PackagesResourceConfig {

	public MyApplication() {
		super("uk.co.eelpieconsulting");		
		System.out.println("Registering jersey components");
	}
	
}

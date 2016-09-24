package com.aapkapainter.sync.resource;

import com.codahale.metrics.annotation.Timed;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ajay.kg created on 24/09/16.
 */
@Slf4j
@Path("/v1/sample")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {

	private final String template;

	public SampleResource(String template) {
		this.template = template;
	}

	@GET
	@Timed
	public Response sayHello(@QueryParam("name") String name) {
		final String value = String.format(template, name);
		log.info("query param : {}", name);
		Map<String, Object> objectMap = new HashMap<String, Object>();
		objectMap.put("name", value);
		objectMap.put("camelCase", "to_snake_style");
		objectMap.put("to_snake_style", "camelCase");
		return Response.ok(objectMap).build();
	}
}
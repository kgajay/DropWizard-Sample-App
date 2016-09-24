package com.aapkapainter.sync;

import com.aapkapainter.sync.health.DatabaseHealthCheck;
import com.aapkapainter.sync.model.DbHealthCheckDao;
import com.aapkapainter.sync.resource.SampleResource;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;
import org.skife.jdbi.v2.DBI;

/**
 * @author ajay.kg created on 24/09/16.
 */
@Slf4j
public class SyncApplication extends Application<SyncApplicationConfiguration> {


	@Override
	public String getName() {
		return "CRM Sync App";
	}

	@Override
	public void initialize(Bootstrap<SyncApplicationConfiguration> bootstrap) {
		// nothing to do yet
	}

	@Override
	public void run(SyncApplicationConfiguration syncApplicationConfiguration, Environment environment) throws Exception {
		environment.getObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

		final DBIFactory factory = new DBIFactory();
		final DBI dbi = factory.build(environment, syncApplicationConfiguration.getDatabase(), "mysql");

		final DbHealthCheckDao dbHealthCheckDao = dbi.onDemand(DbHealthCheckDao.class);
		environment.healthChecks().register("database", new DatabaseHealthCheck(syncApplicationConfiguration.getDatabase(), dbHealthCheckDao));

		final SampleResource sampleResource = new SampleResource(syncApplicationConfiguration.getTemplate());
		environment.jersey().register(sampleResource);
	}

	public static void main(final String[] args) throws Exception {
		log.info("Starting Sync Application");
		new SyncApplication().run("server", args[0]);
	}
}

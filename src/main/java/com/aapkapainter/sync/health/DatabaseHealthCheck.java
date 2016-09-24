package com.aapkapainter.sync.health;

import com.aapkapainter.sync.model.DbHealthCheckDao;
import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.db.DataSourceFactory;

/**
 * @author ajay.kg created on 24/09/16.
 */
public class DatabaseHealthCheck extends HealthCheck {

	private final DbHealthCheckDao dbHealthCheckDao;
	private final DataSourceFactory database;

	public DatabaseHealthCheck(DataSourceFactory database, DbHealthCheckDao dbHealthCheckDao) {
		this.dbHealthCheckDao = dbHealthCheckDao;
		this.database = database;
	}

	@Override
	protected Result check() throws Exception {
		if (dbHealthCheckDao.checkDb() > 0) {
			return Result.healthy();
		} else {
			return Result.unhealthy("Cannot connect to " + database.getUrl());
		}
	}
}
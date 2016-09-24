package com.aapkapainter.sync.model;

import org.skife.jdbi.v2.sqlobject.SqlQuery;

/**
 * @author ajay.kg created on 24/09/16.
 */
public interface DbHealthCheckDao {

	@SqlQuery("select 1")
	Integer checkDb();
}

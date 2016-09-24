package com.aapkapainter.sync;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author ajay.kg created on 24/09/16.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SyncApplicationConfiguration extends Configuration {

	@Valid
	@NotNull
	private DataSourceFactory database = new DataSourceFactory();

	@NotEmpty
	private String template;

}

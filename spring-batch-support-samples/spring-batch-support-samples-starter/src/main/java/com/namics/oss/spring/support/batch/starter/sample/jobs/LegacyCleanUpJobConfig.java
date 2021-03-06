/*
 * Copyright 2000-2014 Namics AG. All rights reserved.
 */

package com.namics.oss.spring.support.batch.starter.sample.jobs;

import com.namics.oss.spring.support.batch.tasklet.SpringBatchDatabaseCleanUpTasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;

/**
 * JobConfig.
 *
 * @author lboesch, Namics AG
 * @since 20.06.2014
 */
@Configuration
public class LegacyCleanUpJobConfig {

	@Inject
	protected JobBuilderFactory jobBuilders;
	@Inject
	protected StepBuilderFactory stepBuilders;
	@Inject
	protected JdbcTemplate jdbcTemplate;


	@Bean
	public Job batchSpringBatchDatabaseCleanUp() {
		return jobBuilders.get("batchSpringBatchDatabaseCleanUp")
		                  .start(stepBuilders.get("batchSpringBatchDatabaseCleanUpStep")
		                                     .tasklet(batchSpringBatchDatabaseCleanUpTasklet())
		                                     .build())
		                  .build();
	}

	@Bean
	public SpringBatchDatabaseCleanUpTasklet batchSpringBatchDatabaseCleanUpTasklet() {
		return new SpringBatchDatabaseCleanUpTasklet(10, jdbcTemplate);
	}
}

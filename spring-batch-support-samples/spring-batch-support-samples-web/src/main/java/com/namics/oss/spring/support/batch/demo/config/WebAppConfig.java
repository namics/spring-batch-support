/*
 * Copyright 2000-2014 Namics AG. All rights reserved.
 */

package com.namics.oss.spring.support.batch.demo.config;

import com.namics.oss.spring.support.batch.config.BatchConfig;
import com.namics.oss.spring.support.batch.web.config.SpringBatchSupportWebServletConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * WebAppConfig.
 *
 * @author lboesch, Namics AG
 * @since Feb 07, 2014
 */
@Configuration
@EnableScheduling
// Make sure DataSourceConfig with transactionManager bean configuration is loaded after BatchConfig.
// Otherwise the transactionManager Bean configuration in AbstractBatchConfiguration overrides the Bean definition which can lead to a circular reference.
@Import(value = {BatchConfig.class, DataSourceConfig.class, SpringBatchFactoryConfiguration.class, SpringBatchSupportWebServletConfig.class})
public class WebAppConfig {


}

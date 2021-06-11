package com.tenbes.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Allows us to configure spring app w/o using xml

@Configuration // this is java configuration, and these are the instructions
@EnableJpaRepositories(basePackages="com.tenbes.repository") // find all repos here spring
@EntityScan(basePackages="com.tenbes.entity") // find all packages here spring
public class ApplicationConfig {

}
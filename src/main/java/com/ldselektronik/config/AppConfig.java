package com.ldselektronik.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.ldselektronik")
@EnableAutoConfiguration
@Import({ DatabaseConfig.class })
public class AppConfig {

}

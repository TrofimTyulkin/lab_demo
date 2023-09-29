package me.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.annotation.Validated;


@Validated
@EnableJpaRepositories()
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public record ApplicationConfig() {

}

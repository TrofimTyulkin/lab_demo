package me.demo;

import me.demo.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class DemoApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(DemoApplication.class, args);
		System.out.println(ctx);
	}

}

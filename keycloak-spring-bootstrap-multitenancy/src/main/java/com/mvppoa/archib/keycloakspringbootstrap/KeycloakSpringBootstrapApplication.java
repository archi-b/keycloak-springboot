package com.mvppoa.archib.keycloakspringbootstrap;

import org.keycloak.adapters.springboot.MultitenantConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@ImportAutoConfiguration(MultitenantConfiguration.class)
@SpringBootApplication
public class KeycloakSpringBootstrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakSpringBootstrapApplication.class, args);
	}
}

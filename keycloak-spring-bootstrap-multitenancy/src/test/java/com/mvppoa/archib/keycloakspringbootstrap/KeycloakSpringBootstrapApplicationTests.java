package com.mvppoa.archib.keycloakspringbootstrap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RealmRepresentation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KeycloakSpringBootstrapApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testMasterRealm() {

		Keycloak keycloak = Keycloak.getInstance(
				"http://localhost:8080/auth",
				"master",
				"admin",
				"password",
				"admin-cli");
		RealmRepresentation realm = keycloak.realm("master").toRepresentation();
	}

}

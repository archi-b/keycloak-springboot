package com.mvppoa.archib.keycloakspringbootstrap.multitenancy.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.OIDCHttpFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mp26087
 */
public class KeycloakMultirealmResolverConfig implements KeycloakConfigResolver {

	private final Map<String, KeycloakDeployment> cache = new ConcurrentHashMap<String, KeycloakDeployment>();

	@Override
	public KeycloakDeployment resolve(OIDCHttpFacade.Request request) {

		String realm = request.getHeader("realm");
		KeycloakDeployment deployment = cache.get(realm);

		if (null == deployment) {
			// not found on the simple cache, try to load it from the file system
			InputStream is = getClass().getResourceAsStream("/keycloak-" + realm + ".json");
			if (is == null) {
				throw new IllegalStateException("Not able to find the file /keycloak-" + realm + ".json");
			}
			deployment = KeycloakDeploymentBuilder.build(is);
			cache.put(realm, deployment);
		}

		return deployment;
	}
}
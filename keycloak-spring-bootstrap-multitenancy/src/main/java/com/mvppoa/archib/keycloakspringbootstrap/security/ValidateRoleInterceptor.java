package com.mvppoa.archib.keycloakspringbootstrap.security;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ValidateRoleInterceptor extends HandlerInterceptorAdapter {

    public AccessToken getAccessToken(HttpServletRequest context) {
        KeycloakPrincipal principal = (KeycloakPrincipal)((KeycloakAuthenticationToken)context.getUserPrincipal()).getPrincipal();
        if (principal != null && principal.getKeycloakSecurityContext() != null) {
            return principal.getKeycloakSecurityContext().getToken();
        }
        return new AccessToken();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        AccessToken token = getAccessToken(request);

        /// Your others validations...

        return true;
    }

}

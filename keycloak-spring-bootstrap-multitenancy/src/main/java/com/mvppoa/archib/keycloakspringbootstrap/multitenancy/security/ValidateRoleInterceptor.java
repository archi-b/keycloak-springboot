package com.mvppoa.archib.keycloakspringbootstrap.multitenancy.security;

import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ValidateRoleInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AccessToken accessToken;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        AccessToken token = accessToken;

        /// Your others validations...

        return true;
    }

}

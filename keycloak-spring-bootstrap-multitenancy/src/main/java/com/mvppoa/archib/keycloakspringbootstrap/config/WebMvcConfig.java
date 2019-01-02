package com.mvppoa.archib.keycloakspringbootstrap.config;

import com.mvppoa.archib.keycloakspringbootstrap.security.ValidateRoleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new ValidateRoleInterceptor()).addPathPatterns("/**");
    }

}

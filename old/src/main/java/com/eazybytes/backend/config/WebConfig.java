package com.eazybytes.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configure API versioning for the application. In order for versioning to
     * be enabled, you must configure at least one way to resolve the API
     * version from a request (e.g. via request header).
     *
     * @param configurer
     * @since 7.0
     */
    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        WebMvcConfigurer.super.configureApiVersioning(configurer);
//        configurer.usePathSegment(2).addSupportedVersions("1.0", "2.0", "3.0");
        configurer.useQueryParam("version").addSupportedVersions("1.0", "2.0", "3.0");
    }
}

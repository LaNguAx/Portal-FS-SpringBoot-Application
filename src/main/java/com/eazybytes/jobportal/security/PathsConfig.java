package com.eazybytes.jobportal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PathsConfig {

    @Bean(name = "publicPaths")
    public List<String> publicPaths() {
        return List.of(
                "/api/contacts/public",
                "/api/auth/login/public",
                "/api/companies/public",
                "/api/auth/register/public",
                "/api/csrf-token/public",
                "/api/logging/public",
                "/api/swagger-ui.html",
                "/swagger-ui/**",
                "/api/v3/api-docs/**",
                "/swagger-resources/**",
                "/swagger-ui.html",
                "/webjars/**",
                "/jobportal/actuator/**",
                "/api/todos/**",
                "/api/posts/**"
        );
    }

    @Bean(name = "securedPaths")
    public List<String> securedPaths() {
        return List.of(
                "/api/**"
        );
    }

    @Bean(name = "jobseekerPaths")
    public List<String> jobseekerPaths() {
        return List.of(
                "/api/users/profile/jobseeker",
                "/api/users/profile/picture/jobseeker",
                "/api/users/profile/resume/jobseeker",
                "/api/users/saved-jobs/*/jobseeker",
                "/api/users/saved-jobs/jobseeker",
                "/api/users/job-applications/jobseeker",
                "/api/users/job-applications/*/jobseeker"
        );
    }

    @Bean(name = "employerPaths")
    public List<String> employerPaths() {
        return List.of(
                "/api/jobs/employer",
                "/api/jobs/*/status/employer",
                "/api/jobs/applications/*/employer",
                "/api/jobs/applications/employer"
        );
    }

    @Bean(name = "adminPaths")
    public List<String> adminPaths() {
        return List.of(
                "/api/contacts/admin",
                "/api/contacts/sort/admin",
                "/api/contacts/page/admin",
                "/api/contacts/*/status/admin",
                "/api/companies/admin",
                "/api/companies/*/admin",
                "/api/users/search/admin",
                "/api/users/*/role/employer/admin",
                "/api/users/*/company/*/admin"
        );
    }

}

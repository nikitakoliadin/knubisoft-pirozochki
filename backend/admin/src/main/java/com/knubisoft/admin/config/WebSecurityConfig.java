package com.knubisoft.admin.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.POST;

@Configuration(proxyBeanMethods = false)
public class WebSecurityConfig {
    private final AdminServerProperties adminServer;

    @Autowired
    public WebSecurityConfig(AdminServerProperties adminServer) {
        this.adminServer = adminServer;
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf((csrf) -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler()).ignoringRequestMatchers(
                                new AntPathRequestMatcher(this.adminServer.path("/instances"), POST.toString()),
                                new AntPathRequestMatcher(this.adminServer.path("/instances/*"), DELETE.toString()),
                                new AntPathRequestMatcher(this.adminServer.path("/actuator/**"))))
                .authorizeHttpRequests((authorizeRequests) -> authorizeRequests
                        .anyRequest().permitAll())
                .build();
    }

}
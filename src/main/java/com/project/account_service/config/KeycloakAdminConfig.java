package com.project.account_service.config;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class KeycloakAdminConfig {
    
    @Value("${keycloak.url}")
    private String url;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.admin.username}")
    private String username;

    @Value("${keycloak.admin.password}")
    private String password;

    @Bean
    public Keycloak keycloakAdminClient() {
        return KeycloakBuilder.builder()
                .serverUrl(url)
                .realm(realm)
                .clientId("admin-cli")
                .username(username)
                .password(password)
                .build();
    }
}

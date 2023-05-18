package com.example.project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("aTwitter API")
                        .description("Twitter-like application developed during Liga AC LABS 2023 @ Cognizant")
                        .version("1.0"));
    }
}
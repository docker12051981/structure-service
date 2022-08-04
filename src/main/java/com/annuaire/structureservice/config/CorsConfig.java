package com.annuaire.structureservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author karim hmadi

 * @description config cors origine

 */

@Configuration
public class CorsConfig {
/*
    @Bean
    public WebMvcConfigurer getCorsConfiguration(){
    return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            WebMvcConfigurer.super.addCorsMappings(registry);
            registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET","POST","DELETE","PUT")
                    .allowedHeaders("*");
        }
    };
    }*/
}

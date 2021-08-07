package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.example.backend.controller"}) // 하위 패키지 내부의 컴포넌트 스캔
public class WebConfig implements WebMvcConfigurer{
    /*
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**").allowCredentials(true).allowedOrigins("http://localhost:19000");
        registry.addMapping("/api/**").allowCredentials(true).allowedOrigins("exp://du-rad.kimyu0218.frontend.exp.direct:80");
        System.out.println("mapping...");
    }
    */
}

package com.lsm.ws.file.configuration.jwt;

import com.lsm.ws.file.configuration.properties.JwtProperties;
import com.lsm.ws.file.infrastructure.jwt.JwtAccessAspect;
import com.lsm.ws.file.infrastructure.rest.context.RequestContext;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JwtProperties.class)
public class JwtConfiguration {

    @Bean
    JwtAccessAspect jwtAccessAspect(RequestContext requestContext) {
        return new JwtAccessAspect(requestContext);
    }
}

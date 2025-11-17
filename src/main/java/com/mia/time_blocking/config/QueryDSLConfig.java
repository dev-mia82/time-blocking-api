package com.mia.time_blocking.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.text.html.parser.Entity;

@Configuration
@RequiredArgsConstructor
public class QueryDSLConfig {
    private final EntityManager em;

    @Bean
    public JPAQueryFactory getJPAQueryFactory() {
        return new JPAQueryFactory(em);
    }
}

package com.yvan.camel.configuration;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class CamelConfiguration {
    @Bean
    RoutesBuilder myRouter() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("jms:invoices").to("file:/invoices");
            }
        };
    }

    @Bean
    RoutesBuilder secondRouter() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("jms:invoices").to("file:/invoices");
            }
        };
    }



}

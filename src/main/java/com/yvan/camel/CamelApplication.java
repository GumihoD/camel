package com.yvan.camel;

import com.yvan.camel.route.processor.BeanProcessorLog2;
import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CamelApplication {

    private Logger logger = LoggerFactory.getLogger(CamelApplication.class);

    @Bean
    RoutesBuilder routesBuilder() {

        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("timer://timer2?period=2000").process(new BeanProcessorLog2());
            }
        };
    }

    @Bean
    CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext context) {
                // your custom configuration goes here
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {
            }
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(CamelApplication.class, args);
    }
}

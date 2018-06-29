package com.yvan.camel.route;

import com.yvan.camel.route.processor.BeanProcessorLog;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

    private Logger logger = LoggerFactory.getLogger(MyRoute.class);

    /**
     * from("{{route.from}}").to("{{route.to}}");
     */
    @Override
    public void configure() {
        from("timer://timer1?period=1000").process(new BeanProcessorLog());
    }

}

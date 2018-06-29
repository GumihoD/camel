package com.yvan.camel.route.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanProcessorLog implements Processor {

    Logger logger = LoggerFactory.getLogger(BeanProcessorLog.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("Processor out message:{}", exchange.getIn());
        String body = "new Body";
        exchange.getOut().setBody(body);
    }
}

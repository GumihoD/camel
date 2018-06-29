package com.yvan.camel.route.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanProcessorLog2 implements Processor {

    Logger logger = LoggerFactory.getLogger(BeanProcessorLog.class);

    @Override
    public void process(Exchange exchange) {
        logger.info("BeanProcessorLog2 :{}", exchange.getIn().getBody());
    }
}

package com.yvan.camel.route.processor;

import com.yvan.camel.route.Invoice;
import java.util.UUID;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceProcessor {
    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private TypeConverter typeConverter;

    @Autowired
    private ConsumerTemplate consumerTemplate;
    public void processNextInvoice() {
        Invoice invoice = consumerTemplate.receiveBody("jms:invoices", Invoice.class);
        producerTemplate.sendBody("netty-http:http://invoicing.com/received/" + invoice.getId());
    }

    public long parseInvoiceValue(Invoice invoice) {
        String invoiceValue = invoice.getGrossValue();
        return typeConverter.convertTo(Long.class, invoiceValue);
    }
}

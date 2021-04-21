package com.example.camelmicroservicea.utils;

import com.example.camelmicroservicea.beans.SimpleLogginProcessingComponent;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.util.Set;

public class SimpleLogginProcessor implements Processor {

    private Logger logger = LoggerFactory.getLogger(SimpleLogginProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {

        logger.info("SimpleLogginProcessor {}", exchange.getMessage().getBody());

    }
}

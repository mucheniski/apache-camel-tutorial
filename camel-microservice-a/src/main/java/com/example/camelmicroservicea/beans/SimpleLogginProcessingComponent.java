package com.example.camelmicroservicea.beans;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.stereotype.Component;

@Component
public class SimpleLogginProcessingComponent {

    private Logger logger = LoggerFactory.getLogger(SimpleLogginProcessingComponent.class);

    public void process(String message) {
        logger.info("SimpleLogginProcessingComponent {}", message);
    }

}

package com.example.camelmicroservicea.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:first-timer") // In this case is the queue
                .transform().constant("My Constant Message") // show in console Exchange[ExchangePattern: InOnly, BodyType: String, Body: My Constant Message]
                .to("log:first-timer"); // in this case is te database

    }
}

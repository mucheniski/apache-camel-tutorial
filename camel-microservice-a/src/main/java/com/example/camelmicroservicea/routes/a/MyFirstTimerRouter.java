package com.example.camelmicroservicea.routes.a;

import com.example.camelmicroservicea.beans.GetCurrentTimeBean;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;

    @Override
    public void configure() throws Exception {

        from("timer:first-timer") // In this case is the queue
                //.transform().constant("My Constant Message") // show in console Exchange[ExchangePattern: InOnly, BodyType: String, Body: My Constant Message]
                .bean(getCurrentTimeBean, "getCurrentTime")
                .to("log:first-timer"); // in this case is te database

    }

}
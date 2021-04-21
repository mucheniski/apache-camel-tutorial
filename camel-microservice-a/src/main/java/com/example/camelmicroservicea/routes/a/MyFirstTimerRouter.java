package com.example.camelmicroservicea.routes.a;

import com.example.camelmicroservicea.beans.GetCurrentTimeBean;
import com.example.camelmicroservicea.beans.SimpleLogginProcessingComponent;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;

    @Autowired
    private SimpleLogginProcessingComponent simpleLogginProcessingComponent;

    @Override
    public void configure() throws Exception {

        /*
        * if you make changes in the body is called Transformation, if not is calling procssing
        *
        * if de method of bean has a return, that changes body like getCurrentTimeBean
        * */
        from("timer:first-timer") // In this case is the queue
                .log("${body}")
                .transform().constant("My Constant Message") // show in console Exchange[ExchangePattern: InOnly, BodyType: String, Body: My Constant Message]
                .log("${body}")
                .bean(getCurrentTimeBean, "getCurrentTime")
                .log("${body}")
                .bean(simpleLogginProcessingComponent, "process")
                .log("${body}")
                .to("log:first-timer"); // in this case is te database

    }

}
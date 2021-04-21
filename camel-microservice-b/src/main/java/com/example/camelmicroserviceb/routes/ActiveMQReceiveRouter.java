package com.example.camelmicroserviceb.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQReceiveRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        /*
        * The name my-activemq-queue is the name of queue in ActiveMQ container running
        * */
        from("activemq:my-activemq-queue")
                .to("log:received-message-from-activemq");

    }
}

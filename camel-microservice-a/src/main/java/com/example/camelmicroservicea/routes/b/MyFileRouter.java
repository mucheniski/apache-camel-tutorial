package com.example.camelmicroservicea.routes.b;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

// https://github.com/in28minutes/camel

// @Component
public class MyFileRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        /*
        * when the process run, everting in puting in the input folger will be moved to output folder
        * */

        from("file:files/input")
                .log("${body}")
                .to("file:files/output");

    }

}

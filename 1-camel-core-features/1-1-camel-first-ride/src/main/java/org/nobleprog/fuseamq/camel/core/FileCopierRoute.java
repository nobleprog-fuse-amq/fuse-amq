package org.nobleprog.fuseamq.camel.core;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.concurrent.TimeUnit;

public class FileCopierRoute {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(createCamelRoute());
        camelContext.start();
        TimeUnit.SECONDS.sleep(2);
        camelContext.stop();

    }

    private static RouteBuilder createCamelRoute(){
        return new FileCopyingRoute();
    }

    private static class FileCopyingRoute extends RouteBuilder{

        public void configure() throws Exception {

            //from("file://camel-first-ride//src//main//resources//input")
            from("file://1-camel-core-features/1-1-camel-first-ride/src/main/resources/input?noop=true")
                    .log("${body}")
                    //TODO: Implement logging here by calling log() method, pass ${body} expression to log message body
                    .to("file://1-camel-core-features/1-1-camel-first-ride/src/main/resources/output")
                    .end();

        }
    }
}
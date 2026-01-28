package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import java.util.Map;

public class HelloLambda implements RequestHandler<Map<String, String>, String> {

    @Override
    public String handleRequest(Map<String, String> event, Context context) {
        LambdaLogger logger = context.getLogger();

        // Log incoming event
        logger.log("EVENT TYPE: " + event.getClass().toString());

        String name = event.getOrDefault("name", "Stranger");
        String response = "Hello, " + name + " from Lambda in Java 21!";

        return response;
    }
}
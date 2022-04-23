package com.bmw.config.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RestClientLoggingInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestClientLoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        ClientHttpResponse response = execution.execute(request, body);
        logRequestDetails(request, response);
        return response;
    }

    private void logRequestDetails(HttpRequest request, ClientHttpResponse response) throws IOException {
        LOGGER.info("Calling api: {}, method: {}", request.getURI(), request.getMethod().name());
        LOGGER.info("Api response status code: {}", response.getRawStatusCode());
    }
}

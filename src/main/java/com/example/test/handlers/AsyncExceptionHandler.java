package com.example.test.handlers;
import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    /**
     * Se reimplementa la excepción asíncrona tomando en cuenta el {@link Throwable}, {@link Method} y un {@link Object}
     */
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {

        // TODO: Enviar a logstash

        String methodName =String.format("Method name - %s", method.getName());
        for (Object param : obj) {
            String parameterValue = "Parameter value - " + param;
        }
    }

}

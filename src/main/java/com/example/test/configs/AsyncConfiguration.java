package com.example.test.configs;

import java.util.concurrent.Executor;

import com.example.test.handlers.AsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;



@Configuration
@EnableAsync
public class AsyncConfiguration implements AsyncConfigurer {

    /**
     * Nombre de la configuración asíncrona estándar
     */
    public final static String NOMBRE_ASINCRONO = "Async-Episode-Service";

    /**
     * Configuración genérica de los métodos asíncronos para el proyecto Admin
     * @return
     */
    @Bean(name = NOMBRE_ASINCRONO)
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(25);
        executor.setQueueCapacity(200);
        executor.setThreadNamePrefix("AsynchThread-" + NOMBRE_ASINCRONO);
        executor.initialize();
        return executor;
    }

    /**
     * Se implementa el método de excepciones personalizadas {@link AsyncExceptionHandler}
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }


}

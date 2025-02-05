package com.online.multishop;

import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class ThreadManager {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @PreDestroy
    public void shutdownExecutor() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}

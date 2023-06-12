package com.knubisoft.application.service;

import com.knubisoft.application.model.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService{
    @Async
    public CompletableFuture<Task> processTaskAsync(Task task) {
        log.info("Processing task asynchronously: {} - {}", task.getId(), task.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error("Task processing interrupted: {} - {}", task.getId(), task.getName());
        }
        log.info("Task processed asynchronously: {} - {}", task.getId(), task.getName());
        return CompletableFuture.completedFuture(task);
    }
}

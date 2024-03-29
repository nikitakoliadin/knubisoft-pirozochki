package com.knubisoft.application.service;

import com.knubisoft.application.model.Task;
import com.knubisoft.application.util.FireCpuLoadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private static final int FIVE_SECONDS = 5000;
    private final FireCpuLoadUtil cpuLoadUtil;
    @Async
    public CompletableFuture<Task> processTaskAsync(final Task task) {
        log.info("Processing task asynchronously: {} - {}", task.getId(), task.getName());
        try {
            Thread.sleep(FIVE_SECONDS);
            cpuLoadUtil.fireCpuLoad();
        } catch (InterruptedException e) {
            log.error("Task processing interrupted: {} - {}", task.getId(), task.getName());
        }
        log.info("Task processed asynchronously: {} - {}", task.getId(), task.getName());
        return CompletableFuture.completedFuture(task);
    }
}

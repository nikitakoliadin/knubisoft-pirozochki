package com.knubisoft.application.service;

import com.knubisoft.application.model.Task;

import java.util.concurrent.CompletableFuture;

public interface TaskService {
    CompletableFuture<Task> processTaskAsync(Task task);
}

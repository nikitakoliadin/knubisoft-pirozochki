package com.knubisoft.application.controllers;

import com.knubisoft.application.model.Task;
import com.knubisoft.application.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    @SneakyThrows
    public ResponseEntity<Task> createTask(@RequestBody final Task task) {
        CompletableFuture<Task> processedTask = taskService.processTaskAsync(task);
        return ResponseEntity.accepted().body(processedTask.get());
    }
}
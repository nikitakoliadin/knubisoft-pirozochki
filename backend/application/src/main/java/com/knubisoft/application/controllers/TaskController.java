package com.knubisoft.application.controllers;

import com.knubisoft.application.model.Task;
import com.knubisoft.application.service.TaskService;
import com.knubisoft.application.util.FireCpuLoadUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final FireCpuLoadUtil fireCpuLoadUtil;

    @PostMapping("/create")
    @SneakyThrows
    public ResponseEntity<Task> createTask(@RequestBody final Task task) {
        CompletableFuture<Task> processedTask = taskService.processTaskAsync(task);
        return ResponseEntity.accepted().body(processedTask.get());
    }

    @GetMapping("/getCPU")
    @SneakyThrows
    public ResponseEntity<String> getCpuLoader() {
        Double cpuLoader = fireCpuLoadUtil.getFireCpuLoader().get();
        return ResponseEntity.ok(cpuLoader.toString());
    }
}

package com.knubisoft.application;

import com.knubisoft.application.model.Task;
import com.knubisoft.application.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RequiredArgsConstructor
@TestPropertySource("classpath:test-application.properties")
public class SpringAsyncTest {
    @Autowired
    private TaskService taskService;
    @Test
    public void testProcessTaskAsync() throws Exception {
        Task task = new Task();
        task.setId("1");
        task.setName("Test Task");
        // Invoke the asynchronous method
        CompletableFuture<Task> futureTask = taskService.processTaskAsync(task);
        // Wait for the asynchronous processing to complete
        futureTask.get();

        // Add assertions to verify the result
        assertNotNull(task.getId());
        assertEquals("Test Task", task.getName());
    }
}

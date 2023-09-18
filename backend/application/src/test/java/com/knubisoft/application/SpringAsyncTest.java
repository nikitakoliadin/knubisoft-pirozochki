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

@SpringBootTest
@RequiredArgsConstructor
@TestPropertySource("classpath:test-application.properties")
public class SpringAsyncTest {

    @Autowired
    private TaskService taskService;

    @Test
    public void testProcessTaskAsync() throws Exception {
        Task firstTask = new Task();
        firstTask.setId("1");
        firstTask.setName("First Task");

        Task secondTask = new Task();
        secondTask.setId("2");
        secondTask.setName("Second Task");
        // Invoke the asynchronous method
        CompletableFuture<Task> futureFirstTask = taskService.processTaskAsync(firstTask);
        CompletableFuture<Task> futureSecondTask = taskService.processTaskAsync(secondTask);
        // Wait for the asynchronous processing to complete
        // Add assertions to verify the result
        assertNotNull(futureFirstTask.get().getId());
        assertEquals("First Task", futureFirstTask.get().getName());
        assertNotNull(futureSecondTask.get().getId());
        assertEquals("Second Task", futureSecondTask.get().getName());
    }
}

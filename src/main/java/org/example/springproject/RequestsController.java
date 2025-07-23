package org.example.springproject;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class RequestsController {

    private final TaskService taskService;

    @PostMapping
    public Task createAddTask(@RequestBody AddRequestDTO request)
    {
        return taskService.addTask(request);
    }

    @GetMapping
    public Task getTask(@RequestBody GetRequestDTO request) {
        return taskService.getTask(request);
    }
}

package org.example.springproject;

import org.example.springproject.Service.TaskModel;
import org.example.springproject.Service.TaskService;
import org.example.springproject.TaskDTO.AddTaskDTO;
import org.example.springproject.TaskDTO.DeleteTaskDTO;
import org.example.springproject.TaskDTO.GetTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskDataMapper taskDataMapper;

    public TaskController(TaskService taskService, TaskDataMapper taskDataMapper) {
        this.taskService = taskService;
        this.taskDataMapper = taskDataMapper;
    }

    @PostMapping
    public Task createAddTask(@RequestBody AddTaskDTO request) {
        TaskModel taskModel = taskDataMapper.toTaskModel(request);

        return taskService.addTask(taskModel);
    }

    @GetMapping
    public Optional<Task> getTask(@RequestBody GetTaskDTO request) {
        TaskModel taskModel = taskDataMapper.toTaskModel(request);
        return taskService.getTask(taskModel);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTask(@RequestParam String name) {
        DeleteTaskDTO deleteTaskDTO = new DeleteTaskDTO();
        deleteTaskDTO.setName(name);

        TaskModel taskModel = taskDataMapper.toTaskModel(deleteTaskDTO);
        taskService.deleteTask(taskModel);

        return ResponseEntity.noContent().build();
    }
}

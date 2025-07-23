package org.example.springproject;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class TaskService {
    private final TasksRepository tasksRepository;

    @Transactional
    public Task addTask(AddRequestDTO request) {
        Task task = new Task();
        task.setName(request.getName());
        task.setStatus(request.getStatus());
        return tasksRepository.save(task);
    }

    @Transactional
    public Task getTask(GetRequestDTO request) {
        Long id = request.getId();
        return tasksRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
    }

}

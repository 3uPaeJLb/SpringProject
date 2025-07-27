package org.example.springproject.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.springproject.Task;
import org.example.springproject.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TasksRepository tasksRepository;

    @Transactional
    public Task addTask(TaskModel taskModel) {
        Task task = new Task();
        task.setName(taskModel.getName());
        task.setStatus(taskModel.getStatus());
        return tasksRepository.save(task);
    }

    @Transactional
    public Optional<Task> getTask(TaskModel taskModel) {
        Long id = taskModel.getId();
        return tasksRepository.findById(id);
    }

    @Transactional
    public void deleteTask(TaskModel taskModel) {
        String name = taskModel.getName();
        tasksRepository.deleteByName(name);
    }
}

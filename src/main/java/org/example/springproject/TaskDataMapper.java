package org.example.springproject;

import org.example.springproject.Service.TaskModel;
import org.example.springproject.TaskDTO.AddTaskDTO;
import org.example.springproject.TaskDTO.DeleteTaskDTO;
import org.example.springproject.TaskDTO.GetTaskDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskDataMapper {
    TaskModel toTaskModel(AddTaskDTO addTaskDTO);
    TaskModel toTaskModel(GetTaskDTO addTaskDTO);
    TaskModel toTaskModel(DeleteTaskDTO addTaskDTO);
    AddTaskDTO toAddTaskDTO(TaskModel taskModel);
    GetTaskDTO toGetTaskDTO(TaskModel taskModel);
    DeleteTaskDTO toDeleteTaskDTO(TaskModel taskModel);
    Task toTask(TaskModel taskModel);
}

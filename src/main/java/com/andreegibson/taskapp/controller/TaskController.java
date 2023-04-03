package com.andreegibson.taskapp.controller;

import com.andreegibson.taskapp.model.Task;
import com.andreegibson.taskapp.service.TaskCrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskCrudService taskCrudService;

    @GetMapping
    public @ResponseBody List<Task> getAllTasks() {
        return taskCrudService.getAllTasks();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Task> getTaskById(@PathVariable String id) {
        return taskCrudService.getTaskById(id);
    }

    @PostMapping
    public @ResponseBody Task addTask(@RequestBody Task task) {
        return taskCrudService.addTask(task);
    }
}

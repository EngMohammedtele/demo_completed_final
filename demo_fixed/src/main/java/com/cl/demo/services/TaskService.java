package com.cl.demo.services;

import com.cl.demo.DemoApplication;
import com.cl.demo.entities.Task;
import com.cl.demo.requestobjects.TaskCreateRequest;
import com.cl.demo.requestobjects.TaskUpdateRequest;
import com.cl.demo.utils.HelperUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    public static final String TASK_SAVED = "Task saved";

    public Map<String, String> addTask(TaskCreateRequest request) {
        Map<String, String> response = new HashMap<>();
        if (request.getTitle() == null || request.getTitle().isBlank()) {
            response.put("error", "Task title is required");
            return response;
        }
        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setIsActive(Boolean.TRUE);
        task.setCreatedDate(new Date());
        task.setTaskNumber(generateTaskNumber());
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setDueDate(request.getDueDate());
        task.setStartDate(request.getStartDate());
        task.setTaskStatus(request.getTaskStatus());
        task.setIsAssigned(request.getIsAssigned());
        if (DemoApplication.Task_List.add(task)) response.put("response", TASK_SAVED);
        return response;
    }

    public Task getTaskById(String uuid) {
        for (Task task : DemoApplication.Task_List) {
            if (task.getId().toString().equals(uuid) && Boolean.TRUE.equals(task.getIsActive())) return task;
        }
        return new Task();
    }

    public List<Task> getAllTasks() {
        List<Task> result = new ArrayList<>();
        for (Task task : DemoApplication.Task_List) {
            if (Boolean.TRUE.equals(task.getIsActive())) result.add(task);
        }
        return result;
    }

    public Task updateTask(TaskUpdateRequest request) {
        Task task = getTaskById(request.getUuid());
        if (task.getId() == null) return task;
        task.setTitle(HelperUtils.compare(task.getTitle(), request.getTitleToUpdate()));
        task.setDescription(HelperUtils.compare(task.getDescription(), request.getDescriptionToUpdate()));
        task.setDueDate(HelperUtils.compare(task.getDueDate(), request.getDueDateToUpdate()));
        task.setStartDate(HelperUtils.compare(task.getStartDate(), request.getStartDateToUpdate()));
        task.setEndDate(HelperUtils.compare(task.getEndDate(), request.getEndDateToUpdate()));
        task.setTaskStatus(HelperUtils.compare(task.getTaskStatus(), request.getTaskStatusToUpdate()));
        task.setIsAssigned(HelperUtils.compare(task.getIsAssigned(), request.getIsAssignedToUpdate()));
        task.setUpdatedDate(new Date());
        return task;
    }

    public Boolean deleteById(String uuid) {
        Task task = getTaskById(uuid);
        if (task.getId() == null) return false;
        task.setIsActive(false);
        return true;
    }

    public String generateTaskNumber() {
        return "TASK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}

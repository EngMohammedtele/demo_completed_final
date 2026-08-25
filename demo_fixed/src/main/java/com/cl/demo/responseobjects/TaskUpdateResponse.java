package com.cl.demo.responseobjects;

import com.cl.demo.entities.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TaskUpdateResponse {
    private String taskId;
    private String title;
    private String description;
    private String taskNumber;
    private String taskStatus;
    private String dueDate;
    private Boolean isAssigned;

    public static TaskUpdateResponse convert(Task task) {
        TaskUpdateResponse response = new TaskUpdateResponse();
        if (task == null || task.getId() == null) return response;
        response.setTaskId(task.getId().toString());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setTaskNumber(task.getTaskNumber());
        response.setTaskStatus(task.getTaskStatus() == null ? null : task.getTaskStatus().toString());
        response.setDueDate(task.getDueDate() == null ? null : task.getDueDate().toString());
        response.setIsAssigned(task.getIsAssigned());
        return response;
    }

    public static List<TaskUpdateResponse> convert(List<Task> tasks) {
        List<TaskUpdateResponse> responses = new ArrayList<>();
        for (Task task : tasks) responses.add(convert(task));
        return responses;
    }
}

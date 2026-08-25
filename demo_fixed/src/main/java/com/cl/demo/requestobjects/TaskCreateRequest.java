package com.cl.demo.requestobjects;

import com.cl.demo.entities.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TaskCreateRequest {
    private String title;
    private String description;
    private Date dueDate;
    private Date startDate;
    private TaskStatus taskStatus;
    private Boolean isAssigned;
}

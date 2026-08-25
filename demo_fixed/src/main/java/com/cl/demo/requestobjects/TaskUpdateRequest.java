package com.cl.demo.requestobjects;

import com.cl.demo.entities.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TaskUpdateRequest {
    private String uuid;
    private String titleToUpdate;
    private String descriptionToUpdate;
    private Date dueDateToUpdate;
    private Date startDateToUpdate;
    private Date endDateToUpdate;
    private TaskStatus taskStatusToUpdate;
    private Boolean isAssignedToUpdate;
}

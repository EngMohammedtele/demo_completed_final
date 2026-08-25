package com.cl.demo.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Task extends BaseClass {
    private String title;
    private String description;
    private String taskNumber;
    private Date dueDate;
    private Date startDate;
    private Date endDate;
    private TaskStatus taskStatus;
    private Boolean isAssigned;

}

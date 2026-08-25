package com.cl.demo.controllers;

import com.cl.demo.requestobjects.TaskCreateRequest;
import com.cl.demo.requestobjects.TaskUpdateRequest;
import com.cl.demo.responseobjects.TaskCreateResponse;
import com.cl.demo.responseobjects.TaskUpdateResponse;
import com.cl.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    private TaskService taskService;

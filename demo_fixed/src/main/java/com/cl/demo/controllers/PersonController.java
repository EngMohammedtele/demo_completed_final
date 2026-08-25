package com.cl.demo.controllers;


import com.cl.demo.entities.Person;
import com.cl.demo.requestobjects.PersonCreateRequest;
import com.cl.demo.requestobjects.PersonUpdateRequest;
import com.cl.demo.responseobjects.PersonCreateResponse;
import com.cl.demo.responseobjects.PersonUpdateResponse;
import com.cl.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    public PersonService personService;


package com.cl.demo.requestobjects;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonCreateRequest {

    private String personFirstName;
    private String personLastName;
    private String personMiddleName;
